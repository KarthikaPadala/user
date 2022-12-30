package com.student.users.service;

import com.student.users.dto.AddressDto;
import com.student.users.dto.AddressRequestDto;
import com.student.users.dto.UserDto;
import com.student.users.dto.UserRequestDto;
import com.student.users.model.Address;
import com.student.users.model.User;
import com.student.users.repository.AddressRepository;
import com.student.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
@Autowired
    AddressRepository addressRepository;
@Autowired
    UserRepository userRepository;
  }