package ltts.com.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ltts.com.model.Login;


@Repository
public interface MyJPARepository1 extends CrudRepository<Login,Integer>{
	
	@Query("select u from Login u where u.name=:name and u.pwd=:pwd")
	public Login getByUsernamePass(@Param("name")String name,@Param("pwd")String Pwd);
	
}

