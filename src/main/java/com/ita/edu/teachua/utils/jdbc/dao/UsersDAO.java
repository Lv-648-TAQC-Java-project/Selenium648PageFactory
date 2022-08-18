package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import io.qameta.allure.Step;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UsersDAO {

    @Step("Select all")
    public List<UserEntity> selectAll() {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(UserEntity.SELECT_ALL));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDAO.getInstance().closeStatement(statement);

        return UserEntity.getUsers(rows);
    }
}
