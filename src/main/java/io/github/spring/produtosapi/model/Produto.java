package io.github.spring.produtosapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @Column(name = "descricao")
    private String desccricaoProduto;
    private BigDecimal preco;

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDesccricao() {
        return desccricaoProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesccricaoProduto(String desccricaoProduto) {
        this.desccricaoProduto = desccricaoProduto;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desccricao='" + desccricaoProduto + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }
}
