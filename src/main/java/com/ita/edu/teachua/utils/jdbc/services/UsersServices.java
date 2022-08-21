package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.UsersDAO;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;

import java.util.List;

public class UsersServices {
    private final UsersDAO usersDAO;

    public UsersServices(){
        usersDAO = new UsersDAO();
    }

    public List<UserEntity> selectAll(){
        return usersDAO.selectAll();
    }

}
