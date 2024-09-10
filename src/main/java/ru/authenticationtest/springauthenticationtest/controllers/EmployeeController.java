package ru.authenticationtest.springauthenticationtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ru.authenticationtest.springauthenticationtest.entity.EmployeeEntity;
import ru.authenticationtest.springauthenticationtest.interfaces.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;


    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void changeEmployee(@PathVariable long id, @RequestBody EmployeeEntity employee) {
        employeeService.changeEmployee(id, employee);

    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EmployeeEntity deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public EmployeeEntity getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);

    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public Collection<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/welcome")
    public String getHello(){
        return "Hello!";
    }


}
