package in.kkpit.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.kkpit.dto.LoginFormDTO;
import in.kkpit.dto.QuoteApiResponseDTO;
import in.kkpit.dto.RegistrationFormDTO;
import in.kkpit.dto.ResetPwdFormDTO;
import in.kkpit.dto.UserDTO;
import in.kkpit.service.DashboardService;
import in.kkpit.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/")
	public String kk(Model model) {
		LoginFormDTO loginFormDTO = new LoginFormDTO();
		model.addAttribute("loginForm", loginFormDTO);
		return "login";
	}
	
	@GetMapping("/home")
	public String index(Model model) {
		LoginFormDTO loginFormDTO = new LoginFormDTO();
		model.addAttribute("loginForm", loginFormDTO);
		return "index";
	}
	@GetMapping("/register")
	public String loadRegisterPage(Model model) {
		Map<Integer, String> countriesMap = userService.getCountries();
		model.addAttribute("countries", countriesMap);

		RegistrationFormDTO registerFormDTO = new RegistrationFormDTO();
		model.addAttribute("registerForm", registerFormDTO);
		return "register";
	}

	@GetMapping("/states/{country_Id}")
	@ResponseBody
	public Map<Integer, String> getStates(@PathVariable Integer country_Id, Model model) {
		Map<Integer, String> statesMap = userService.getStates(country_Id);
		model.addAttribute("states", statesMap);

		return statesMap;
	}

	@GetMapping("/cities/{state_Id}")
	@ResponseBody
	public Map<Integer, String> getCities(@PathVariable Integer state_Id, Model model) {
		Map<Integer, String> citisMap = userService.getStates(state_Id);
		model.addAttribute("cities", citisMap);

		return citisMap;
	}

	@PostMapping("/register")
	public String handleRegistration(RegistrationFormDTO registrationDTO, Model model) {
		boolean status = userService.duplicateEmailCheck(registrationDTO.getEmail());
		if (status) {
			model.addAttribute("emsg", "Duplicate mail found");
		} else {
			boolean saveUser = userService.saveUser(registrationDTO);

			if (saveUser) {
				// saved
				model.addAttribute("smsg", "Registration Successfull Plz. check your Email");

			} else {
				// failed
				model.addAttribute("emsg", "Registration Failed");

			}
		}
		model.addAttribute("countries", userService.getCountries());
		return "register";
	}

	

	@PostMapping("/login")
	public String handleUserLogin(LoginFormDTO loginFormDTO, Model model) {
		UserDTO userDTO = userService.login(loginFormDTO);

		if (userDTO == null) {
			model.addAttribute("emsg", "Invalid Credential");
		} else {
			String pwd_Reset = userDTO.getPwd_Reset();
			if ("Yes".equals(pwd_Reset)) {
				// display dashboard
				return "redirect:dashboard";
			} else {
				// display reset pwd page
				return "redict:reset-pwd-page?email=" + userDTO.getEmail();
			}
		}
		return "login";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		QuoteApiResponseDTO quoteApiResponseDTO = dashboardService.getQuote();
		model.addAttribute(quoteApiResponseDTO);
		return "dashboard";
	}

	@GetMapping("/reset-pwd-page")
	public String loadResetPwdPage(@RequestParam("Email") String Email, Model model) {
		ResetPwdFormDTO resetPwdFormDTO = new ResetPwdFormDTO();
		resetPwdFormDTO.setEmail(Email);
		return "resetPwd";
	}

	@PostMapping("/resetPwd")
	public String handlePwdReset(ResetPwdFormDTO resetPwdFormDTO, Model model) {
		boolean resetPwd = userService.resetPwd(resetPwdFormDTO);
		if (resetPwd) {
			return "redirect:dashboard";
		}
		return "resetPwd";
	}

}
