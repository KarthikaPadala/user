package com.student.users.repository;

import com.student.users.model.Address;
import com.student.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByCity(User user);

}
