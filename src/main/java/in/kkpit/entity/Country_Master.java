package in.kkpit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Country_Master {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generate1")
    @SequenceGenerator(name = "my_sequence_generate1", sequenceName = "my_sequence", allocationSize = 1)	
	private Integer country_Id;
	private String country_Name;
	public Integer getCountry_Id() {
		return country_Id;
	}
	public void setCountry_Id(Integer country_Id) {
		this.country_Id = country_Id;
	}
	public String getCountry_Name() {
		return country_Name;
	}
	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}
	
}
