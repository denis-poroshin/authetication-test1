package ru.authenticationtest.springauthenticationtest.interfaces;

import ru.authenticationtest.springauthenticationtest.entity.EmployeeEntity;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    EmployeeEntity createEmployee(EmployeeEntity employeeEntity);
    void changeEmployee(Long id, EmployeeEntity employeeEntity);
    EmployeeEntity deleteEmployee(Long id);
    EmployeeEntity getEmployee(Long id);
    Collection<EmployeeEntity> getAllEmployees();



}
