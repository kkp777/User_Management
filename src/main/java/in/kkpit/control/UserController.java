package in.kkpit.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import in.kkpit.dto.RegistrationFormDTO;
import in.kkpit.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String loadRegisterPage(Model model) {
		Map<Integer, String> countriesMap = userService.getCountries();
		model.addAttribute("countries",countriesMap);
		
		RegistrationFormDTO registerFormDTO=new RegistrationFormDTO();
		model.addAttribute("registerForm",registerFormDTO);
		return "register";
	}
	
	@GetMapping("/states/{country_Id}")
	@ResponseBody
	public Map<Integer, String> getStates(@PathVariable Integer country_Id,Model model) {
		Map<Integer, String> statesMap = userService.getStates(country_Id);
		model.addAttribute("states",statesMap);
		
		return statesMap;
	}
	
	@GetMapping("/states/{state_Id}")
	@ResponseBody
	public Map<Integer, String> getCities(@PathVariable Integer state_Id,Model model) {
		Map<Integer, String> citisMap = userService.getStates(state_Id);
		model.addAttribute("cities",citisMap);
		
		return citisMap;
	}
	
	

}
