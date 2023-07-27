package challenge.channel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import challenge.channel.business.service.intf.ChannelBusinessServiceInterface;
import challenge.channel.proxy.model.Pelicula;

@RestController
@RequestMapping("/api")
public class ChannelController {

    @Autowired
	private ChannelBusinessServiceInterface channelBusinessServiceInterface;

	@GetMapping("/peliculas/{id}")
	public ResponseEntity<Pelicula> getPelicula(@PathVariable Long id){
		Pelicula pelicula = channelBusinessServiceInterface.getPeliculaById(id);
		if(pelicula != null) {
			return ResponseEntity.ok(pelicula);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/peliculas")
	public ResponseEntity<List<Pelicula>> getAllPeliculas(){
		List<Pelicula> peliculas = channelBusinessServiceInterface.getAllPeliculas();
		if(!peliculas.isEmpty()) {
			return ResponseEntity.ok(peliculas);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/peliculas")
	public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula){
		Pelicula createdPelicula = channelBusinessServiceInterface.createPelicula(pelicula);
		if(createdPelicula != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPelicula);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/peliculas/{id}")
	public ResponseEntity<Pelicula> updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula){
		Pelicula updatedPelicula = channelBusinessServiceInterface.updatePelicula(id, pelicula);
		if(updatedPelicula != null) {
			return ResponseEntity.ok(updatedPelicula);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/peliculas/{id}")
	public ResponseEntity<Void> deletePelicula(@PathVariable Long id){
		boolean deletedPelicula = channelBusinessServiceInterface.deletePelicula(id);
		if(deletedPelicula) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
