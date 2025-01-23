package in.kkpit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import in.kkpit.entity.State_Master;

public interface StateRepository extends JpaRepository<State_Master,Integer> {
	
	@Query(value="select * from State_Master where countryId=:country_Id",nativeQuery=true)
	public List<State_Master> findByCountryId(Integer countryId);
}
