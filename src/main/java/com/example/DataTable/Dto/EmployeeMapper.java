package com.example.DataTable.Dto;
import org.springframework.stereotype.Component;

import com.example.DataTable.Entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(employee.getName());
        dto.setPosition(employee.getPosition());
        dto.setSalary(employee.getSalary());
        return dto;
    }

    public Employee toEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setPosition(dto.getPosition());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public EmployeeResponseDTO toEmployeeResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getPosition(),
                employee.getSalary()
        );
    }
}
