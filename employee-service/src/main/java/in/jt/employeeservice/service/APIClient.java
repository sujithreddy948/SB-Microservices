package in.jt.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.jt.employeeservice.dto.DepartmentDto;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
	
	@GetMapping("api/departments/{dept-code}")
	DepartmentDto getDepartment(@PathVariable("dept-code") String deptCode);
}
