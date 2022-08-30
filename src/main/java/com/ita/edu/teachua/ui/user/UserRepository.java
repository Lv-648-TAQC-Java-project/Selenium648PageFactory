package com.ita.edu.teachua.ui.user;

import com.ita.edu.teachua.utils.MainValueProvider;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.UsersServices;

import java.io.IOException;
import java.util.List;


public final class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository(){}

    public static UserRepository get(){
        if (instance == null){
            synchronized (UserRepository.class){
                if (instance == null){
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    MainValueProvider mainValueProvider;

    {
        try {
            mainValueProvider = new MainValueProvider();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    User user = new User();

    public List<UserEntity> getAllUsers(){
        UsersServices usersServices = new UsersServices();
        return usersServices.selectAll();
    }

    public User adminUser(){
        return createUser(mainValueProvider.getAdminEmail(), user , mainValueProvider.getAdminPassword());
    }

    public User baseUser(){
        return createUser(mainValueProvider.getBaseEmail(), user , mainValueProvider.getBasePassword());
    }

    public User leaderUser(){
        return createUser(mainValueProvider.getLeaderEmail(), user , mainValueProvider.getLeaderPassword());
    }

    public User createUser (String email , User user , String UIPassword){
        List<UserEntity> list = getAllUsers();
        for (int i = 0; i < list.size(); i++ ) {
            if (list.get(i).getEmail().equals(email)){
                user.setId(list.get(i).getId());
                user.setEmail(list.get(i).getEmail());
                user.setFirst_name(list.get(i).getFirst_name());
                user.setLast_name(list.get(i).getLast_name());
                user.setPassword(list.get(i).getPassword());
                user.setUIPassword(UIPassword);
                user.setPhone(list.get(i).getPhone());
                user.setPhone(list.get(i).getPhone());
                user.setStatus(list.get(i).getStatus());
                user.setRole_id(list.get(i).getRole_id());
                break;
            }
        }
        return user;
    }

}
