package ru.authenticationtest.springauthenticationtest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.authenticationtest.springauthenticationtest.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(value = "SELECT * FROM employees WHERE first_name = :first_name", nativeQuery = true)
    Optional<EmployeeEntity> findByFirstName(@Param("first_name") String firstName);
}
