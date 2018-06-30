package common.utils;

import java.util.Random;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SendPhoneMsg {
	static final String product = "Dysmsapi";
	static final String domain = "dysmsapi.aliyuncs.com";
	
	static final String accessKeyId = "";
	static final String accessKeySecret = "";
	
	private static SendSmsResponse sendSms(String phone) throws ClientException{
		

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        
        SendSmsRequest request = new SendSmsRequest();
        
        request.setPhoneNumbers(phone);
        request.setSignName("课下交流系统");
        request.setTemplateCode("SMS_138067573");
        Random random = new Random();
        int f1 = random.nextInt(100000);
        int f2 = random.nextInt(100001);
        Random random2 = new Random(f1*f2);
        String code = "";
        for (int i = 0;i < 6;i++) {
        	int num = random2.nextInt(10);
        	code += Integer.toString(num);
        }
        request.setTemplateParam("{\"code\":"+code+"}");
        
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        
        return sendSmsResponse;
	}
	
	
	public static String sendPhoneMsg(String phone) {
		SendSmsResponse response;
		try {
			response = sendSms(phone);
			return response.getCode();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
