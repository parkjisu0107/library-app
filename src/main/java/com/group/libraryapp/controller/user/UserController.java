package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    @Autowired // 필드에 직접 @Autowired 사용하여 스프링 빈 주입 받음.
    private final UserServiceV2 userService;

    // 생성자를 이용해 스피링 빈 주입 받음. (가장 권장)
    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    // setter와 @Autowired 사용하여 스프링 빈 주입 받음.
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }

}
