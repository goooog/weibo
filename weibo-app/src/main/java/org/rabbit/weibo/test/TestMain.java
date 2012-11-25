package org.rabbit.weibo.test;

import org.rabbit.weibo.function.PersonalFunction;
import org.rabbit.weibo.login.UserLogin;

import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class TestMain {
	public static void main(String[] args) throws WeiboException {
		UserLogin ul = new UserLogin();
		AccessToken token = ul.login();

		PersonalFunction pf = new PersonalFunction(token);
		User user = pf.showUser("3149591055");
		pf.updateStatus("Hello,world!my God");
		System.out.println("user:" + user.toString());
	}
}
