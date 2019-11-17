package co.kurapka.microservices.currencyconvertionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("co.kurapka.microservices.currencyconvertionservice")
public class CurrencyConvertionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertionServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
