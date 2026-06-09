package pollytech.aisw._026example.domain;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return true;//false => true로 수정
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        String name = person.getName();
        String age = person.getAge();
        String email = person.getEmail();
        if (name == null || name.trim().isEmpty())
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "이름을 입력하세요.");

        if (age == null || age.trim().isEmpty())
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", null, "나이를 입력하세요.");

        if (email == null || email.trim().isEmpty())
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "email을 입력하세요.");
    }
}
