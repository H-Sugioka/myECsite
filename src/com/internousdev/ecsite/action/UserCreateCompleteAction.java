package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	//private String sameIdFlg;
	//private String sameUserMessage;
	private String result;
	public Map<String, Object> session;
	private UserCreateCompleteDAO uccDAO = new UserCreateCompleteDAO();

	public String execute() throws SQLException{
		try{
			uccDAO.createUser(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString());
			result = SUCCESS;
			/*if(sameIdFlg.equals("1")){
				setSameUserMessage("同名ユーザーが存在します");
				result = ERROR;
			}*/
			}catch(Exception e){
				return result;
			}
		return result;
	}

	/*public String getsameIdFlg() {
		return sameIdFlg;
	}

	public void setsameIdFlg(String sameIdFlg) {
		this.sameIdFlg = sameIdFlg;
	}*/

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public String getSameUserMessage() {
		return sameUserMessage;
	}

	public void setSameUserMessage(String sameUserMessage) {
		this.sameUserMessage = sameUserMessage;
	}*/

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
