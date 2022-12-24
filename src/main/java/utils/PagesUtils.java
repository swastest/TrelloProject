package utils;

import api.conrtollers.BoardController;
import api.conrtollers.ListController;
import configProperties.UserProperties;
import org.aeonbits.owner.ConfigFactory;
import ui.flow.*;

public class PagesUtils {

    protected HomePageFlow homePageFlow = new HomePageFlow();
    protected MainPageFlow mainPageFlow = new MainPageFlow();
    protected SingInPageFlow singInPageFlow = new SingInPageFlow();
    protected MainBoardPageFlow mainBoardPageFlow = new MainBoardPageFlow();
    protected SomeTableFlow someTableFlow = new SomeTableFlow();
    protected UserProperties userConfig = ConfigFactory.create(UserProperties.class, System.getProperties());
    protected BoardController boardController = new BoardController();
    protected ListController listController = new ListController();

}
