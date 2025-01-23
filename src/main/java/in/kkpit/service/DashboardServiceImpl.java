package in.kkpit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.kkpit.dto.QuoteApiResponseDTO;

public class DashboardServiceImpl implements DashboardService {
	
	private String quoteApiURL="https://dummyjson.com/quotes/random";
	@Override
	public QuoteApiResponseDTO getQuote() {
		
		RestTemplate ret=new RestTemplate();
		 ResponseEntity<QuoteApiResponseDTO> forEntity = ret.getForEntity(quoteApiURL,QuoteApiResponseDTO.class);
		 QuoteApiResponseDTO body = forEntity.getBody();
		return body;
	}

}
