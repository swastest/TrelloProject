package utils;

import configProperties.UserProperties;
import org.aeonbits.owner.ConfigFactory;
import ui.flow.HomePageFlow;
import ui.flow.MainBoardPageFlow;
import ui.flow.MainPageFlow;
import ui.flow.SingInPageFlow;

public abstract class PagesUtils {
    protected  HomePageFlow homePageFlow = new HomePageFlow();
    protected  MainPageFlow mainPageFlow = new MainPageFlow();
    protected  SingInPageFlow singInPageFlow = new SingInPageFlow();
    protected MainBoardPageFlow mainBoardPageFlow = new MainBoardPageFlow();
    protected UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
}
