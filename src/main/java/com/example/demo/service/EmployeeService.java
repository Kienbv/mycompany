package com.example.demo.service;

import com.example.demo.dto.EmployeeDetail;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
    return employeeRepository.save(employee);
    }

    public EmployeeDetail findById(Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(Exception::new);
        return  modelMapper.map(employee, EmployeeDetail.class);
    }
}
