package com.example.DataTable.Dto;

import lombok.Data;

@Data
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public EmployeeResponseDTO(Long id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}