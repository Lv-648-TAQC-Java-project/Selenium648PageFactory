package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ChallengesDAO;
import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;

import java.util.List;

public class ChallengesServices {
    private final ChallengesDAO challengesDAO;

    public ChallengesServices() {

        challengesDAO = new ChallengesDAO();
    }
    public List<ChallengesEntity> getAll(String getsortnumber, int getsortnumberint) {

        return challengesDAO.selectByNamePictureSortNumberTitle(getsortnumber,getsortnumberint);
    }
    public List<ChallengesEntity> getMameWhereId(long getsortnumberint) {

        return challengesDAO.selectByNameWhereId(getsortnumberint);
    }
}
