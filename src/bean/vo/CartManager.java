package bean.vo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.StyledEditorKit.BoldAction;

import bean.dao.GoodsDao;

public class CartManager {
	private ArrayList<Item> items =new ArrayList<Item>();

	public void addToCart(String goodsId, int count) {
		boolean foundFlag = false;
		if(items!=null){
			Iterator<Item> it = items.iterator();
			while (it.hasNext()) {
				Item oneItem = it.next();
				if(oneItem.getGoods().getGoodsId().equals(goodsId)){
					oneItem.setCount(oneItem.getCount()+count);
					foundFlag =true;
				}
			}
			if(foundFlag==false){
				Item newItem = new Item();
				newItem.setCount(count);
				GoodsDao dao =new GoodsDao();
				GoodsVo newG = dao.getGoodsVoById(goodsId);
				newItem.setGoods(newG);
				items.add(newItem);
			}
		}
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
