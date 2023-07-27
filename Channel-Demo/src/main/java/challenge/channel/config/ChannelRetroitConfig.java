package challenge.channel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import challenge.channel.proxy.service.intf.ChannelProxyServiceInterface;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class ChannelRetroitConfig {

	@Value("http://localhost:8080")
	private String channelServiceUrl;
	
	@Bean
	public Retrofit retrofit() {
		return new Retrofit.Builder()
				.baseUrl(channelServiceUrl)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();
	}
	
	@Bean
	public ChannelProxyServiceInterface channelProxyServiceInterface(Retrofit refrofit) {
		return refrofit.create(ChannelProxyServiceInterface.class);
	}
	
}
