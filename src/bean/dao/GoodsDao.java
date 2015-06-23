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
}
