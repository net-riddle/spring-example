package com.netriddle.spring_example.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse extends RestResponse{
    private String id;
    private String name;
    private String email;
    private String role;
}
