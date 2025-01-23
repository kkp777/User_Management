package in.kkpit.dto;

public class RegistrationFormDTO {
	private Integer user_Id;
	private String userName;
	private String Email;
	private Long Phno;
	private String Pwd;
	private String pwd_Reset;
	private Integer country_Id;
	private Integer state_Id;
	private Integer city_Id;
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Long getPhno() {
		return Phno;
	}
	public void setPhno(Long phno) {
		Phno = phno;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getPwd_Reset() {
		return pwd_Reset;
	}
	public void setPwd_Reset(String pwd_Reset) {
		this.pwd_Reset = pwd_Reset;
	}
	public Integer getCountry_Id() {
		return country_Id;
	}
	public void setCountry_Id(Integer country_Id) {
		this.country_Id = country_Id;
	}
	public Integer getState_Id() {
		return state_Id;
	}
	public void setState_Id(Integer state_Id) {
		this.state_Id = state_Id;
	}
	public Integer getCity_Id() {
		return city_Id;
	}
	public void setCity_Id(Integer city_Id) {
		this.city_Id = city_Id;
	}
	

}
