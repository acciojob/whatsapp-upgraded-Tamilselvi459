package com.driver.Repository;

import com.driver.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
   public  User findByMobile(String mobile);
}
