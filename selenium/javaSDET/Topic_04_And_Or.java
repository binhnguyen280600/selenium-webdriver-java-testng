package javaSDET;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_And_Or {

    @Test
    public void verifyAnd() {
        String contactInformation = "Binh Nguen\n" +
                "nhubinh33554345@gmail.com\n" +
                "Change Password";
        Assert.assertTrue(contactInformation.contains("Binh Nguen"));
        Assert.assertTrue(contactInformation.contains("nhubinh33554345@gmail.com"));

    }
}
