package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private MyPageDAO dao = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();	//購入履歴をソートする必要があるためListに入れる
	private String deleteFlg;
	private String message;
	//private String buyFlg;
	private String result;

	public String execute() throws SQLException{
		if(deleteFlg == null){
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

			myPageList=dao.getMyPageUserInfo(item_transaction_id, user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		/*if(buyFlg == null || buyFlg.equals("0")){			//購入履歴が存在しないとき
			result = ERROR;
		}else{
			result = SUCCESS;
		}*/
		result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException{
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = dao.buyItemHistoryDelete(item_transaction_id, user_master_id);
		//buyFlg="0";

		if(res>0){
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList() {
		return myPageList;
	}

	public void setMyPageList(ArrayList<MyPageDTO> myPageList) {
		this.myPageList = myPageList;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*public String getBuyFlg() {
		return buyFlg;
	}

	public void setBuyFlg(String buyFlg) {
		this.buyFlg = buyFlg;
	}*/
}

