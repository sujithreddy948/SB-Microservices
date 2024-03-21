package in.jt.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.employeeservice.entity.Employee;
	
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	Employee getEmployeeById(Long empId);
}
