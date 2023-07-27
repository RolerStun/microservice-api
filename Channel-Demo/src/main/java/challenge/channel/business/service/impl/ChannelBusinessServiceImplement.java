package challenge.channel.business.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.channel.business.service.intf.ChannelBusinessServiceInterface;
import challenge.channel.proxy.model.Pelicula;
import challenge.channel.proxy.service.intf.ChannelProxyServiceInterface;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class ChannelBusinessServiceImplement implements ChannelBusinessServiceInterface {

	@Autowired
	private ChannelProxyServiceInterface channelProxyServiceInterface;

	@Override
	public Pelicula getPeliculaById(Long id) {
		Call<Pelicula> peliculaCall = channelProxyServiceInterface.getPeliculaById(id);

		try {
			Response<Pelicula> response = peliculaCall.execute();

			if (response.isSuccessful()) {
				return response.body();
			} else {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Pelicula> getAllPeliculas() {
		Call<List<Pelicula>> peliculasCall = channelProxyServiceInterface.getAllPeliculas();

		try {
			Response<List<Pelicula>> response = peliculasCall.execute();

			if (response.isSuccessful()) {
				return response.body();
			} else {
				return Collections.emptyList();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public Pelicula createPelicula(Pelicula pelicula) {
		Call<Pelicula> createCall = channelProxyServiceInterface.createPelicula(pelicula);

		try {
			Response<Pelicula> response = createCall.execute();

			if (response.isSuccessful()) {
				return response.body();
			} else {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Pelicula updatePelicula(Long id, Pelicula pelicula) {
		Call<Pelicula> updateCall = channelProxyServiceInterface.updatePelicula(id, pelicula);

		try {
			Response<Pelicula> response = updateCall.execute();

			if (response.isSuccessful()) {
				return response.body();
			} else {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deletePelicula(Long id) {
		Call<Void> deleteCall = channelProxyServiceInterface.deletePelicula(id);

		try {
			Response<Void> response = deleteCall.execute();

			if (response.isSuccessful()) {
				response.body();
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
