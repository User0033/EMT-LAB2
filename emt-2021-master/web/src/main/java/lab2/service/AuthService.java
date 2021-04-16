package lab2.service;

import lab2.model.User;

public interface AuthService {

    User login(String username, String password) throws Exception;

}
