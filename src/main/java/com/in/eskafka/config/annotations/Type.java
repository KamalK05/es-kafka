package com.in.eskafka.config.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TypeValidator.class})
public @interface Type {
    String message() default "Please provide correct value for type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
