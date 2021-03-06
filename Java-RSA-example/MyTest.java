package com.lm.test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yzh0037
 * @Date: 2019/1/9 16:14
 * @Description:
 */
public class MyTest {

    public static <HashMap> void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Map<String, Object> map = RSAUtils.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        System.out.println("--publick to string---");
        System.out.println(publicKey.toString());
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        //明文
        String ming = "123456789";
        //使用模和指数生成公钥和私钥
        System.err.println("----- modulus -------");
        System.err.println(modulus);
        System.err.println("----- public_exponent -------");
        System.err.println(public_exponent);
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        System.err.println("-----pubKey -------");
        System.err.println(pubKey);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        //加密后的密文
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.err.println(mi);
        //解密后的明文
        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.err.println(ming);
    }
}
