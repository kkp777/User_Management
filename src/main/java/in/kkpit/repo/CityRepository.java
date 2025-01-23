package in.kkpit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.kkpit.entity.City_Master;


public interface CityRepository extends JpaRepository<City_Master,Integer> {
	
	@Query(value="select * from City_Master where stateId=:state_Id",nativeQuery=true)
	public List<City_Master> findByStateId(Integer stateId);
}
