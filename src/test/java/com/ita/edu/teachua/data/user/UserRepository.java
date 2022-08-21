package com.ita.edu.teachua.data.user;

import com.ita.edu.teachua.utils.TestValueProvider;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.UsersServices;

import java.util.List;

public class UserRepository {

    TestValueProvider testValueProvider = new TestValueProvider();
    User user = new User();

    public List<UserEntity> getAllUsers(){
        UsersServices usersServices = new UsersServices();
        return usersServices.selectAll();
    }

    public User adminUser(){
        return createUser(testValueProvider.getAdminEmail(), user , testValueProvider.getAdminPassword());
    }

    public User baseUser(){
        return createUser(testValueProvider.getBaseEmail(), user , testValueProvider.getBasePassword());
    }

    public User leaderUser(){
        return createUser(testValueProvider.getLeaderEmail(), user , testValueProvider.getLeaderPassword());
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
        return new User();
    }

}
