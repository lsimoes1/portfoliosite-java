package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfoliosite.configuration.exception.CustomExceptionHandler;
import com.portfoliosite.model.Github;
import com.portfoliosite.service.impl.GithubServiceImpl;
import com.portfoliosite.service.abs.GithubInterface;
import com.portfoliosite.utils.JsonUtils;
import faker.GitHubFaker;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GithubServiceTest {

    private static final RestTemplate restTemplate = mock(RestTemplate.class);
    private static final RestTemplateBuilder restTemplateBuilder = mock(RestTemplateBuilder.class);
    private static GithubInterface githubService;
    private static List<Github> github;
    private static String githubJson;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeAll
    static void setup() {
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        githubService = new GithubServiceImpl(restTemplateBuilder);
        ReflectionTestUtils.setField(githubService, "url", "http://localhost/" );

        github = GitHubFaker.createGithubFaker();
    }

    @Test
    public void testResponseGitHubIsNotNull() throws JsonProcessingException {
        githubJson = JsonUtils.ObjectToJson(github);
        when(restTemplate.getForObject("http://localhost/", String.class)).thenReturn(githubJson);
        List<Github> responseGetRepository = githubService.getRepository();

        Assertions.assertNotNull(responseGetRepository);
    }

    @Test
    public void testResponseGitHubIsNull() throws JsonProcessingException {
        Throwable cause = null;

        when(restTemplate.getForObject("http://localhost/", String.class)).thenReturn(null);
        try {
            List<Github> responseGetRepository = githubService.getRepository();
        } catch (Throwable ex){
            cause = ex;
        }
        Assertions.assertTrue(cause instanceof CustomExceptionHandler);
    }
}