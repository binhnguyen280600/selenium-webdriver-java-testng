package javaSDET;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_03_Random {


    String prefixEmail = "Binh";

    String postfixEmail = "@gmail.com";



    @Test
    public void Email(){
        Random rand = new Random();
        String fullEmail = prefixEmail + rand.nextInt(99999) + postfixEmail;
        System.out.println(fullEmail);
    }
}
