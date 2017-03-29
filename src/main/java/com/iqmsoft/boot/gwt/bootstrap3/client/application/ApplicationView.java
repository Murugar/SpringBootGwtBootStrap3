package com.iqmsoft.boot.gwt.bootstrap3.client.application;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.Container;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.iqmsoft.boot.gwt.bootstrap3.client.application.ApplicationPresenter.MyView;

public class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers> implements MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    Label welcomeLabel;
    
    @UiField
    Container c;
    

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void displayUserName(String userName) {
        welcomeLabel.setText("Welcome " + userName +" !");
    }

    @UiHandler("logout")
    void onLogoutClicked(ClickEvent event) {
        getUiHandlers().logout();
    }
}
