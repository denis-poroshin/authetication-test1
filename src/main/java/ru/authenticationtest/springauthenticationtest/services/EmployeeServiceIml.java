package ru.authenticationtest.springauthenticationtest.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.authenticationtest.springauthenticationtest.entity.EmployeeEntity;
import ru.authenticationtest.springauthenticationtest.exception.EmployeeNotFoundException;
import ru.authenticationtest.springauthenticationtest.interfaces.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.authenticationtest.springauthenticationtest.repository.EmployeeRepository;

import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
public class EmployeeServiceIml implements EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;




    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void changeEmployee(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity changeEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id));

        changeEmployee.setFirstName(employeeEntity.getFirstName());
        changeEmployee.setRole(employeeEntity.getRole());
        changeEmployee.setPassword(passwordEncoder.encode(employeeEntity.getPassword()));
        employeeRepository.save(changeEmployee);
    }

    @Override
    public EmployeeEntity deleteEmployee(Long id) {
        EmployeeEntity removedEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id));
        employeeRepository.delete(removedEmployee);
        return removedEmployee;
    }

    @Override
    public EmployeeEntity getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id));
    }

    @Override
    public Collection<EmployeeEntity> getAllEmployees() {
        return Collections.unmodifiableCollection(employeeRepository.findAll());
    }
}
