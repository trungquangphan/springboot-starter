package vn.codegym.springbootdatajpa.validation.annotation;

import vn.codegym.springbootdatajpa.validation.CheckEmailCustomerUnique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckEmailCustomerUnique.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserEmail {
    String message() default "This email does exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
