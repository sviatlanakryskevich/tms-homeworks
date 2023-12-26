package com.tms.lesson47security.service;

import com.tms.lesson47security.model.Person;
import com.tms.lesson47security.model.UserDto;
import com.tms.lesson47security.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBUserDetailsService implements UserDetailsService {
    private final PasswordEncoder encoder;
    private final PersonRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username)
                .orElse(null);
    }
    @Transactional
    public void save(UserDto user){
        String username = user.getUsername();
        String password = user.getPassword();
        Person person = new Person();
        person.setLogin(username);
        person.setPassword(encoder.encode(password));
        person.setPerm("ROLE_USER");
        repository.save(person);
    }
}
