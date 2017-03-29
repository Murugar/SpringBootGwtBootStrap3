package com.iqmsoft.boot.gwt.bootstrap3.client.login;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class LoginModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class, LoginView.class,
                LoginPresenter.MyProxy.class);
    }
}
