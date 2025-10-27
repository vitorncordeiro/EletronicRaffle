package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.LoginRequest;
import com.lovestoblog.vitornatal.eletronicraffle.dto.request.RegisterDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.LoginResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.UserResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.exception.UsernameOrPasswordInvalidException;
import com.lovestoblog.vitornatal.eletronicraffle.infra.security.TokenService;
import com.lovestoblog.vitornatal.eletronicraffle.mapper.UserMapper;
import com.lovestoblog.vitornatal.eletronicraffle.model.UserModel;
import com.lovestoblog.vitornatal.eletronicraffle.repository.UserRepository;
import com.lovestoblog.vitornatal.eletronicraffle.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name="Authentication", description="Endpoint for authentication process")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Operation(summary="Makes the login authentiaction", description = "Returns a LoginResponseDTO with the JWT Token")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login successfull"),
            @ApiResponse(responseCode = "403", description = "Username or password incorrectly")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequest data){
       try {
           var userNP = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword());
           var auth = this.authenticationManager.authenticate(userNP);


           var token = tokenService.generateToken((UserModel) auth.getPrincipal());

           return ResponseEntity.ok(new LoginResponseDTO(token));
       }catch(BadCredentialsException e){
           throw new UsernameOrPasswordInvalidException("Invalid username or password.");
       }
    }


    @Operation(summary="Makes the new account register", description = "Returns a UserResponseDTO with ID, name, cpf, email")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registered successfully"),
            @ApiResponse(responseCode = "403", description = "Missing fields"),
            @ApiResponse(responseCode = "400", description = "User already exists")
    })
    @PostMapping ("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterDTO data){

        if(userRepository.findByEmail(data.email()).isPresent()) return ResponseEntity.badRequest().build();

        UserModel savedUser = userService.save(userMapper.map(data));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.map(savedUser));
    }

}
