package com.student.users.controller;

import com.student.users.dto.*;

import com.student.users.service.AddressService;
import com.student.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;

    @PostMapping("add")
    private UserDto create(@RequestBody UserRequestDto userRequestDto) {
        return userService.add(userRequestDto);
    }

    @GetMapping("/all")
    private Page<UserDto> getAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required = false, defaultValue = "none") String search,
                                 @RequestParam(required = false, defaultValue = "desc") String order) {
        Pageable pageable = ((order.equalsIgnoreCase("desc")) ? PageRequest.of(page, size, Sort.by("name").descending()) : PageRequest.of(page, size, Sort.by("name").ascending()));
        return userService.getAllUsers(search, pageable);
    }

    @GetMapping("/students")
    private Page<StudentDto> getAllStudents(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size)
    {
        return userService.getStudents( PageRequest.of(page, size));
    }
}

