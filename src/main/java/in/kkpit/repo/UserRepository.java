package in.kkpit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kkpit.entity.User_Master;

public interface UserRepository extends JpaRepository<User_Master,Integer>{

}
