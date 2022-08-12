package com.ita.edu.teachua.utils.jdbc.dao;

import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;
import io.qameta.allure.Step;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ChallengesDAO {

    @Step("select By Name Picture Sort Number Title ClubsDAO")
    public List<ChallengesEntity> selectByNamePictureSortNumberTitle(String getsortnumber, int getsortnumberint) {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.SELECT_ALL,getsortnumber,getsortnumberint));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDAO.getInstance().closeStatement(statement);
        return ChallengesEntity.getChallenges(rows);
    }
    @Step("select By Name Wher eId ClubsDAO")
    public List<ChallengesEntity> selectByNameWhereId(long getsortnumberint) {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.SELECT_NAME_WHERE_ID,getsortnumberint));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDAO.getInstance().closeStatement(statement);

        return ChallengesEntity.getChallengesBYName(rows);
    }

    @Step("Select all")
    public List<ChallengesEntity> selectAll() {
        Statement statement = ManagerDAO.getInstance().getStatement();
        List<List<String>> rows = null;
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.SELECT_ALL));
            rows = ManagerDAO.getInstance().parseResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        ManagerDAO.getInstance().closeStatement(statement);

        return ChallengesEntity.getChallenges(rows);
    }

    @Step("Delete challenge with current name")
    public void deleteByName(String name) {
        Statement statement = ManagerDAO.getInstance().getStatement();
        try {
            ResultSet resultSet = statement.executeQuery(String.format(ChallengesEntity.DELETE_FROM_CHALLENGES_WHERE_NAME,name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ManagerDAO.getInstance().closeStatement(statement);
    }
}
