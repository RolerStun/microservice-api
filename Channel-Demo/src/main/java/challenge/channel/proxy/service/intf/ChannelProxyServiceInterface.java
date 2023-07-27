package challenge.channel.proxy.service.intf;

import java.util.List;

import challenge.channel.proxy.model.Pelicula;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ChannelProxyServiceInterface {
	
	@GET("/api/support/peliculas/{id}")
	Call<Pelicula> getPeliculaById(@Path("id") Long id);

	@GET("/api/support/peliculas")
	Call<List<Pelicula>> getAllPeliculas();
	
	@POST("/api/support/peliculas")
	Call<Pelicula> createPelicula(@Body Pelicula pelicula);
	
	@PUT("/api/support/peliculas/{id}")
	Call<Pelicula> updatePelicula(@Path("id") Long id, @Body Pelicula pelicula);
	
	@DELETE("/api/support/peliculas/{id}")
	Call<Void> deletePelicula(@Path("id") Long id);
	
}
