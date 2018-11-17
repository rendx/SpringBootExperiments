import com.huawei.springbootdemo.SpringbootdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = {SpringbootdemoApplication.class})
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApi() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test/home")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

    }

}
