package in.jt.employeeservice.service;

import in.jt.employeeservice.dto.APIResponseDto;
import in.jt.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	APIResponseDto getEmployeeById(Long empId);
}
