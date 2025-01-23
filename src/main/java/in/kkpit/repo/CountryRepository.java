package in.kkpit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kkpit.entity.Country_Master;

public interface CountryRepository extends JpaRepository<Country_Master,Integer> {

}
