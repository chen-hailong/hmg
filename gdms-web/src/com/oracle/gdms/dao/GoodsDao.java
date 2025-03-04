package com.oracle.gdms.dao;

import java.util.List;
import java.util.Map;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.GoodsTypeEntity;


public interface GoodsDao {
	
	List<GoodsModel> findByPage(Map<String, Object> map);

	int findCount(Map<String, Object> map);

	GoodsModel findById(int goodsid);

	int add(GoodsEntity goods);

	void updatePush(int goodsid);

	List<GoodsModel> findByKeywords(String kw);

	void updateStatus(Map<String, Object> map);

	void update(GoodsEntity goods);

	List<GoodsTypeEntity> findAllType();

	List<GoodsModel> findByType(String gtid);

	List<GoodsModel> findByType(Integer gtid);

	void updateGtid(Map<String,Object> map);
	
}
