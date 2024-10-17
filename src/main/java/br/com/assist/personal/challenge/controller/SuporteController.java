package br.com.assist.personal.challenge.controller;

import br.com.assist.personal.challenge.model.suporte.StatusTicket;
import br.com.assist.personal.challenge.model.suporte.Suporte;
import br.com.assist.personal.challenge.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("suporte")
public class SuporteController {

    @Autowired
    private SuporteRepository suporteRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Suporte suporte, Model model){
        //Enviar as constantes para a página
        model.addAttribute("valorStatus", StatusTicket.values());
        return "suporte/cadastro";
    }

    @GetMapping("listar") //localhost:8080/suporte/listar
    public String listar(Model model){
        //Enviar a lista de suporte para a view
        model.addAttribute("status", suporteRepository.findAll());
        return "suporte/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o suporte pelo id e enviar o aluno para a view
        model.addAttribute("suporte", suporteRepository.findById(id));
        model.addAttribute("valorStatus", StatusTicket.values());
        //Retornar a view
        return "suporte/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Suporte suporte, RedirectAttributes redirectAttributes){
        suporteRepository.save(suporte);
        redirectAttributes.addFlashAttribute("msg", "suporte atualizado");
        return "redirect:/suporte/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Suporte suporte, RedirectAttributes redirectAttributes){
        suporteRepository.save(suporte);
        redirectAttributes.addFlashAttribute("msg", "suporte registrado!");
        return "redirect:/suporte/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        suporteRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "suporte removido!");
        return "redirect:/suporte/listar";
    }
}
