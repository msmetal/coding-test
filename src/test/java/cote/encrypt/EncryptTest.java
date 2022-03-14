package cote.encrypt;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;

public class EncryptTest {

    @Test
    public void test() throws Exception {
        String str = "beta-vroong:apiKey";
        //2ae882b8aa58dec9df0fd5bb83e5d3bf2b1baa3b0576511f21501df967f3cfcf
//        String str = "beta-vroong:secretKey";
        //fb66ec0fce102a3b3e3465188373d5ee7960afb9707734a6133249e7aa6786ff
        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        sh.update(str.getBytes());
        byte byteData[] = sh.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println(sb);
    }
}
