package vn.codegym.springbootdatajpa.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.springbootdatajpa.entities.User;
import vn.codegym.springbootdatajpa.repositories.UserRepository;
import vn.codegym.springbootdatajpa.validation.annotation.UniqueUserEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckEmailCustomerUnique implements ConstraintValidator<UniqueUserEmail, String> {
    @Autowired
    UserRepository userRepository;


    @Override public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        //userRepository will not be injected during the validation of Hibernate.
        // Since we only do need the validation on the Spring MVC level, we temporarily ignore this case
        if (userRepository == null){
            return true;
        }
        List<User> users = userRepository.findByEmail(email);
        return users.isEmpty();
    }
}
