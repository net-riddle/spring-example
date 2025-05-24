package com.netriddle.spring_example.model.converter;

import com.netriddle.spring_example.config.UserApplicationProperties;
import com.netriddle.spring_example.model.dto.UserDTO;
import com.netriddle.spring_example.model.po.UserPO;
import com.netriddle.spring_example.model.request.CreateUserRequest;
import com.netriddle.spring_example.model.request.UpdateUserRequest;
import com.netriddle.spring_example.model.response.*;
import com.netriddle.spring_example.util.Tools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.netriddle.spring_example.util.Constants.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserConverter {

    private final Tools tools;
    private final UserApplicationProperties userApplicationProperties;

    public UserDTO createRequestToUserDTO(CreateUserRequest createUserRequest){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(createUserRequest.getName());
        userDTO.setPassword(createUserRequest.getPassword());
        userDTO.setEmail(createUserRequest.getEmail());
        log.info("UserConverter - createRequestToUserDTO END with DTO -> {}", userDTO);
        return userDTO;
    }

    public UserDTO userDTO(UserPO user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public CreateRequestResponse createRequestResponse(UserPO userCreated){
        CreateRequestResponse createRequestResponse = new CreateRequestResponse();
        createRequestResponse.setMessage("Creation done");
        createRequestResponse.setMessage(userApplicationProperties.getName());
        createRequestResponse.setTimestamp(tools.getInstant());
        createRequestResponse.setEmail(userCreated.getEmail());
        createRequestResponse.setName(userCreated.getName());
        log.info("UserConverter - createRequestResponse END with createRequestResponse -> {}", createRequestResponse);
        return createRequestResponse;
    }

    public CreateRequestResponse createRequestResponse(Exception e){
        CreateRequestResponse createRequestResponse = new CreateRequestResponse();
        createRequestResponse.setMessage(e.getMessage());
        createRequestResponse.setMessage(userApplicationProperties.getName());
        createRequestResponse.setTimestamp(tools.getInstant());
        createRequestResponse.setDetailed(BASE_ERROR_DETAILS);
        log.info("UserConverter - createRequestResponse END with createRequestResponse -> {}", createRequestResponse);
        return createRequestResponse;
    }

    public UserPO dtoToPo(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        userPO.setName(userDTO.getName());
        userPO.setEmail(userDTO.getEmail());
        userPO.setPassword(userDTO.getPassword());
        userPO.setRole(userDTO.getRole());
        log.info("UserConverter - createRequestToUserDTO END with PO -> {}", userPO);
        return userPO;
    }

    public GetUsersResponse listOfUsersGetUsersResponse(List<UserPO> userList){
        GetUsersResponse getUsersResponse = new GetUsersResponse();

        List<GetUserResponse> getUserResponseList = new ArrayList<>();

        for (UserPO user : userList) {
            GetUserResponse getUserResponse = userPoToGetUserResponse(user);
            getUserResponseList.add(getUserResponse);
        }

        getUsersResponse.setUserList(getUserResponseList);
        getUsersResponse.setMessage(userApplicationProperties.getName());
        getUsersResponse.setTimestamp(tools.getInstant());

        log.info("UserConverter - listOfUsersoGetUsersResponse END with response -> {}", getUsersResponse);
        return getUsersResponse;
    }

    public GetUserResponse userPoToGetUserResponse(UserPO userPO){
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setId(String.valueOf(userPO.getId()));
        getUserResponse.setRole(userPO.getRole());
        getUserResponse.setName(userPO.getName());
        getUserResponse.setEmail(userPO.getEmail());
        log.info("UserConverter - userPoToGetUserResponse END with response -> {}", getUserResponse);
        return getUserResponse;
    }

    public GetUserResponse getUserResponse(){
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setMessage(USER_NOT_FOUND_MESSAGE);
        getUserResponse.setMessage(userApplicationProperties.getName());
        getUserResponse.setTimestamp(tools.getInstant());
        log.info("UserConverter - getUserResponse END with getUserResponse -> {}", getUserResponse);
        return getUserResponse;
    }

    public UserDTO updateRequestToDto(UpdateUserRequest updateUserRequest){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(updateUserRequest.getName());
        userDTO.setPassword(updateUserRequest.getPassword());
        userDTO.setEmail(updateUserRequest.getEmail());
        log.info("UserConverter - updateRequestToDto END with DTO -> {}", userDTO);
        return userDTO;
    }

    public UpdateUserResponse userToUpdateResponse(UserPO userPO){
        UpdateUserResponse updateUserResponse = new UpdateUserResponse();
        updateUserResponse.setMessage("Update done");
        updateUserResponse.setMessage(userApplicationProperties.getName());
        updateUserResponse.setTimestamp(tools.getInstant());
        updateUserResponse.setEmail(userPO.getEmail());
        updateUserResponse.setName(userPO.getName());
        log.info("UserConverter - userToUpdateResponse END with updateUserResponse -> {}", updateUserResponse);
        return updateUserResponse;
    }

    public DeleteUserResponse deleteUserResponse(){
        DeleteUserResponse deleteUserResponse = new DeleteUserResponse();
        deleteUserResponse.setMessage(USER_DELETED_MESSAGE);
        deleteUserResponse.setMessage(userApplicationProperties.getName());
        deleteUserResponse.setTimestamp(tools.getInstant());
        log.info("UserConverter - deleteUserResponse END with deleteUserResponse -> {}", deleteUserResponse);
        return deleteUserResponse;
    }
}
