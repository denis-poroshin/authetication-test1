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


    @PostMapping("/create")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void changeEmployee(@PathVariable long id, @RequestBody EmployeeEntity employee) {
        employeeService.changeEmployee(id, employee);

    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public EmployeeEntity deleteEmployee(@PathVariable long id) {
        return null;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public EmployeeEntity getEmployee(@PathVariable long id) {
        return null;

    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public Collection<EmployeeEntity> getAllEmployees() {
        return null;
    }
//    @GetMapping
//    public String getHello(){
//        return "Hello World";
//    }


}
