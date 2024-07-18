package com.example.DataTable.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DataTable.Dto.EmployeeDTO;
import com.example.DataTable.Dto.EmployeeMapper;
import com.example.DataTable.Dto.EmployeeResponseDTO;
import com.example.DataTable.Entity.Employee;
import com.example.DataTable.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toEmployeeDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(employeeMapper::toEmployeeDTO);
    }

    public EmployeeResponseDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        employee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponseDTO(employee);
    }

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeMapper.toEmployee(employeeDTO);
            employee.setId(id);
            employee = employeeRepository.save(employee);
            return employeeMapper.toEmployeeResponseDTO(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeResponseDTO> saveAllEmployees(List<EmployeeDTO> employeeDTOs) {
        List<Employee> employees = employeeDTOs.stream()
                .map(employeeMapper::toEmployee)
                .collect(Collectors.toList());
        employees = employeeRepository.saveAll(employees);
        return employees.stream()
                .map(employeeMapper::toEmployeeResponseDTO)
                .collect(Collectors.toList());
    }
}