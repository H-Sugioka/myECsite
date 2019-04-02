package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	public ArrayList<ItemListDTO> getItemListInfo()throws SQLException{
		ArrayList<ItemListDTO> itemList = new ArrayList<ItemListDTO>();

		String sql="SELECT item_name,item_price,item_stock FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemListDTO dto = new ItemListDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));
				itemList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemList;
	}
}
