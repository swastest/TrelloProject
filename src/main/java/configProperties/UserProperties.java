package configProperties;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/user.properties")
public interface UserProperties extends Config {
    String apiKey();
    String secretToken();
    String tokenCard();
    String tokenCard01();
    String url();
    String email();
    String pass();
}
