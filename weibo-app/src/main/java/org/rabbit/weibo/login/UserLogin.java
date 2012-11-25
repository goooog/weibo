package org.rabbit.weibo.login;

import java.util.Scanner;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

/**
 * 用户登录，取得微博授权token
 * @author rabbit1987
 *
 */
public class UserLogin {
	
	/**
	 * 
	 * @return
	 * @throws WeiboException
	 */
	public AccessToken login() throws WeiboException {
		Oauth oauth = new Oauth();

		BareBonesBrowserLaunch.openURL(oauth.authorize("code", null));

		System.out
				.print("Please input the code returned from weibo and then hit your Enter Key:");
		Scanner scanner = new Scanner(System.in);
		String code = scanner.nextLine();

		return oauth.getAccessTokenByCode(code);
	}

}
