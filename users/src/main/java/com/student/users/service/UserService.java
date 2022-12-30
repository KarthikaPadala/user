package com.student.users.service;

import com.student.users.dto.AddressDto;
import com.student.users.dto.StudentDto;
import com.student.users.dto.UserDto;
import com.student.users.dto.UserRequestDto;
import com.student.users.model.Address;
import com.student.users.model.Student;
import com.student.users.model.User;
import com.student.users.repository.AddressRepository;
import com.student.users.repository.StudentRepository;
import com.student.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StudentRepository studentRepository;

    public Page<UserDto> getAllUsers(String search, Pageable pageable) {
            Page<User> users;

            if (search.equalsIgnoreCase("none")) {
                users = userRepository.findAll(pageable);

            } else {
                users = userRepository.findAllByUserNameContains(search, pageable);
            }
            final Page<UserDto> response = users.map(this::convertedUserToUserDto);
            return response;
        }

    private UserDto convertedUserToUserDto(User user) {
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        AddressDto addressDto=new AddressDto();
        Address addresses = addressRepository.findByCity(user);
        userDto.setAddress(this.convertAddressToAddressDto(addresses));
        return userDto;
    }
    private AddressDto convertAddressToAddressDto(Address address){
        AddressDto addressDto =new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setAddressLine1(address.getAddressLine1());
        addressDto.setAddressLine2(address.getAddressLine2());
        addressDto.setCity(address.getCity());
        return addressDto;
      }

      public UserDto add(UserRequestDto userRequestDto) {
          Address address = new Address();
          address.setAddressLine1(userRequestDto.getAddress().getAddressLine1());
          address.setAddressLine2(userRequestDto.getAddress().getAddressLine2());
          address.setCity(userRequestDto.getAddress().getCity());

          Address a = addressRepository.save(address);

          User user = new User();
          user.setUserName(userRequestDto.getUserName());
          user.setEmail(userRequestDto.getEmail());
          user.setAddress(a);

          User user1 = userRepository.save(user);

          UserDto userDto = new UserDto();

          userDto.setId(user1.getId());
          userDto.setUserName(user1.getUserName());
          userDto.setEmail(user1.getEmail());
          AddressDto addressDto = new AddressDto();
          addressDto.setId(a.getId());
          addressDto.setAddressLine1(a.getAddressLine1());
          addressDto.setAddressLine2(a.getAddressLine2());
          addressDto.setCity(user1.getAddress().getCity());//doubt
          userDto.setAddress(addressDto);

          return userDto;
      }

    public Page<StudentDto> getStudents(Pageable  pageable) {
        Page<Student> students = studentRepository.findAll(pageable);
       return students.map(this::convertStudentToStudentDto);
    }
    private StudentDto convertStudentToStudentDto(Student student){
        StudentDto studentDto =new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setTelugu(student.getTelugu());
        studentDto.setEnglish(student.getEnglish());
        studentDto.setTotal(student.getEnglish()+student.getTelugu());
        return studentDto;
    }
}



