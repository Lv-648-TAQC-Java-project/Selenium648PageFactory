package com.ita.edu.teachua.utils.jdbc.services;

import com.ita.edu.teachua.utils.jdbc.dao.ChallengesDAO;
import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;

import java.util.List;

public class ChallengesServices {
    private final ChallengesDAO challengesDAO;

    public ChallengesServices() {
        challengesDAO = new ChallengesDAO();
    }
    public List<ChallengesEntity> getAll() {
        return challengesDAO.selectAll();
    }
    public List<ChallengesEntity> getMameWhereId(long getsortnumberint) {
        return challengesDAO.selectByNameWhereId(getsortnumberint);
    }

    public void deleteChallengesByName(String name) {
        challengesDAO.deleteByName(name);
    }
}
