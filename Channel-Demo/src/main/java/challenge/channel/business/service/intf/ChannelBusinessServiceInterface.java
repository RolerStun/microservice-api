package challenge.channel.business.service.intf;

import java.util.List;

import challenge.channel.proxy.model.Pelicula;

public interface ChannelBusinessServiceInterface {
	
	Pelicula getPeliculaById(Long id);
	
	List<Pelicula> getAllPeliculas();
	
	Pelicula createPelicula(Pelicula pelicula);
	
	Pelicula updatePelicula(Long id, Pelicula pelicula);
	
	boolean deletePelicula(Long id);
	
}
