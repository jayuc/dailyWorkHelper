package com.github.jayuc.daily.study.day20200817;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;

public class ArtemisPostTest {
	/**
	 * 请根据技术支持提供的实际的平台IP/端口和API网关中的合作方信息更换static静态块中的三个参数.
	 * [1 host]
	 * 		host格式为IP：Port，如10.0.0.1:443
	 * 		当使用https协议调用接口时，IP是平台（nginx）IP，Port是https协议的端口；
	 *     当使用http协议调用接口时，IP是artemis服务的IP，Port是artemis服务的端口（默认9016）。
	 * [2 appKey和appSecret]
	 * 		请按照技术支持提供的合作方Key和合作方Secret修改
	 * 	    appKey：合作方Key
	 * 	    appSecret：合作方Secret
	 * 调用前看清接口传入的是什么，是传入json就用doPostStringArtemis方法，是表单提交就用doPostFromArtemis方法
	 *
	 */
	static {
		ArtemisConfig.host = "192.168.10.180:443"; // 平台/nginx的IP和端口（https端口默认为443）
		ArtemisConfig.appKey = "28146904"; // 合作方Key
		ArtemisConfig.appSecret = "mdGpnXMedJWwsNQXG4GE";// 合作方Secret
	}
	/**
	 * API网关的后端服务上下文为：/artemis
	 */
	private static final String ARTEMIS_PATH = "/artemis";

	/**
	 * 调用POST请求类型接口，这里以获取组织列表为例
	 * 接口实际url:https://ip:port/artemis/api/resource/v1/org/orgList
	 * @return
	 */
	public static String callPostApiGetOrgList() {
		/**
		 * https://ip:port/artemis/api/resource/v1/org/orgList
		 * 通过查阅AI Cloud开放平台文档或网关门户的文档可以看到获取组织列表的接口定义,该接口为POST请求的Rest接口, 入参为JSON字符串，接口协议为https。
		 * ArtemisHttpUtil工具类提供了doPostStringArtemis调用POST请求的方法，入参可传JSON字符串, 请阅读开发指南了解方法入参，没有的参数可传null
		 */
		String  getCamsApi = ARTEMIS_PATH + "/api/resource/v1/org/orgList";
		Map<String, String> paramMap = new HashMap<String, String>();// post请求Form表单参数
		paramMap.put("pageNo", "1");
		paramMap.put("pageSize", "2");
		String body = JSON.toJSON(paramMap).toString();
		Map<String, String> path = new HashMap<String, String>(2) {
			{
				put("https://", getCamsApi);
			}
		};
		String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
		return result;
	}


	/**
	 * 调用POST请求类型接口，这里以分页获取区域列表为例
	 * 接口实际url：https://ip:port/artemis/api/api/resource/v1/regions
	 * @return
	 */
	public static String callPostApiGetRegions(){
		/**
		 * https://ip:port/artemis/api/resource/v1/regions
		 * 过查阅AI Cloud开放平台文档或网关门户的文档可以看到分页获取区域列表的定义,这是一个POST请求的Rest接口, 入参为JSON字符串，接口协议为https。
		 * ArtemisHttpUtil工具类提供了doPostStringArtemis调用POST请求的方法，入参可传JSON字符串, 请阅读开发指南了解方法入参，没有的参数可传null
		 */
		String getCamsApi = ARTEMIS_PATH + "/api/resource/v1/regions";
		Map<String, String> paramMap = new HashMap<String, String>();// post请求Form表单参数
		paramMap.put("pageNo", "1");
		paramMap.put("pageSize", "2");
		paramMap.put("treeCode", "0");
		String body = JSON.toJSON(paramMap).toString();
		Map<String, String> path = new HashMap<String, String>(2) {
			{
				put("https://", getCamsApi);
			}
		};
		String result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
		return result;
	}

	public static void main(String[] args) {
		String result = callPostApiGetOrgList();
        System.out.println();
        System.out.println("================================================================================================");
        System.out.println(result);
		String VechicleDataResult = callPostApiGetRegions();
        System.out.println();
        System.out.println("================================================================================================");
		System.out.println(VechicleDataResult);
	}


}
