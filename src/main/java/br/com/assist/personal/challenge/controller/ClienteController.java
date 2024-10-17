package br.com.assist.personal.challenge.controller;

import br.com.assist.personal.challenge.model.Cliente;
import br.com.assist.personal.challenge.model.Estatistica;
import br.com.assist.personal.challenge.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Cliente cliente){
        return "cliente/cadastro";
    }

    @GetMapping("listar") //localhost:8080/cliente/listar
    public String listar(Model model){
        //Enviar a lista de clientes para a view
        model.addAttribute("status", clienteRepository.findAll());
        return "cliente/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o ciente pelo id e enviar o aluno para a view
        model.addAttribute("cliente", clienteRepository.findById(id));
        //Retornar a view
        return "cliente/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid Cliente cliente, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "cliente/editar";
        }
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("msg", "Cliente atualizado");
        return "redirect:/cliente/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Cliente cliente, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model){
        if (bindingResult.hasErrors()){
            return "cliente/editar";
        }
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("msg", "Cliente registrado!");
        return "redirect:/cliente/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        clienteRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Cliente removido!");
        return "redirect:/cliente/listar";
    }
}
