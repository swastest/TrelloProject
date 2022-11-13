package ui;

import configProperties.UserProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ExUi1 {
    static UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
    Actions actions = new Actions();

    @Test
    void test01() {
        open(userConfig.url());
       actions.clickLoginButton()
               .selectGoogleLogin()
               .setValueEmail(userConfig.email())
               .clickNextButton();
        sleep(5000);

    }
}
