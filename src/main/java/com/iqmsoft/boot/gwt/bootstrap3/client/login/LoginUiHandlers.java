package com.iqmsoft.boot.gwt.bootstrap3.client.login;

import com.gwtplatform.mvp.client.UiHandlers;

public interface LoginUiHandlers extends UiHandlers {
    void login(String login, String password);
}
