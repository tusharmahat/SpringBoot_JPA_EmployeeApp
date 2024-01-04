package com.takeo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.takeo.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	//findByXXX
	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByEmailAndEno(String email,int eno);
	
	//customized QUERIES(JPQL java persistant query language)
	@Query("select email from Employee")
	List<String> getAllEmails();
	
//	@Query("from Employee where eno>:no")
//	List<Employee> getAllEmails(int no);
	
	@Query(value="select email from Employee where enumber<:no", nativeQuery=true)
	List<String> getAllEmails(int no);
}
