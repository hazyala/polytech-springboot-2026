package pollytech.aisw._026example.domain;

import lombok.Data;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Member {
//    private String id;
//    private String passwd;
//    private String city;
//    private String gender;
//    private String[] hobby;
//    private String greetings;
    private String name;
    private MultipartFile fileImage;
}
