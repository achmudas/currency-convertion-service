package co.kurapka.microservices.currencyconvertionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConvertionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-convertion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrency(@PathVariable String from,
													@PathVariable String to,
													@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriParams = new HashMap<>();
		uriParams.put("from", from);
		uriParams.put("to", to);
		
		ResponseEntity<CurrencyConvertionBean> resp = new RestTemplate().
				getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConvertionBean.class, uriParams );
		
		return new CurrencyConvertionBean(
				resp.getBody().getId(), 
				resp.getBody().getFrom(), 
				resp.getBody().getTo(), 
				quantity, 
				resp.getBody().getConversionMultiple(), 
				quantity.multiply(resp.getBody().getConversionMultiple()), 
				resp.getBody().getPort());
	}
	
	@GetMapping("/currency-convertion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertionBean convertCurrencyFeign(@PathVariable String from,
													@PathVariable String to,
													@PathVariable BigDecimal quantity) {
		
		CurrencyConvertionBean resp = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConvertionBean(
				resp.getId(), 
				resp.getFrom(), 
				resp.getTo(), 
				quantity, 
				resp.getConversionMultiple(), 
				quantity.multiply(resp.getConversionMultiple()), 
				resp.getPort());
	}

}
