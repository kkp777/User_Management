package in.kkpit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.kkpit.entity.User_Master;

public interface UserRepository extends JpaRepository<User_Master,Integer>{
	
	
	@Query(value="select * from User_Master where Email=:Email",nativeQuery=true)
	public  User_Master findByEmail(String Email);
	@Query(value="select * from User_Master where Email=:Email and Pwd=:Pwd",nativeQuery=true)
	public  User_Master findByEmailAndPwd(String Email,String Pwd);

}
