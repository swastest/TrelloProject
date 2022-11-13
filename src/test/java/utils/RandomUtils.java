package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public String getRandomBoardName(){
        return faker.name().title();
    }
}
