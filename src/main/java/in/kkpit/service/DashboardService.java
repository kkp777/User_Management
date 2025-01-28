package in.kkpit.service;

import org.springframework.stereotype.Service;

import in.kkpit.dto.QuoteApiResponseDTO;

public interface DashboardService {
	public QuoteApiResponseDTO getQuote();
	
}
