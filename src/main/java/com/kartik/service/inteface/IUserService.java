package com.kartik.service.inteface;

import com.kartik.entity.User;

public interface IUserService {
    User validate(User user)  throws Exception;
    User requestUserLogin() throws Exception;
}
