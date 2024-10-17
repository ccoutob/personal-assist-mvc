package br.com.assist.personal.challenge.controller;

import br.com.assist.personal.challenge.model.Estatistica;
import br.com.assist.personal.challenge.repository.EstatisticaRepository;
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
@RequestMapping("estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaRepository estatisticaRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Estatistica estatistica){
        return "estatistica/cadastro";
    }

    @GetMapping("listar") //localhost:8080/estatistica/listar
    public String listar(Model model){
        //Enviar a lista de estatisticas para a view
        model.addAttribute("status", estatisticaRepository.findAll());
        return "estatistica/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar a estatistica pelo id e enviar o aluno para a view
        model.addAttribute("estatistica", estatisticaRepository.findById(id));
        //Retornar a view
        return "estatistica/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Estatistica estatistica, RedirectAttributes redirectAttributes){
        estatisticaRepository.save(estatistica);
        redirectAttributes.addFlashAttribute("msg", "Estatistica atualizada");
        return "redirect:/estatistica/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Estatistica estatistica, RedirectAttributes redirectAttributes){
        estatisticaRepository.save(estatistica);
        redirectAttributes.addFlashAttribute("msg", "Estatistica registrada!");
        return "redirect:/estatistica/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        estatisticaRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Estatistica removida!");
        return "redirect:/estatistica/listar";
    }
}
