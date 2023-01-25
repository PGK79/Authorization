package ru.netology.authorizationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exceptions.InvalidCredentials;
import ru.netology.authorizationservice.exceptions.UnauthorizedUser;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class AllExceptionHandlers {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println("СООБЩЕНИЕ ОБ ОШИБКЕ: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationExceptionHandle(ConstraintViolationException e) {
        String authoritiesUser = "getAuthorities.user.user";
        String authoritiesPassword = "getAuthorities.user.password";

        if (e.getMessage().contains(authoritiesUser) || e.getMessage().contains(authoritiesPassword)) {
            return new ResponseEntity<>(e.getMessage()
                    .replace(authoritiesUser, "Ошибка в имени пользователя ")
                    .replace(authoritiesPassword, "Ошибка в пароле "),
                    HttpStatus.BAD_REQUEST);

        } else if (e.getMessage().contains(authoritiesPassword)) {
            return new ResponseEntity<>(e.getMessage().replace(authoritiesPassword,
                    "Ошибка в пароле "), HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<>(e.getMessage().replace(authoritiesUser,
                    "Ошибка в имени пользователя "), HttpStatus.BAD_REQUEST);
        }
    }
}