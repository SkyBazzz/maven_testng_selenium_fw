package com.balkashyn;

import com.balkashyn.Base.BaseTest;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test
    public void secondTestMethod() {
        driver.get("http://facebook.com");
        System.out.println("facebook is opened");
    }
}