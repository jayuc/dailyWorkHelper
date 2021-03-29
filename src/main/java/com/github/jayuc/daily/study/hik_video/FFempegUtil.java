package com.github.jayuc.daily.study.hik_video;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFempegUtil {

    public static void convertProtocol(String rtsp, String rtmp,String s){
//rtsp:海康rtsp地址
//rtmp:转换后的rtmp地址
//s: 分辨率

        ProcessBuilder builder = new ProcessBuilder(); //创建系统进程
        List<String> commend = new ArrayList<>();
        commend.add("D:/Program Files/ffmpeg-4.3.2-2021-02-27-essentials_build/ffmpeg-4.3.2-2021-02-27-essentials_build/bin/ffmpeg.exe");
        commend.add("-re");
        commend.add("-i");
        commend.add("\""+rtsp+"\"");
        commend.add("-f");
        commend.add("flv");
//        commend.add("-r");
//        commend.add("25");
//        commend.add("-s");
//        if (s==null)
//        {
//            s="1920x1080";
//        }
//        commend.add(s);
//        commend.add("-an");
        commend.add(rtmp);
        builder.command(commend);
        builder.redirectErrorStream(true);
        try {


            Process start = builder.start();//启动进程
            InputStream inputStream = start.getInputStream();
            InputStreamReader gbk = new InputStreamReader(inputStream);
            int len = -1;
            char[] c = new char[1024];
            StringBuffer outputString = new StringBuffer();

            //读取进程输入流中的内容
            while ((len = gbk.read(c)) != -1) {
                String ss = new String(c, 0, len);
                outputString.append(ss);
                System.out.print(ss);
            }


            gbk.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    //pid ffmpeg的进程pid号
    public static void closeLiu(String pid) {
        try{
            Runtime.getRuntime().exec("taskkill /F /PID "+pid+"");

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static String getPid() {
        String pid = null;
        try{
            Process process=Runtime.getRuntime().exec("tasklist /fi \"imagename eq ffmpeg.exe\" /fo list");
            InputStream inputStream = process.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream,"GBK"));
            String line;
            while((line=bf.readLine())!=null)
            {
                if (line.startsWith("PID")){
                    String[] array = line.split(":");
                    pid = array[1].trim();
                }

            }
            System.out.println("PID:"+pid);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return pid;
    }

    public static void main(String[] args) {
        String pid = getPid();
        System.out.println(pid);
    }

}
