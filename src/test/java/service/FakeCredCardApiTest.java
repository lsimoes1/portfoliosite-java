package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.portfoliosite.configuration.exception.CustomExceptionHandler;
import com.portfoliosite.model.Github;
import com.portfoliosite.service.abs.FakeCredCardApiInterface;
import com.portfoliosite.service.impl.FakeCredCardApiImpl;
import com.portfoliosite.utils.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakeCredCardApiTest {

    private static FakeCredCardApiInterface fakeCredCardApiInterface;
    private static final RestTemplate restTemplate = mock(RestTemplate.class);
    private static final RestTemplateBuilder restTemplateBuilder = mock(RestTemplateBuilder.class);

    @BeforeAll
    public static void setUp(){
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        fakeCredCardApiInterface = new FakeCredCardApiImpl(restTemplateBuilder);
        ReflectionTestUtils.setField(fakeCredCardApiInterface, "credCardUrl", "http://localhost/" );
    }

    @Test
    public void testResponseFakeCredCardIsNotNull() throws JsonProcessingException {
        String responseFake = "ResponseFake";
        when(restTemplate.getForObject("http://localhost/", String.class, 1)).thenReturn(responseFake);
        String responseGetRepository = fakeCredCardApiInterface.getCredCard(1);

        Assertions.assertNotNull(responseGetRepository);
    }

    @Test
    public void testResponseGitHubIsNull() throws JsonProcessingException {
        Throwable cause = null;

        when(restTemplate.getForObject("http://localhost/", String.class, 1)).thenReturn(null);
        try {
            String responseGetRepository = fakeCredCardApiInterface.getCredCard(1);
        } catch (Throwable ex){
            cause = ex;
        }
        Assertions.assertTrue(cause instanceof CustomExceptionHandler);
    }
}
