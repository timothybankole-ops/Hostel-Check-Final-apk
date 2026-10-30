package com.hostelcheck.backend.repository;
import com.hostelcheck.backend.entity.UserAccount; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
 Optional<UserAccount> findByEmail(String email); Optional<UserAccount> findByToken(String token);}
