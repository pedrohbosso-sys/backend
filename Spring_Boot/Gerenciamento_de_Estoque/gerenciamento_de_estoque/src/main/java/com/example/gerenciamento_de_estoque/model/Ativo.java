package com.example.gerenciamento_de_estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ativos_patrimoniais")
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String numeroPatrimonio;

    @Column(length = 200)
    private String descricao;

    private String localizacao;

    private String status;

    private LocalDate dataAquisicao;

    private BigDecimal valorAquisicao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroPatrimonio() { return numeroPatrimonio; }
    public void setNumeroPatrimonio(String n) { this.numeroPatrimonio = n; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(LocalDate d) { this.dataAquisicao = d; }
    public BigDecimal getValorAquisicao() { return valorAquisicao; }
    public void setValorAquisicao(BigDecimal v) { this.valorAquisicao = v; }
}