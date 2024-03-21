package in.jt.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jt.departmentservice.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{
	Department findByDepartmentCode(String deptCode);
}
