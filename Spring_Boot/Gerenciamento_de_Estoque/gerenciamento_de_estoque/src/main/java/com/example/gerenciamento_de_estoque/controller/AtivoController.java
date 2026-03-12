package com.example.gerenciamento_de_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.gerenciamento_de_estoque.model.Ativo;
import com.example.gerenciamento_de_estoque.repository.AtivoRepository;

@Controller
@RequestMapping("/ativos")
public class AtivoController {

    @Autowired
    private AtivoRepository ativoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ativos", ativoRepository.findAll());
        return "ativos/index";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("ativo", new Ativo());
        return "ativos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Ativo ativo, RedirectAttributes redirectAttributes) {
        ativoRepository.save(ativo);
        redirectAttributes.addFlashAttribute("sucesso", "Ativo salvo com sucesso!");
        return "redirect:/ativos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("ativo", ativoRepository.findById(id).orElseThrow());
        return "ativos/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            ativoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", "Ativo deletado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao deletar ativo!");
        }
        return "redirect:/ativos";
    }
}