package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.StockManager;
import com.example.demo.vo.MyStockVo;
import com.example.demo.vo.StockVo;
@Repository
public class StockDao {
	public List<StockVo> listAll(){
		return StockManager.listAll();
	}
	
	public int insert(MyStockVo my) {
		return StockManager.insert(my);
	}
	
	public int update(MyStockVo my) {
		return StockManager.update(my);
	}
	
	public int cntup(MyStockVo cnt) {
		return StockManager.cntup(cnt);
	}
	
	public List<MyStockVo> listMy(){
		return StockManager.listMy();
	}
	
	public int delete(MyStockVo my) {
		return StockManager.delete(my);
	}
	
}