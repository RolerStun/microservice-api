package challenge.channel.proxy.model;

import lombok.Data;

@Data
public class Pelicula {

	private Long idPelicula;
	private String titulo;
	private Long anho;
	private Long minutosDuracion;
	private String descripcion;
}