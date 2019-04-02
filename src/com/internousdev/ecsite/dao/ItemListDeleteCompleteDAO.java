package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public int itemListDelete (String item_name,int item_price) throws SQLException{
		//ユーザーの購入履歴の削除
		String sql="DELETE FROM item_info_transaction";
			int result =0;
			try{
				PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, item_name);
					ps.setInt(2, item_price);
					result = ps.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				con.close();
			}
			return result;
	}
}
