package in.kkpit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class User_Master {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generate4")
    @SequenceGenerator(name = "my_sequence_generate4", sequenceName = "my_sequence", allocationSize = 1)	
	private Integer user_Id;
	private String userName;
	private String Email;
	private Long Phno;
	private String Pwd;
	private String pwd_Reset;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate created_Date;
	
	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDate update_Date;
	
	@ManyToOne
	@JoinColumn(name="country_Id")
	private Country_Master country;
	
	@ManyToOne
	@JoinColumn(name="state_Id")
	private State_Master state;
	
	@ManyToOne
	@JoinColumn(name="city_Id")
	private City_Master city;

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

	public LocalDate getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(LocalDate created_Date) {
		this.created_Date = created_Date;
	}

	public LocalDate getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(LocalDate update_Date) {
		this.update_Date = update_Date;
	}

	public Country_Master getCountry() {
		return country;
	}

	public void setCountry(Country_Master country) {
		this.country = country;
	}

	public State_Master getState() {
		return state;
	}

	public void setState(State_Master state) {
		this.state = state;
	}

	public City_Master getCity() {
		return city;
	}

	public void setCity(City_Master city) {
		this.city = city;
	}
	
	
	
	
	
}
