package com.lanou3g.tools;

import com.lanou3g.api.PhoneNum;
import com.lanou3g.api.Weather;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static com.lanou3g.constant.Constant.*;

public class URlrequest {
    public static void PhoneNum(String phno) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+phno+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        URLConnection coon = url.openConnection();
        InputStream is = coon.getInputStream();
        byte[] buff = new byte[1024 * 1024 * 1024];
        StringBuffer buffer = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff)) != -1) {
            buffer.append(new String(buff, 0, len));
        }
        JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
        PhoneNum phoneNo = (PhoneNum) JSONObject.toBean(jsonObject, PhoneNum.class);
        System.out.println(phoneNo.getResult().getAtt());
        is.close();
    }


    public static void Weather(String city) throws IOException {
        URL url = new URL("http://www.sojson.com/open/api/weather/json.shtml?city="+city);
        URLConnection coon = url.openConnection();

        InputStream is = coon.getInputStream();

        byte[] buff = new byte[1024 * 1024 * 1024];

        StringBuffer buffer = new StringBuffer();

        int len = 0;

        while ((len = is.read(buff)) != -1) {
            buffer.append(new String(buff, 0, len));
        }
        JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
        //System.out.println(buffer.toString());
        Weather weather = (Weather)JSONObject.toBean(jsonObject, Weather.class);
        System.out.println(weather.getData().getYesterday());
        is.close();


    }
}
