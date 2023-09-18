package br.upf.produtomarca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.upf.produtomarca.dto.ProdutoDTO;
import br.upf.produtomarca.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	public List<ProdutoDTO> listarTodos(){
		return ProdutoRepository.findAll();
	}
	
	public ProdutoDTO salvar(ProdutoDTO dto) {
		return ProdutoRepository.save(dto);
	}
	
	public Optional<ProdutoDTO> buscarPorId(Long id) {
		return ProdutoRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		ProdutoRepository.deleteById(id);
	}

}