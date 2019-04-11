package com.tuidian.worklog.persistent.repository;

import com.tuidian.worklog.persistent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
