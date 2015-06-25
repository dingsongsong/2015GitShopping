package bean.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DBBean;
import bean.vo.GoodsVo;

public class GoodsDao {
	int numPerPage = 2;

	public ArrayList getGoodsByPage(int pageNo) {
		ArrayList goodsList = null;
		DBBean db = new DBBean();
		Connection conn = db.getConnection();
		ResultSet rs = null;
		try {
			rs = db.executeQuery("select * from goods limit " + (pageNo - 1)
					* 2 + "," + numPerPage, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs != null) {
			goodsList = new ArrayList();
			try {
				while (rs.next()) {
					GoodsVo g = new GoodsVo();
					g.setGoodsId(rs.getString("goodsId"));
					g.setGoodsName(rs.getString("goodsName"));
					g.setPrice(rs.getFloat("price"));
					goodsList.add(g);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goodsList;
	}
	public int getCount(){
		DBBean db = new DBBean();
		Connection conn = db.getConnection();
		ResultSet rs = null;
		int count =-1;
		try {
			rs.next();
			rs = db.executeQuery("select count(*) from goods", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs!=null){
			try {
				count = rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
		
	}
	public GoodsVo getGoodsVoById(String id) {
		DBBean db = new DBBean();
		Connection conn = db.getConnection();
		ResultSet rs = null;
		GoodsVo goodsVo = new GoodsVo();
		try {
			rs.next();	
			rs = db.executeQuery("select * from goods where goodsid ='"+id+"'",null);
			goodsVo.setGoodsId(rs.getString("goodsid"));
			goodsVo.setGoodsName(rs.getString("goodsname"));
			goodsVo.setPrice(rs.getFloat("price"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsVo;
	}
}
