package com.netriddle.spring_example.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUsersResponse extends RestResponse {
    private List<GetUserResponse> userList;
}
