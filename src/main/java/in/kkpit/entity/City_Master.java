package in.kkpit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class City_Master {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generate3")
    @SequenceGenerator(name = "my_sequence_generate3", sequenceName = "my_sequence", allocationSize = 1)	
	private Integer city_Id;	
	private String city_Name;
	
	private Integer state_Id;

	public Integer getCity_Id() {
		return city_Id;
	}

	public void setCity_Id(Integer city_Id) {
		this.city_Id = city_Id;
	}

	public String getCity_Name() {
		return city_Name;
	}

	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}

	public Integer getState_Id() {
		return state_Id;
	}

	public void setState_Id(Integer state_Id) {
		this.state_Id = state_Id;
	}

	
	
	
	

}
