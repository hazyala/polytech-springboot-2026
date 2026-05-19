package pollytech.aisw._026example.domain;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MemberIDValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberId {
    String message() default "ì¤‘ë³µ???„ì´?”ì…?ˆë‹¤.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
