package com.automationdemo.support;

import java.util.Arrays;
import java.util.Random;

public class SeleniumSupportMethods {
    public String generateRandomEmail() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    public String generateRandomText(int textLength){
        char[] chars = new char[textLength];
        Arrays.fill(chars, 'x');
        String result = new String(chars);
        return result;
    }
}
