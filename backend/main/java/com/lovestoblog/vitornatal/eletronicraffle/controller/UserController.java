package com.lovestoblog.vitornatal.eletronicraffle.controller;

import com.lovestoblog.vitornatal.eletronicraffle.dto.request.UserUpdateDTO;
import com.lovestoblog.vitornatal.eletronicraffle.dto.response.UserResponseDTO;
import com.lovestoblog.vitornatal.eletronicraffle.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "Users", description = "Endpoints for user profile management")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Update user profile", description = "Updates the profile of the user with the given ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User profile updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "403", description = "Unauthorized, user not authenticated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PatchMapping("/{id}/edit-profile")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponseDTO user = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(user.getName() + "'s profile updated");
    }



}
