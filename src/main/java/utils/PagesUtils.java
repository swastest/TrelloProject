package utils;

import api.precondition.BoardsPrecondition;
import com.codeborne.selenide.Configuration;
import configProperties.UserProperties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import ui.flow.*;

public abstract class PagesUtils {
    @BeforeAll
    public static void setUp(){
        Configuration.timeout = 60000;
    }

    protected BoardsPrecondition boardsPrecondition = new BoardsPrecondition();
    protected HomePageFlow homePageFlow = new HomePageFlow();
    protected MainPageFlow mainPageFlow = new MainPageFlow();
    protected SingInPageFlow singInPageFlow = new SingInPageFlow();
    protected MainBoardPageFlow mainBoardPageFlow = new MainBoardPageFlow();
    protected SomeTableFlow someTableFlow = new SomeTableFlow();
    protected UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
}
