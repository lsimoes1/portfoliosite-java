package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portfoliosite.api.GithubController;
import com.portfoliosite.service.impl.GithubServiceImpl;
import com.portfoliosite.service.abs.GithubInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.when;

public class GithubControllerTest {

    @Mock
    private final GithubInterface github = Mockito.mock(GithubServiceImpl.class);

    @Test
    public void TestResponseOk() throws JsonProcessingException {
        when(github.getRepository()).thenReturn(null);

        GithubController gihGithubController = new GithubController(github);
        var responseGitHub = gihGithubController.getRepository();
        Assertions.assertEquals(HttpStatus.OK, responseGitHub.getStatusCode());
    }
}
