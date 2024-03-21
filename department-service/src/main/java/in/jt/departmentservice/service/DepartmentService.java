package in.jt.departmentservice.service;

import in.jt.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
}
