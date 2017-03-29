package com.iqmsoft.boot.gwt.bootstrap3.server.service;

import java.util.List;

import com.iqmsoft.boot.gwt.bootstrap3.shared.model.User;

public interface UserService {
    User getUserByUsername(String username);

    List<String> getPermissions(String username);

    User getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
