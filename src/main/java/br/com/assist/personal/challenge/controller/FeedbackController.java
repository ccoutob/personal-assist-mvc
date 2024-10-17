package br.com.assist.personal.challenge.controller;

import br.com.assist.personal.challenge.model.Feedback;
import br.com.assist.personal.challenge.repository.FeedbackRepository;
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
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Feedback feedback){
        return "feedback/cadastro";
    }

    @GetMapping("listar") //localhost:8080/feedback/listar
    public String listar(Model model){
        //Enviar a lista de feedback para a view
        model.addAttribute("status", feedbackRepository.findAll());
        return "feedback/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o feedback pelo id e enviar o aluno para a view
        model.addAttribute("feedback", feedbackRepository.findById(id));
        //Retornar a view
        return "feedback/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Feedback feedback, RedirectAttributes redirectAttributes){
        feedbackRepository.save(feedback);
        redirectAttributes.addFlashAttribute("msg", "feedback atualizado");
        return "redirect:/feedback/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Feedback feedback, RedirectAttributes redirectAttributes){
        feedbackRepository.save(feedback);
        redirectAttributes.addFlashAttribute("msg", "feedback registrado!");
        return "redirect:/feedback/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        feedbackRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "feedback removido!");
        return "redirect:/feedback/listar";
    }
}
