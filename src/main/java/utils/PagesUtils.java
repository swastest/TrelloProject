package utils;

import configProperties.UserProperties;
import org.aeonbits.owner.ConfigFactory;
import ui.flow.*;

public abstract class PagesUtils {
    protected HomePageFlow homePageFlow = new HomePageFlow();
    protected MainPageFlow mainPageFlow = new MainPageFlow();
    protected SingInPageFlow singInPageFlow = new SingInPageFlow();
    protected MainBoardPageFlow mainBoardPageFlow = new MainBoardPageFlow();
    protected ExpectResultApi expectResultApi = new ExpectResultApi();
    protected SomeTableFlow someTableFlow = new SomeTableFlow();
    protected UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
}
