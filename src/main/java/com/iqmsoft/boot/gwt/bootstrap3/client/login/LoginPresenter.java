package com.iqmsoft.boot.gwt.bootstrap3.client.login;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.iqmsoft.boot.gwt.bootstrap3.client.NameTokens;
import com.iqmsoft.boot.gwt.bootstrap3.client.login.LoginPresenter.MyProxy;
import com.iqmsoft.boot.gwt.bootstrap3.client.login.LoginPresenter.MyView;
import com.iqmsoft.boot.gwt.bootstrap3.client.security.CurrentUser;
import com.iqmsoft.boot.gwt.bootstrap3.client.services.UserService;

public class LoginPresenter extends Presenter<MyView, MyProxy> implements LoginUiHandlers {
    interface MyView extends View, HasUiHandlers<LoginUiHandlers> {
    }

    @NameToken(NameTokens.LOGIN)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }

    private final PlaceManager placeManager;
    private final RestDispatch dispatcher;
    private final UserService userService;
    private final CurrentUser currentUser;

    @Inject
    LoginPresenter(EventBus eventBus,
                   MyView view,
                   MyProxy proxy,
                   PlaceManager placeManager,
                   RestDispatch dispatcher,
                   UserService userService,
                   CurrentUser currentUser) {
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.userService = userService;
        this.currentUser = currentUser;

        getView().setUiHandlers(this);
    }

    @Override
    public void login(String login, String password) {
        sendLoginRequest(login, password);
    }

    private void sendLoginRequest(String username, String password) {
        dispatcher.execute(userService.login(username, password), new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                onLoginSuccess();
            }

            @Override
            public void onFailure(Throwable caught) {
                onLoginFailure();
            }
        });
    }

    private void onLoginSuccess() {
        currentUser.setLoggedIn(true);
        PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.HOME).build();
        placeManager.revealPlace(placeRequest);
    }

    private void onLoginFailure() {
        Window.alert("Wrong login or password.");
    }
}
