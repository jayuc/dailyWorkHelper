package com.github.jayuc.daily.study.hik_video;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

import java.util.HashMap;
import java.util.Map;

public class HikVideoDemo {

    static {
        ArtemisConfig.host = "192.168.10.180:443"; // 平台/nginx的IP和端口（https端口默认为443）
        ArtemisConfig.appKey = "28146904"; // 合作方Key
        ArtemisConfig.appSecret = "mdGpnXMedJWwsNQXG4GE";// 合作方Secret
    }
    /**
     * API网关的后端服务上下文为：/artemis
     */
    private static final String ARTEMIS_PATH = "/artemis";

    public static void fetchVideo(){
        String getCamsApi = ARTEMIS_PATH + "/api/video/v1/cameras/previewURLs";
        Map<String, String> paramMap = new HashMap<String, String>();// post请求Form表单参数
        paramMap.put("cameraIndexCode", "a9ad94044fda411d8878608929b1c2d1");
        paramMap.put("streamType", "0");
        paramMap.put("protocol", "rtsp");
        paramMap.put("transmode", "0");
        String body = JSON.toJSON(paramMap).toString();
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", getCamsApi);
            }
        };
        String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        System.out.println(result);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject data = jsonObject.getJSONObject("data");
        Object urll = data.get("url");
        String url = (String) urll;
        System.out.println(url);

        String targetUrl = "rtmp://192.168.0.162:1935/live/123";

        FFempegUtil.convertProtocol(url, targetUrl, null);

    }

    public static void main(String[] args) {
        fetchVideo();
    }

}
