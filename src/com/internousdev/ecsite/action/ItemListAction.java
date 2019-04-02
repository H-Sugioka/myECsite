package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {

	private ItemListDAO dao = new ItemListDAO();
	private ArrayList<ItemListDTO> itemList = new ArrayList<ItemListDTO>();

	public String execute() throws SQLException{
		itemList =dao.getItemListInfo();

		String result = SUCCESS;
		return result;
	}

	public ArrayList<ItemListDTO> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemListDTO> itemList) {
		this.itemList = itemList;
	}

}
