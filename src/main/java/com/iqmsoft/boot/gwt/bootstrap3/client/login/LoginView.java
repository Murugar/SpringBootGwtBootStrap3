package com.iqmsoft.boot.gwt.bootstrap3.client.login;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.SubmitButton;
import org.gwtbootstrap3.client.ui.Input;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;

import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LoginView extends ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    TextBox login;
    @UiField
    Input password;
    
    @UiField
    Container c;
    
   
    
    @UiField
    SubmitButton submit;
    
   
    
    @UiField
    org.gwtbootstrap3.client.ui.FormLabel login1;
    
    @UiField
    org.gwtbootstrap3.client.ui.FormLabel pwd1;

    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("submit")
    void onSubmitClicked(ClickEvent event) {
        getUiHandlers().login(login.getText(), password.getText());
    }
}
