package vn.codegym.springbootdatajpa.validation;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.springbootdatajpa.entities.User;
import vn.codegym.springbootdatajpa.repositories.UserRepository;
import vn.codegym.springbootdatajpa.validation.annotation.UniqueUserEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;
import java.util.List;

public class CheckEmailCustomerUnique implements ConstraintValidator<UniqueUserEmail, String> {
    @Autowired UserRepository userRepository;

    @Override public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        List<User> users = userRepository.findByEmail(email);
        return users.isEmpty();
    }
}
