package com.learn;

import com.learn.tools.EncryptionCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class LearnApplicationTests {


    @Test
    void test1(){
        String co = "787a78383139323030314d3b093f56";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse("2021-09-24 12:50:35");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String ok = EncryptionCode.decrypt(co,new Long(date.getTime()).toString());
        System.out.println("=============================="+ok+"===================================");
    }

    @Test
    void contextLoads() {
    }

}
