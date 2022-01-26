package com.app.control;

import com.app.dto.InputRequest;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmployeeControler {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addemp")
    public String saveEmployee(@RequestBody InputRequest<Employee> request) {
     return service.saveEmployee(request);
    }

    @PostMapping("/updateEmploy/{id},{salary}")
    public String updateEmployee(@PathVariable Long id,@PathVariable double salary,@RequestBody InputRequest<Employee> request) {
        return service.updateSalary(id, salary, request);
    }

}
