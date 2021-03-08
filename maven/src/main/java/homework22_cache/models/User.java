package homework22_cache.models;

import lombok.*;

/**
 * @author Aleksandr Khatsaiuk
 * @version 1.0
 *
 * DTO class for storing information about user
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
}
