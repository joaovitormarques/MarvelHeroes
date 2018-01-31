package com.example.joaovitor.shared;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by joaovitor on 31/08/17.
 */

public class HashGenerator {
    private final String publicKey;
    private final String privateKey;
    private final Long timestamp;
    public HashGenerator(String publicKey, String privateKey){

        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.timestamp = new Date().getTime();

    }
    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getHashMD5(){
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            String concatedKeys = String.format("%s%s%s", getTimestamp(), getPrivateKey(), getPublicKey());
            byte [] digestArray = concatedKeys.getBytes();
            digest.update(digestArray);
            return  createHEXMD5(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private String createHEXMD5(byte[] messageDigest){
        StringBuilder hexString = new StringBuilder();
        for (byte aMessageDigest : messageDigest) {
            String h = Integer.toHexString(0xFF & aMessageDigest);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }
        String s = hexString.toString();
        return s;
    }
}
