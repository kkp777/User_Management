package in.kkpit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import in.kkpit.dto.LoginFormDTO;
import in.kkpit.dto.RegistrationFormDTO;
import in.kkpit.dto.ResetPwdFormDTO;
import in.kkpit.dto.UserDTO;
import in.kkpit.entity.City_Master;
import in.kkpit.entity.Country_Master;
import in.kkpit.entity.State_Master;
import in.kkpit.entity.User_Master;
import in.kkpit.repo.CityRepository;
import in.kkpit.repo.CountryRepository;
import in.kkpit.repo.StateRepository;
import in.kkpit.repo.UserRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public Map<Integer, String> getCountries() {
		Map<Integer,String>countriesMap=new HashMap<>();
		List<Country_Master> countriesList = countryRepository.findAll();
		countriesList.forEach(c->{
			countriesMap.put(c.getCountry_Id(),c.getCountry_Name());
		});
		return countriesMap;
	}

	@Override
	public Map<Integer,String> getStates(Integer countryId) {
		Map<Integer,String>statesMap=new HashMap<>();
		 List<State_Master> statesList = stateRepository.findByCountryId(countryId);
		statesList.stream().forEach(s->{
			statesMap.put(s.getState_Id(),s.getState_Name());
		});
		return statesMap;
		
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		Map<Integer,String>citiesMap=new HashMap<>();
		List<City_Master> citiesList = cityRepository.findByStateId(stateId);
		
		citiesList.forEach(c->{
			citiesMap.put(c.getCity_Id(),c.getCity_Name());
		});
		return citiesMap;
	}

	@Override
	public boolean duplicateEmailCheck(String email) {
		User_Master byEmail = userRepository.findByEmail(email);
		return byEmail != null;
	}

	@Override
	public boolean saveUser(RegistrationFormDTO regFormDTO) {
		User_Master userMaster=new User_Master();
		BeanUtils.copyProperties(regFormDTO, userMaster);
		Country_Master country = countryRepository.findById(regFormDTO.getCountry_Id()).orElse(null);
		userMaster.setCountry(country);
		
		State_Master state = stateRepository.findById(regFormDTO.getState_Id()).orElse(null);
		userMaster.setState(state);
		
		City_Master city = cityRepository.findById(regFormDTO.getCity_Id()).orElse(null);
		userMaster.setCity(city);
		
		String randomPwd = generateRandomPwd();
		
		userMaster.setPwd(randomPwd);
		userMaster.setPwd_Reset("No");;
		
		User_Master savedUser = userRepository.save(userMaster);
		if(savedUser.getUser_Id() !=null) {
			String subject="Your account created";
			String body="Your Password To Login:"+randomPwd;
			String to=regFormDTO.getEmail();
			
			emailService.sendEmail(subject, body, to);
			return true;
		}
		return false;
	}

	@Override
	public UserDTO login(LoginFormDTO loginFormDTO) {
		User_Master userEntity = userRepository.findByEmailAndPwd(loginFormDTO.getEmail(), loginFormDTO.getPwd());
		if(userEntity != null) {
			UserDTO userDto=new UserDTO();
			BeanUtils.copyProperties(userEntity, userDto);
			return userDto;
		}
		return null;
	}

	@Override
	public boolean resetPwd(ResetPwdFormDTO resetPwdDTO) {
		String email = resetPwdDTO.getEmail();
		User_Master entity = userRepository.findByEmail(email);
		
		entity.setPwd(resetPwdDTO.getNewPwd());
		entity.setPwd_Reset("Yes");
		
		userRepository.save(entity);
		
		return true;
	}
	
	private String generateRandomPwd() {
		String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase="abcdefghijklmnopqrstuvwxyz";
		String alphabets=upperCase+lowerCase;
		Random random=new Random();
		StringBuffer generatePwd=new StringBuffer();
		for(int i=0;i<5;i++) {
			//give any number from 0 to 51
			int randomIdx=random.nextInt(alphabets.length());
			generatePwd.append(alphabets.charAt(randomIdx));
		}
		return generatePwd.toString();

	}

}
