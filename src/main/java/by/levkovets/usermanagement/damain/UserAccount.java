package by.levkovets.usermanagement.damain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userAccount")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only latin characters")
//    @Size(min = 3, max = 16, message = "Username must be 3-16 characters long")
//    @NotBlank(message = "UserName cannot be empty")
    @Column(unique = true)
    private String userName;

//    @Pattern(regexp = "(?=\\w*(?!\\d)\\w)(?=\\w*\\d)\\w+", message = "Password must have at least one character and at least one number")
//    @Size(min = 3, max = 16, message = "Password must be 3-16 characters long")
    @NotBlank(message = "Password cannot be empty")
    private String password;

//    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName must contain only latin characters")
//    @Size(min = 1, max = 16, message = "firstName must be 3-16 characters long")
//    @NotBlank(message = "firstName confirmation cannot be empty")
    private String firstName;

//    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName must contain only latin characters")
//    @Size(min = 1, max = 16, message = "lastName must be 3-16 characters long")
//    @NotBlank(message = "lastName confirmation cannot be empty")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active;

    @Column(insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

}
