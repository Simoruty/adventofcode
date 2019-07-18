package com.simoruty;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "iwrupvqb";
        int i=0;
        String md5result;

        while (true){

            md5result = md5Hash(password.concat(String.valueOf(i)));
            if (md5result.startsWith("00000"))
                break;
            i++;
        }
        System.out.println("The integer is "+ i + " hash: " + md5result);

    }


    private static String md5Hash(String pwd) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(pwd.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
