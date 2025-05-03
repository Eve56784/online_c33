package sessionfacade.service;

import sessionfacade.entity.User;

public class UserService {
    public User createUser(String name) {
        System.out.println("Name: " + name);
        return new User(1, name);
    }
}
