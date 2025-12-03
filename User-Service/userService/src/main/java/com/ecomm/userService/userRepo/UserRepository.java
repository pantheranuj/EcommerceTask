package com.ecomm.userService.userRepo;

import com.ecomm.userService.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
