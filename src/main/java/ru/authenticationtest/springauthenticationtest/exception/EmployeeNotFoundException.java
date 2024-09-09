package ru.authenticationtest.springauthenticationtest.exception;


import org.springframework.data.crossstore.ChangeSetPersister;

public class EmployeeNotFoundException extends NotFoundException {
    public EmployeeNotFoundException(long id) {
        super(id);
    }


    @Override
    public String getMessage() {
        return "Сотрудник с id = %d не найден".formatted(getId());
    }
}
