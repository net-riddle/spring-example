package com.netriddle.spring_example.service;

import com.netriddle.spring_example.model.converter.UserConverter;
import com.netriddle.spring_example.model.dto.UserDTO;
import com.netriddle.spring_example.model.po.UserPO;
import com.netriddle.spring_example.model.response.*;
import com.netriddle.spring_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    public CreateRequestResponse createUser(UserDTO userDTO) {
        log.info("Service - createUser START with DTO -> {}",userDTO);

        UserPO userToCreate = userConverter.dtoToPo(userDTO);

        CreateRequestResponse createRequestResponse;
        try {
            UserPO userCreated = userRepository.save(userToCreate);
            createRequestResponse = userConverter.createRequestResponse(userCreated);
        }catch(Exception e){
            log.error("Service - createUser ERROR with message -> {}",e.getMessage());
            createRequestResponse = userConverter.createRequestResponse(e);
        }
        log.info("Service - createUser END with response -> {}",createRequestResponse);
        return createRequestResponse;
    }

    public GetUsersResponse getUsers() {
        log.info("Service - getUsers START");

        List<UserPO> userList = userRepository.findAllUsers();
        GetUsersResponse getUsersResponse = userConverter.listOfUsersGetUsersResponse(userList);

        log.info("Service - getUsers END with response -> {}",getUsersResponse);
        return getUsersResponse;
    }

    public GetUserResponse getUser(Long id) {
        log.info("Service - getUser START with id -> {}", id);

        Optional<UserPO> userPo = userRepository.findById(id);

        GetUserResponse getUserResponse;
        if(userPo.isPresent()){
            getUserResponse = userConverter.userPoToGetUserResponse(userPo.get());
        }else{
            getUserResponse = userConverter.getUserResponse();
        }

        log.info("Service - getAllUsers END with response -> {}",getUserResponse);
        return getUserResponse;
    }

    public UpdateUserResponse updateUser(UserDTO userDTO) {
        log.info("Service - updateUser START with dto -> {}", userDTO);

        UserPO userToUpdate = userConverter.dtoToPo(userDTO);
        UserPO currentUser = userRepository.updateUser(userToUpdate);
        UpdateUserResponse updateUserResponse = userConverter.userToUpdateResponse(currentUser);

        log.info("Service - updateUser START with updateUserResponse -> {}", updateUserResponse);
        return updateUserResponse;
    }

    public DeleteUserResponse deleteUser(Long id) {
        log.info("Service - deleteUser START with id -> {}", id);
        userRepository.deleteById(id);
        DeleteUserResponse deleteUserResponse = userConverter.deleteUserResponse();
        log.info("Service - deleteUser END with response -> {}", deleteUserResponse);
        return deleteUserResponse;
    }

}
