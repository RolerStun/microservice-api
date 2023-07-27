package challenge.channel.proxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.channel.proxy.model.Pelicula;
import challenge.channel.proxy.service.intf.ChannelProxyServiceInterface;
import retrofit2.Call;
import retrofit2.Retrofit;

@Service
public class ChannelProxyServiceImplement implements ChannelProxyServiceInterface{
	
	@Autowired
	private Retrofit retrofit;

	@Override
	public Call<Pelicula> getPeliculaById(Long id) {
		return retrofit.create(ChannelProxyServiceInterface.class).getPeliculaById(id);
	}

	@Override
	public Call<List<Pelicula>> getAllPeliculas() {
		return retrofit.create(ChannelProxyServiceInterface.class).getAllPeliculas();
	}

	@Override
	public Call<Pelicula> createPelicula(Pelicula pelicula) {
		return retrofit.create(ChannelProxyServiceInterface.class).createPelicula(pelicula);
	}

	@Override
	public Call<Pelicula> updatePelicula(Long id, Pelicula pelicula) {
		return retrofit.create(ChannelProxyServiceInterface.class).updatePelicula(id, pelicula);
	}

	@Override
	public Call<Void> deletePelicula(Long id) {
		return retrofit.create(ChannelProxyServiceInterface.class).deletePelicula(id);
	}

}
