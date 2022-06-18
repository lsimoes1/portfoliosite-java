package faker;

import com.github.javafaker.Faker;
import com.portfoliosite.model.Github;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GitHubFaker {
    public static List<Github> createGithubFaker(){
        Faker faker = new Faker(new Locale("pt-BR"));
        Github github = new Github();

        github.setDescription(faker.lorem().word());
        github.setHomePage(faker.internet().url());
        github.setLanguage(faker.lorem().word());
        github.setLastUpdate(faker.date().past(12, TimeUnit.DAYS).toString());
        github.setNameProject(faker.lorem().word());
        github.setUrlRepository(faker.internet().url());
        return List.of(github);
    }
}
