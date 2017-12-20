package com.service.impl;

import com.service.CharacterTransformService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by 54472 on 2017/12/20.
 */
@Service(value = "characterTransformServiceImpl")
public class CharacterTransformServiceImpl implements CharacterTransformService {

    private static String sKey = "abcdef0123456789";
    private static String ivParameter = "0123456789abcdef";

    //加密
    public String encrypt(String str) {
        String result = null;
        try {
            Cipher cipher;
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] raw = sKey.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
            result = new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result;
    }
}
