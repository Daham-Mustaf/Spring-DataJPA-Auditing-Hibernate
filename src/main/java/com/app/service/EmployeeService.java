package com.app.service;

import com.app.dao.EmployeeRepository;
import com.app.dto.InputRequest;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // save employee
    public String saveEmployee(InputRequest<Employee> request){

        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Employee employee= request.getEmployee();
        employee.setCreatedBy(currentUser);
        employeeRepository.save(employee);
        return "Employee added successfully... ";
    }

    // update employee
    public String saveEmployee(Long id, double salary, InputRequest<Employee> request){

        Employee employee = employeeRepository.findById(id).get();
        if(employee!=null){
            employee.setSalary(salary);
            employee.setLastModifiedBy(request.getLoggedInUser());
            employeeRepository.save(employee);
        }
        else {
            throw new RuntimeException("Employee not found with id:"+ id);
        }
        return "Employee updated successfully... ";
    }
}
