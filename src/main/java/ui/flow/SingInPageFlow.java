package ui.flow;

import com.codeborne.selenide.Selenide;
import ui.pom.pages.SingInPage;

public class SingInPageFlow {
    public SingInPageFlow setValueEmailLogin(String email){
        Selenide.page(SingInPage.class).getInputEmail().setValue(email);
        return this;
    }

    public SingInPageFlow clickNextAuthButton(){
        Selenide.page(SingInPage.class).getNextAuthButton().click();
        return this;
    }

    public SingInPageFlow setValuePassword(String password){
        Selenide.page(SingInPage.class).getInputPassword().setValue(password);
        return this;
    }

    public SingInPageFlow clickSubmitLoginButton(){
        Selenide.page(SingInPage.class).getLoginAuthButton().click();
        return this;
    }
}
