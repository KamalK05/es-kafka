package com.in.eskafka.config.annotations;

import com.in.eskafka.entity.enums.OrgType;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeValidator implements ConstraintValidator<Type, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (OrgType type : OrgType.values()) {
            if (type.name().equalsIgnoreCase(value))
                return true;
        }
        return false;
    }
}