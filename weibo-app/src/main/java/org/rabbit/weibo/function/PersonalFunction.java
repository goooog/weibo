package org.rabbit.weibo.function;

import weibo4j.Weibo;
import weibo4j.http.AccessToken;
import weibo4j.model.PostParameter;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

/**
 * sina_weibo4j_api的使用
 * @author rabbit1987
 *
 */
public class PersonalFunction {
	private AccessToken accessToken;
	private Weibo weibo;

	public PersonalFunction(AccessToken accessToken) {
		this.accessToken = accessToken;
		weibo = new Weibo();
		weibo.setToken(this.accessToken.getAccessToken());
	}

	/**
	 * 查詢用戶信息
	 * @param uid
	 * @return
	 * @throws WeiboException
	 */
	public User showUser(String uid) throws WeiboException {
		User user = new User(this.weibo.client.get(
				this.getWeiboBaseURL() + "users/show.json",
				new PostParameter[] { new PostParameter("uid", uid) })
				.asJSONObject());
		return user;
	}
	
	/**
	 * 发布一条微博消息
	 * @param status
	 * @throws WeiboException
	 */
	public void updateStatus(String status) throws WeiboException{
		this.weibo.client.post(this.getWeiboBaseURL()+"statuses/update.json", new PostParameter[]{
			new PostParameter("status",status)
		});
	}
	
	private String getWeiboBaseURL(){
		return WeiboConfig.getValue("baseURL");
	}
	

}
