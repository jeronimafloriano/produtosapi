package io.github.spring.produtosapi.controller;

import io.github.spring.produtosapi.model.Produto;
import io.github.spring.produtosapi.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        repository.save(produto);
        return produto;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscar(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(repository.findByNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable UUID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Produto> atualizar(@PathVariable UUID id, @RequestBody Produto produto) {
        return repository.findById(id).map(p -> {
            produto.setId(id);
            repository.save(produto);
            return ResponseEntity.ok(produto);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
