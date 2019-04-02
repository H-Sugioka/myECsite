package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO lgDAO = new LoginDAO();
	private LoginDTO lgDTO = new LoginDTO();
	private BuyItemDAO biDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;
		lgDTO = lgDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", lgDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){	//loginFlgが立っているとき処理する。
			result = SUCCESS;
			BuyItemDTO biDTO = biDAO.getBuyItemInfo();

			session.put("login_user_id",lgDTO.getLoginId());
			session.put("id",biDTO.getId());
			session.put("buyItem_name", biDTO.getItemName());
			session.put("buyItem_price", biDTO.getItemPrice());
		}
		return result;
	}

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

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
