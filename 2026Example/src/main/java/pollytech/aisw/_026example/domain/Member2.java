package pollytech.aisw._026example.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member2 {
    @MemberId
    private String memberId;

    @Size(min=4, max = 10, message = "최소 4 ~ 최대 10개의 문자열로 작성해야합니다.")
    private String passwd;

}
