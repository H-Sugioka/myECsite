package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private BuyItemCompleteDAO bicDAO = new BuyItemCompleteDAO();
	//private String buyFlg;

	public String execute() throws SQLException{
		bicDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());
		//buyFlg="1";
		String result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/*public String getBuyFlg() {
		return buyFlg;
	}

	public void setBuyFlg(String buyFlg) {
		this.buyFlg = buyFlg;
	}*/
}
