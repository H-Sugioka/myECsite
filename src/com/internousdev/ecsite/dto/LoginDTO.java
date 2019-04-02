package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;
	private String loignPassword;
	private String userName;
	private boolean loginFlg=false;

	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoignPassword() {
		return loignPassword;
	}
	public void setLoignPassword(String loignPassword) {
		this.loignPassword = loignPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}
