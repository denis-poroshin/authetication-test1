package ru.authenticationtest.springauthenticationtest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.authenticationtest.springauthenticationtest.entity.EmployeeEntity;
import ru.authenticationtest.springauthenticationtest.exception.EmployeeNotFoundException;
import ru.authenticationtest.springauthenticationtest.interfaces.EmployeeService;
import org.springframework.stereotype.Service;
import ru.authenticationtest.springauthenticationtest.repository.EmployeeRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class EmployeeServiceIml implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceIml.class);

    @Autowired
    public EmployeeServiceIml(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        logger.info("Creating employee: {}", employee);

        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);

        logger.info("Employee: {} created", employee);
        return employee;
    }

    @Override
    public void changeEmployee(Long id, EmployeeEntity employeeEntity) {
        logger.info("changing fields about an employee: {} with id {}", employeeEntity, id);

        EmployeeEntity changeEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id));

        changeEmployee.setFirstName(employeeEntity.getFirstName());
        changeEmployee.setRole(employeeEntity.getRole());
        changeEmployee.setPassword(passwordEncoder.encode(employeeEntity.getPassword()));
        employeeRepository.save(changeEmployee);

        logger.info("Employee: {} changed with id: {}", employeeEntity, id);
    }

    @Override
    public EmployeeEntity deleteEmployee(Long id) {
        logger.info("Deleting employee with id: {}", id);

        EmployeeEntity removedEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id));
        employeeRepository.delete(removedEmployee);

        logger.info("Employee: {} deleted", removedEmployee);
        return removedEmployee;
    }

    @Override
    public EmployeeEntity getEmployee(Long id) {
        logger.info("Retrieving employee with id: {}", id);

        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id));
    }

    @Override
    public Collection<EmployeeEntity> getAllEmployees() {
        logger.info("Retrieving all employees");

        return Collections.unmodifiableCollection(employeeRepository.findAll());
    }
}
