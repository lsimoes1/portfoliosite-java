package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portfoliosite.api.FakeApiController;
import com.portfoliosite.api.GithubController;
import com.portfoliosite.service.abs.FakeCredCardApiInterface;
import com.portfoliosite.service.impl.FakeCredCardApiImpl;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakerCredCardApiControllerTest {

    @Mock
    private final FakeCredCardApiInterface fakeCredCardApiInterface = mock(FakeCredCardApiImpl.class);

    @Test
    public void TestResponseOk() throws JsonProcessingException {
        when(fakeCredCardApiInterface.getCredCard(1)).thenReturn(null);

        FakeApiController fakeApiController = new FakeApiController(fakeCredCardApiInterface);
        var responseGitHub = fakeApiController.getCredCard(1);
        Assertions.assertEquals(HttpStatus.OK, responseGitHub.getStatusCode());
    }
}
