package test;

import org.junit.Test;

import common.utils.SendPhoneMsg;

public class TestSendPhoneMsg {
	@Test
	public void TestPhoneMsg() {
		String code = SendPhoneMsg.sendPhoneMsg("13559001823");
		System.out.println(code);
		System.out.println(1);
	}
}
