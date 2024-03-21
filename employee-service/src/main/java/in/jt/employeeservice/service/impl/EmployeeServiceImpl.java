package in.jt.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.employeeservice.dto.APIResponseDto;
import in.jt.employeeservice.dto.DepartmentDto;
import in.jt.employeeservice.dto.EmployeeDto;
import in.jt.employeeservice.entity.Employee;
import in.jt.employeeservice.repo.EmployeeRepo;
import in.jt.employeeservice.service.APIClient;
import in.jt.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private APIClient apiClient;
	//private WebClient webClient;
	//private RestTemplate restTemplate;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee savedEmp = employeeRepo.save(
				new Employee(
						employeeDto.getId(),
						employeeDto.getFirstName(),
						employeeDto.getLastName(),
						employeeDto.getEmail(),
						employeeDto.getDepartmentCode()
						)
				);
		
		return new EmployeeDto(
				savedEmp.getId(),
				savedEmp.getFirstName(),
				savedEmp.getLastName(),
				savedEmp.getEmail(),
				savedEmp.getDepartmentCode()
				);
	}

	@Override
	public APIResponseDto getEmployeeById(Long empId) {
		Employee employee = employeeRepo.findById(empId).get();
		
		/*
		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
		DepartmentDto departmentDto = responseEntity.getBody();
		*/
		
		/*
		DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
				.retrieve().bodyToMono(DepartmentDto.class).block();
				*/
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
				);
		
		/*
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
				);*/
		return new APIResponseDto(employeeDto,departmentDto);
	}


	

}
