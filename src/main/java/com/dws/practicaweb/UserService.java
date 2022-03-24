package com.dws.practicaweb;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong lastid=new AtomicLong();

    public void addUser(User user){
        long userId=lastid.incrementAndGet();
        user.setUserId(userId);
        users.put(userId, user);
    }

    public Collection<User> getUsers(){
        return users.values();
    }

    public User getUser(long userId){
        return users.get(userId);
    }

    public void deleteUser(long userId){
        users.remove(userId);
    }

    public void updateUser(long userId, User userMod) {
        userMod.setUserId(userId);
        users.put(userId, userMod);
    }
}
