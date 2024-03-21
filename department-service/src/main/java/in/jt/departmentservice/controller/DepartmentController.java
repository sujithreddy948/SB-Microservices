package in.jt.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jt.departmentservice.dto.DepartmentDto;
import in.jt.departmentservice.service.DepartmentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}
	
	@GetMapping("/{dept-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept-code") String deptCode) {
		DepartmentDto departmentByCode = departmentService.getDepartmentByCode(deptCode);
		return new ResponseEntity<>(departmentByCode,HttpStatus.OK);
	}
	
}
