package pollytech.aisw._026example.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MemberIDValidator implements ConstraintValidator<MemberId, String> {

    @Override
    public void initialize(MemberId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.equals("admin"))
            return false;

        return true;
    }
}
