package ru.netology.authorizationservice.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.enums.Authorities;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return ;
    }
}