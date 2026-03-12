package com.example.gerenciamento_de_estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.gerenciamento_de_estoque.model.Movimentacao;
import com.example.gerenciamento_de_estoque.repository.MaterialRepository;
import com.example.gerenciamento_de_estoque.repository.MovimentacaoRepository;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("movimentacoes", movimentacaoRepository.findAll());
        return "movimentacoes/index";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("movimentacao", new Movimentacao());
        model.addAttribute("materiais", materialRepository.findAll());
        return "movimentacoes/form";
    }

    @PostMapping("/salvar")
public String salvar(
        @RequestParam(required = false) Long materialId,
        @RequestParam(required = false) String tipo,
        @RequestParam(required = false) Integer quantidade,
        @RequestParam(required = false) String observacao,
        @RequestParam(required = false) Long material_id,
        RedirectAttributes redirectAttributes) {

    // Aceita tanto materialId quanto material.id
    Long idFinal = materialId != null ? materialId : material_id;

    if (idFinal == null) {
        redirectAttributes.addFlashAttribute("erro", "Selecione um material!");
        return "redirect:/movimentacoes/nova";
    }

    Movimentacao movimentacao = new Movimentacao();
    movimentacao.setMaterial(materialRepository.findById(idFinal).orElseThrow());
    movimentacao.setTipo(tipo);
    movimentacao.setQuantidade(quantidade);
    movimentacao.setObservacao(observacao);

    movimentacaoRepository.save(movimentacao);
    redirectAttributes.addFlashAttribute("sucesso", "Movimentação registrada com sucesso!");
    return "redirect:/movimentacoes";
}

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            movimentacaoRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", "Movimentação deletada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao deletar movimentação!");
        }
        return "redirect:/movimentacoes";
    }
}