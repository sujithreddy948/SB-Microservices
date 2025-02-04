package in.jt.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDto {
	private Long id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
}
