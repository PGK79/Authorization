package ru.netology.authorizationservice.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.enums.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String, List<Authorities>> permissionStore = Map.of("Ivan123", List.of(Authorities.READ,
                    Authorities.WRITE), "Olga456", List.of(Authorities.READ, Authorities.DELETE),
            "Petya789", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));

    public List<Authorities> getUserAuthorities(String user, String password) {
        String keyForAdmission = user + password;
        if (permissionStore.containsKey(keyForAdmission)) {
            return permissionStore.get(keyForAdmission);
        } else {
            return new ArrayList<>();
        }
    }
}