package com.huawei.springbootdemo;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
public class SpringbootdemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCase01(){
        System.out.println("test Case 01 ");
        TestCase.assertEquals(1, 1);
    }

    @Test
    public void testCase02(){
        System.out.println("test Case 02");
        TestCase.assertEquals(1, 1);
    }

    @Before
    public void testBefore(){
        System.out.println("test Before");
    }

    @After
    public void testAfter(){
        System.out.println("test After");
    }

}
