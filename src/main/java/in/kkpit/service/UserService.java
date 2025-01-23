package in.kkpit.service;

import java.util.Map;

import in.kkpit.dto.LoginFormDTO;
import in.kkpit.dto.RegistrationFormDTO;
import in.kkpit.dto.ResetPwdFormDTO;
import in.kkpit.dto.UserDTO;

public interface UserService {
	public Map<Integer,String> getCountries();
	public Map<Integer,String> getStates(Integer countryId);
	public Map<Integer,String> getCities(Integer stateId);
	public boolean duplicateEmailCheck(String email);
	public boolean saveUser(RegistrationFormDTO regFormDTO);
	public UserDTO login(LoginFormDTO loginFormDTO);
	public boolean resetPwd(ResetPwdFormDTO resetPwdDTO);

}
