package com.iqmsoft.boot.gwt.bootstrap3.server.controller;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.boot.gwt.bootstrap3.server.service.UserService;
import com.iqmsoft.boot.gwt.bootstrap3.shared.model.User;

import static com.iqmsoft.boot.gwt.bootstrap3.shared.ResourcePaths.User.LOGIN;
import static com.iqmsoft.boot.gwt.bootstrap3.shared.ResourcePaths.User.ROOT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = LOGIN, method = GET)
    @PermitAll
    ResponseEntity<Boolean> isCurrentUserLoggedIn() {
        return new ResponseEntity<>(userService.isCurrentUserLoggedIn(), OK);
    }

    @RequestMapping(method = GET)
    ResponseEntity<User> getCurrentUser() {
        return ok(userService.getCurrentUser());
    }
}
