package com.example.gerenciamento_de_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.gerenciamento_de_estoque.model.Categoria;
import com.example.gerenciamento_de_estoque.repository.CategoriaRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias/index";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Categoria categoria, RedirectAttributes redirectAttributes) {
        categoriaRepository.save(categoria);
        redirectAttributes.addFlashAttribute("sucesso", "Categoria salva com sucesso!");
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("categoria", categoriaRepository.findById(id).orElseThrow());
        return "categorias/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            categoriaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", "Categoria deletada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não é possível deletar pois possui materiais vinculados!");
        }
        return "redirect:/categorias";
    }
}