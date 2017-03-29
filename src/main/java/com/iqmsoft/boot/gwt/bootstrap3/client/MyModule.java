package com.iqmsoft.boot.gwt.bootstrap3.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;
import com.iqmsoft.boot.gwt.bootstrap3.client.application.ApplicationModule;
import com.iqmsoft.boot.gwt.bootstrap3.client.login.LoginModule;
import com.iqmsoft.boot.gwt.bootstrap3.client.security.CurrentUser;
import com.iqmsoft.boot.gwt.bootstrap3.client.services.ServiceModule;

public class MyModule extends AbstractGinModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .placeManager(DefaultPlaceManager.class)
                .tokenFormatter(RouteTokenFormatter.class)
                .build());

        bind(CurrentUser.class).asEagerSingleton();

        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.getHome());
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.getHome());
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.getLogin());

        install(new ServiceModule());
        install(new LoginModule());
        install(new ApplicationModule());
    }
}
