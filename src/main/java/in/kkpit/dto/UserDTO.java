package in.kkpit.dto;



public class UserDTO {
	
	private Integer user_Id;
	
	private String userName;
	
	private String Email;
	
	
	private String Pwd;


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


	public String getPwd() {
		return Pwd;
	}


	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	
	

}
