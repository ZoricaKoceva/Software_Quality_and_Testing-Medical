package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.SpringWebTests;
import mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.TestWebApp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


public class ProductControllerTests extends TestWebApp {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testProduct() throws Exception {
        mockMvc.perform(get("/product")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Leg"))
                .andExpect(jsonPath("$.category").value("smart leg"))
                .andExpect(jsonPath("$.id").value("1")).andExpect(jsonPath("$.price").value(5500.0));

    }


}