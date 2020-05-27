package br.com.livresbs.livres.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_data_entrega")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataEntrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private PreComunidade precomunidade;
	
	@NotBlank
	private Date prazo;
	
	@NotBlank
	private Date prazoLimitePedido;
	
}
