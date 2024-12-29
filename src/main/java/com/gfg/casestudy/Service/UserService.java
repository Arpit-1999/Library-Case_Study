package com.gfg.casestudy.Service;

import com.gfg.casestudy.Model.Users;
import com.gfg.casestudy.Repository.Users_Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    Users_Dao users_dao;

    //Add
    public Users registerUser(Users user)
    {
        return users_dao.save(user);
    }


    //Printall
    public List<Users> getAllUsers()
    {
        return users_dao.findAll();
    }

    public void deleteUser(int id)
    {
        users_dao.deleteById(id);
    }

    public Users updateUser(int id, Users userDetails) {
        Users user = users_dao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        return users_dao.save(user);
    }
}
