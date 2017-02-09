package ua.application.core;

import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Factory {

    public  static String getResourceMD5(String path){
        URL url;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        String line;
        StringBuilder content = new StringBuilder();
        try{
            url = new URL(path);
            inputStream = url.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            line = bufferedReader.readLine();
            while(line!=null){content.append(line);
                line = bufferedReader.readLine();
            }
        }catch (MalformedURLException mue){
            mue.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(inputStream!=null){
                    inputStream.close();
                }
                if(bufferedReader!=null){
                    bufferedReader.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return  generateMD5(content.toString());
    }
    private  static String generateMD5(String content){
        BigInteger bigInt = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(content.getBytes(),0,content.length());
            bigInt = new BigInteger(1,messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return bigInt.toString(16);
    }



}
