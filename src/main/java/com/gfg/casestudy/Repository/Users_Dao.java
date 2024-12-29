package com.gfg.casestudy.Repository;

import com.gfg.casestudy.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users_Dao extends JpaRepository<Users, Integer> {
}
