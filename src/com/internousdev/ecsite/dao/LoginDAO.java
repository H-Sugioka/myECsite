package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private LoginDTO lgDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		String sql ="SELECT * FROM login_user_transaction "
				+ "where login_id=? "
				+ "AND login_pass=?";
				//login_user_transactionにIDとパスワードを与えたときの結果を取り出す
		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				lgDTO.setLoginId(rs.getString("login_id"));
				lgDTO.setLoignPassword(rs.getString("login_pass"));
				lgDTO.setUserName(rs.getString("user_name"));
				//取り出した結果からlogin_id,login_pass,user_nameをDTO(ローカル変数)にセットする
				if(!(rs.getString("login_id").equals(null))){
					lgDTO.setLoginFlg(true);
					//取り出した結果が存在するときLoginFlgを立てる(trueにする。)
					//誤りが起きた時に1発で確認できる
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lgDTO;
	}
}
