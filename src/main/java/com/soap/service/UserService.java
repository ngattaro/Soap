package com.soap.service;


import com.ngatdo.soapws.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(1112);
        sam.setSalary(32000);
        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(1113);
        ryan.setSalary(16000);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);
    }


    public User getUsers(String name) {
        return users.get(name);
    }

    public User[] getAllUsers()
    {
        Set<String> list = users.keySet();
        User[] u = new User[list.size()];
        int i=0;
        for(String name : list){
            u[i] = users.get(name);
            i++;
        }
        return u;
    }
    public User addUser(User user)
    {
        users.put(user.getName(), user);
        return user;
    }
    public User updateUser(User user)
    {
        users.put(user.getName(), user);
        return user;
    }
    public User deleteUser(String name)
    {
        User user = users.get(name);
        users.remove(name);
        return  user;
    }
}
