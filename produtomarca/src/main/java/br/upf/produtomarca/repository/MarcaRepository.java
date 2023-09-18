package br.upf.produtomarca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.upf.produtomarca.dto.MarcaDTO;

public interface MarcaRepository extends JpaRepository<MarcaDTO, Long>{

}

