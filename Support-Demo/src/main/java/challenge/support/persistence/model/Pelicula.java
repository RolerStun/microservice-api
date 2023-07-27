package challenge.support.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pelicula {

	@Id
	private Long idPelicula;
	private String titulo;
	private Long anho;
	private Long minutosDuracion;
	private String descripcion;
}
