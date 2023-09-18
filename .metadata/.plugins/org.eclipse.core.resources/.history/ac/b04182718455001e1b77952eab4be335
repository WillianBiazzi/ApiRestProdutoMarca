package br.upf.produtomarca.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;	

//notações referente ao lombok
@Data //geters, seters, contrutores obrigatórios, toString, equals. 
@AllArgsConstructor //monta o contrutor com todos os atributos
@NoArgsConstructor //monta o contrutor sem argumentos
@EqualsAndHashCode

@Entity //definindo que é uma classe tipo entidade
@Table(name = "tb_marca")
public class MarcaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_nome", nullable = false)
    private String nome;

    @Column(name = "marca_descricao")
    private String descricao;
}