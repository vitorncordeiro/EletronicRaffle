package com.lovestoblog.vitornatal.eletronicraffle.mapper;

import com.lovestoblog.vitornatal.eletronicraffle.dto.UserDTO;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setUSER_ID(userDTO.getUSER_ID());
        userModel.setName(userDTO.getName());
        userModel.setCpf(userDTO.getCpf());
        userModel.setEmail(userDTO.getEmail());
        return userModel;
    }
    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setUSER_ID(userModel.getUSER_ID());
        userDTO.setName(userModel.getName());
        userDTO.setCpf(userModel.getCpf());
        userDTO.setEmail(userModel.getEmail());

        return userDTO;
    }
}
