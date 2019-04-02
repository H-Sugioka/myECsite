package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public  ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{
		//ユーザーの購入履歴の取得と表示
		ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

		String sql ="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_info_transaction iit "
				+ "ON ubit.item_transaction_id = iit.id "
				+ "WHERE ubit.item_transaction_id=? "
				+ "AND ubit.user_master_id=? "
				+ "ORDER BY insert_date DESC";
				/*テーブルuser_buy_item_transaction(ubit)とitem_info_transaction(iit)を
				  item_transaction_idとidで左外部結合
				  入力値した商品IDとログインIDの場合の結果を降順で出す*/
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageList.add(dto);
				//複数の結果を入力することがあるのでwhileを使う。順番を保持するためlistに保管する。
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return myPageList;
	}

	public int buyItemHistoryDelete (String item_transaction_id,String user_master_id) throws SQLException{
	//ユーザーの購入履歴の削除
		String sql = "DELETE FROM user_buy_item_transaction "
				+ "WHERE item_transaction_id=? "
				+ "AND user_master_id=?";
				/*テーブルuser_item_transactionに
				入力値した商品IDとログインIDが存在したときに同テーブルを削除*/
		int result =0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}