package com.student.users.repository;

import com.student.users.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> findAll(Pageable pageable);
    Page<User> findAllByUserNameContains(String search, Pageable pageable);

}
