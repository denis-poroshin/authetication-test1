package ru.authenticationtest.springauthenticationtest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.authenticationtest.springauthenticationtest.entity.EmployeeEntity;
import ru.authenticationtest.springauthenticationtest.mpdel.EmployeeDetails;
import ru.authenticationtest.springauthenticationtest.repository.EmployeeRepository;

import java.util.Optional;
@Service
public class EmployeeDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(EmployeeDetailService.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loading user by username");

        Optional<EmployeeEntity> employee = employeeRepository.findByNick(username);
        return employee.map(EmployeeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("%s not found".formatted(username)));
    }
}
