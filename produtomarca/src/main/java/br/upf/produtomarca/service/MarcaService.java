package br.upf.produtomarca.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upf.produtomarca.dto.MarcaDTO;
import br.upf.produtomarca.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository MarcaRepository;
	
	public MarcaDTO salvar(MarcaDTO dto) {
		return MarcaRepository.save(dto);
	}
	
	public List<MarcaDTO> listarTodos(){
		return MarcaRepository.findAll();
	}
	
	public Optional<MarcaDTO> buscarPorId(Long id) {
		return MarcaRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		MarcaRepository.deleteById(id);
	}
	
}