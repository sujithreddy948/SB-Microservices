package in.jt.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jt.employeeservice.dto.APIResponseDto;
import in.jt.employeeservice.dto.EmployeeDto;
import in.jt.employeeservice.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/{emp-id}")
	public ResponseEntity<APIResponseDto> getDepartment(@PathVariable("emp-id") Long empId) {
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(empId); 
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}
	
}
