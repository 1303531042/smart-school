package com.kun;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author KUN
 * @date 2022/12/21
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        // 获取文件的输入流对象
        FileInputStream fileInputStream = new FileInputStream(ResourceUtils.getFile("classpath:power.json"));
        int len;
        byte[] bytes = new byte[1024];
        StringBuilder stringBuffer = new StringBuilder();
        while ((len = fileInputStream.read(bytes)) != -1) {
            // 添加字符串到缓冲区
            stringBuffer.append(new String(bytes, 0, len));
        }
        // 关闭资源
        fileInputStream.close();

//        // 获取日期
//        JSONObject jsonObject = JSONObject.parseObject((stringBuffer.toString()));
//        JSONObject mainData = jsonObject.getJSONObject("MainData");
//        JSONArray data = mainData.getJSONObject("chart").getJSONObject("xAxis").getJSONArray("data");
//        for(int i=0;i<data.size()/2;i++) {
//            String str =(String) data.get(i);
//            System.out.println("2020-"+str+":00");
//        }
//        for(int i=data.size()/2;i<data.size();i++) {
//            String str =(String) data.get(i);
//            System.out.println("2020-"+str+":00");
//        }

        //获取值
        JSONObject jsonObject = JSONObject.parseObject((stringBuffer.toString()));
        JSONArray data = jsonObject.getJSONObject("MainData").getJSONObject("chart").getJSONArray("series").getJSONObject(0).getJSONArray("data");
//        for (int i=0;i<data.size()/2;i++) {
//            String str = (String) data.getJSONObject(i).getJSONArray("value").get(1);
//            System.out.println(str);
//
//        }
        for (int i = 0; i < data.size(); i++) {
            String str = (String) data.getJSONObject(i).getJSONArray("value").get(1);
            System.out.println(str);
        }




//        String str = "0: {time: \"2020-01\", value: \"1905.07\"}\n" +
//                "1: {time: \"2020-02\", value: \"732.24\"}\n" +
//                "2: {time: \"2020-03\", value: \"588.45\"}\n" +
//                "3: {time: \"2020-04\", value: \"734.94\"}\n" +
//                "4: {time: \"2020-05\", value: \"742.07\"}\n" +
//                "5: {time: \"2020-06\", value: \"943.56\"}\n" +
//                "6: {time: \"2020-07\", value: \"633.67\"}\n" +
//                "7: {time: \"2020-08\", value: \"2154.38\"}\n" +
//                "8: {time: \"2020-09\", value: \"2415.60\"}\n" +
//                "9: {time: \"2020-10\", value: \"1888.97\"}\n" +
//                "10: {time: \"2020-11\", value: \"2651.32\"}\n" +
//                "11: {time: \"2020-12\", value: \"5005.96\"}\n" +
//                "12: {time: \"合计\", value: \"20396.24\"}";
//
//        String[] strs = str.split("\n");
//        for (String s : strs) {
//            int i = s.indexOf("value: ");
//            i += 8;
//            s = s.substring(i);
//            int j = s.indexOf("\"");
//            s = s.substring(0, j);
//            System.out.println(s);
//        }
    }
}
