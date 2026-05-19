package pollytech.aisw._026example.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member2 {
    @MemberId
    private String memberId;

    @Size(min=4, max = 10, message = "최소 4 ~ 최�? 10개의 문자?�로 ?�성?�야?�니??")
    private String passwd;

}
