package homework16_parser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Contacts {

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;
}
