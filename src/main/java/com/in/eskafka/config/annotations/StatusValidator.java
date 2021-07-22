package com.in.eskafka.config.annotations;

import com.in.eskafka.entity.enums.OrgStatus;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<Status, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (OrgStatus status : OrgStatus.values()) {
            if (status.name().equalsIgnoreCase(value))
                return true;
        }
        return false;
    }
}