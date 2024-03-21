package in.jt.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jt.departmentservice.dto.DepartmentDto;
import in.jt.departmentservice.entity.Department;
import in.jt.departmentservice.repo.DepartmentRepo;
import in.jt.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department savedDept = departmentRepo.save(
				new Department(
						departmentDto.getId(),
						departmentDto.getDepartmentName(),
						departmentDto.getDepartmentDescription(),
						departmentDto.getDepartmentCode()));
		
		return new DepartmentDto(
				savedDept.getId(),
				savedDept.getDepartmentName(),
				savedDept.getDepartmentDescription(),
				savedDept.getDepartmentCode());
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		Department department = departmentRepo.findByDepartmentCode(code);
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode());
	}

}
