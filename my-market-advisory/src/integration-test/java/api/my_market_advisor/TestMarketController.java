package api.my_market_advisor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestMarketController extends AbstractTestNGSpringContextTests {

    private MockMvc mockMVC;

    @Autowired
    private WebApplicationContext wac;
    @LocalServerPort
    private int port;

    @DataProvider(name = "companyFields")
    Object[][] companyFields() {
        return new Object[][]{
                {"amzn", "5"},
                {"fb", "4"},
                {"googl", "3"},
                {"nflx", "10"},
                {"jci", "6"},
                {"pfe", "20"},
                {"spy", "1"}
        };
    }

    @Test(dataProvider = "companyFields", alwaysRun = true)
    public void testNewsFeed(String symbol, String last) throws Exception {
        this.mockMVC = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockHttpServletResponse response = this.mockMVC.perform(get("https://localhost:"
                + "8080" + "/"
                + symbol + "/"
                + last)
                .accept(MediaType.ALL)).andReturn().getResponse();
        Assert.assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
}