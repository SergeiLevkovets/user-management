package by.levkovets.usermanagement.damain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userAccount")
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp ="^[a-zA-Z]+$", message = "Username must contain only latin characters")
    @Size(min=3, max=16, message = "Username must be 3-16 characters long")
    @NotBlank(message = "UserName cannot be empty")
    @Column(unique = true)
    private String userName;

    @Pattern(regexp = "(?=\\w*(?!\\d)\\w)(?=\\w*\\d)\\w+", message = "Password must have at least one character and at least one number")
    @Size(min=3, max=16, message = "Password must be 3-16 characters long")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Transient
    @NotBlank(message = "Password confirmation cannot be empty")
    private String confirmPassword;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName must contain only latin characters")
    @Size(min=1, max=16, message = "firstName must be 3-16 characters long")
    @NotBlank(message = "firstName confirmation cannot be empty")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName must contain only latin characters")
    @Size(min=1, max=16, message = "lastName must be 3-16 characters long")
    @NotBlank(message = "lastName confirmation cannot be empty")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime CreatedAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
