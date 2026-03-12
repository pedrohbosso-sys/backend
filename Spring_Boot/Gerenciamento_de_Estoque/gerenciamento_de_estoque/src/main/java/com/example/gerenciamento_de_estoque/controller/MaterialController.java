package com.example.gerenciamento_de_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.gerenciamento_de_estoque.model.Material;
import com.example.gerenciamento_de_estoque.repository.CategoriaRepository;
import com.example.gerenciamento_de_estoque.repository.MaterialRepository;
import com.example.gerenciamento_de_estoque.repository.MovimentacaoRepository;

@Controller
@RequestMapping("/materiais")
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("materiais", materialRepository.findAll());
        return "materiais/index";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("material", new Material());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "materiais/form";
    }

    @PostMapping("/salvar")
    public String salvar(
            @RequestParam String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam Integer quantidade,
            @RequestParam Integer quantidadeMinima,
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) Long id,
            RedirectAttributes redirectAttributes) {

        Material material = id != null
                ? materialRepository.findById(id).orElse(new Material())
                : new Material();

        material.setNome(nome);
        material.setDescricao(descricao);
        material.setQuantidade(quantidade);
        material.setQuantidadeMinima(quantidadeMinima);

        if (categoriaId != null) {
            material.setCategoria(categoriaRepository.findById(categoriaId).orElse(null));
        }

        materialRepository.save(material);
        redirectAttributes.addFlashAttribute("sucesso", "Material salvo com sucesso!");
        return "redirect:/materiais";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("material", materialRepository.findById(id).orElseThrow());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "materiais/form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            movimentacaoRepository.deleteAll(
                movimentacaoRepository.findAll().stream()
                    .filter(m -> m.getMaterial() != null && m.getMaterial().getId().equals(id))
                    .toList()
            );
            materialRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", "Material deletado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao deletar material!");
        }
        return "redirect:/materiais";
    }
}