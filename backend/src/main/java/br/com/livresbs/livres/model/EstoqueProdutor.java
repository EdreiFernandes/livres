package br.com.livresbs.livres.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Entity
@Table(name = "tb_estoque_produtor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueProdutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	@ManyToOne
	private Produto produto;
	
	@NotBlank
	@ManyToOne
	private Produtor produtor;
	
	@NotBlank
	@ManyToOne
	private UnidadeMedida unidadeMedida;
	
	@NotBlank
	private Integer quantidade;
	
	@NotBlank
	private BigDecimal preco;

	@ManyToMany(mappedBy = "estoques")
	private List<DataEntrega> datasEntrega;

}
