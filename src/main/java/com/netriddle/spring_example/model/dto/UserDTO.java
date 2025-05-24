package com.netriddle.spring_example.model.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="password")
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
}
