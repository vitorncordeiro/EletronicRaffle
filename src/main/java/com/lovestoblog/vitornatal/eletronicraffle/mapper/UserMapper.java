package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RegisterDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.UserResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel map(UserResponseDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getUSER_ID());
        userModel.setName(userDTO.getName());
        userModel.setCpf(userDTO.getCpf());
        userModel.setEmail(userDTO.getEmail());
        return userModel;
    }
    public UserResponseDTO map(UserModel userModel){
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setUSER_ID(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setCpf(userModel.getCpf());
        userDTO.setEmail(userModel.getEmail());

        return userDTO;
    }
    public UserModel map(RegisterDTO data){
        UserModel userModel = new UserModel();
        userModel.setPassword(data.password());
        userModel.setRole(data.role());
        userModel.setName(data.name());
        userModel.setEmail(data.email());
        userModel.setCpf(data.cpf());
        return userModel;
    }
}
