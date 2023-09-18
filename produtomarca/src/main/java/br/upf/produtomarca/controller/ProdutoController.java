package br.upf.produtomarca.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.upf.produtomarca.dto.ProdutoDTO;
import br.upf.produtomarca.service.ProdutoService;
import br.upf.produtomarca.utils.TokenJWT;

@RestController
@RequestMapping(value = "/produtomarca/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService ProdutoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/listarTodos")
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> listarTodos(
            @RequestHeader(value = "token") String token) {
        TokenJWT.validarToken(token);
        return ProdutoService.listarTodos();
    }

    @PostMapping(value = "/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO inserir(@RequestBody ProdutoDTO dto,
            @RequestHeader(value = "token") String token) {
        TokenJWT.validarToken(token);
        return ProdutoService.salvar(dto);
    }

    @GetMapping(value = "/buscarPorId")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDTO buscarPorId(
            @RequestHeader(value = "id") Long id,
            @RequestHeader(value = "token") String token) {
        TokenJWT.validarToken(token);
        return ProdutoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Produto não encontrado."));
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProduto(
            @RequestHeader(value = "id") Long id,
            @RequestHeader(value = "token") String token) {
        TokenJWT.validarToken(token);
        ProdutoService.buscarPorId(id)
                .ifPresentOrElse(produto -> {
                    ProdutoService.removerPorId(produto.getId());
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado.");
                });
    }

    @PutMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestBody ProdutoDTO ProdutoDTO,
            @RequestHeader(value = "token") String token) {
        TokenJWT.validarToken(token);
        ProdutoService.buscarPorId(ProdutoDTO.getId())
                .ifPresentOrElse(produtoBase -> {
                    modelMapper.map(ProdutoDTO, produtoBase);
                    ProdutoService.salvar(produtoBase);
                }, () -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Produto não encontrado.");
                });
    }
}