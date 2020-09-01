package com.oracle.gdms.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.GoodsType;
import com.oracle.gdms.entity.ResponseEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;



@Path("/hongyan")
public class HongYan {
	@Path("/sing")
	@GET
   public String sing() {
	   System.out.print("唱歌好听");
	   return "hello";
   }
	
	
	@Path("/sing/ci")   //  rest/hongyan/sing/ci?name=XXX
	public String sing(@QueryParam("name") String name) {
		System.out.println("歌词="+name);
		return "CI";
	}
	
	
	@Path("/push/one")
	@POST
	public String push(@FormParam("name") String name, @FormParam("sex") String sex) {
		System.out.println("商品名称="+name);
		return "form";
	}
	
	@Path("/push/json")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String pushJson(String jsonparam) {
		System.out.println(jsonparam);
		JSONObject j = JSONObject.parseObject(jsonparam);
		String name = j.getString("name");
		String sex = j.getString("sex");
		String age = j.getString("age");
		System.out.println("name=" + name);
		System.out.println("sex=" + sex);
		System.out.println("age=" + age);
		return "json";
	}
	
	@Path("/goods/update/type")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	// 规定返回的结果为json对象
	public String updateGoodsType(String jsonparam) {
		System.out.println("str=" + jsonparam);
		JSONObject j = JSONObject.parseObject(jsonparam);
		String goodsid = j.getString("goodsid");
		String gtid = j.getString("gtid");
		System.out.println("要修改的商品id=" + goodsid + "   目标类别id=" + gtid);
		GoodsEntity goods = new GoodsEntity();
		
		//goods.setGoodsid = new GoodsEntity();
		//goods.
		GoodsService service = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
		//int count =service.updateType(goods);
		
		return j.toJSONString();
	}
	
	
	@Path("/goods/push/bytype")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public List<GoodsModel>findByType(GoodsType type){
		List <GoodsModel>list =null;
		
		GoodsService s = (GoodsService) Factory.getInstance().getObject("goods.service.impl");
			list = s.findByType(type.getGtid());
			System.out.print("size="+list.size());
		return list;
	}
	@Path("/goods/push/one")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public ResponseEntity pushGoodsOne(String jsonparam) {
	//SONObject j = JSONObject.parseObject(jsonparam);
	//System.out.println("sssss===" + jsonparam);
	//String gs =j.getString("goodsid");
	//GoodsModel goods = JSONObject.parseObject(gs,GoodsModel.class);
		ResponseEntity r = new ResponseEntity();
		//访问：http://localhost:8080/gdms-web/rest/hongyan/goods/push/one
		try {
			JSONObject j = JSONObject.parseObject(jsonparam);
			String gs =j.getString("goods");
			GoodsModel goods = JSONObject.parseObject(gs,GoodsModel.class);
			System.out.print("服务器收到：");
			System.out.print("商品ID："+goods.getGoodsid());
			System.out.print("商品名字："+goods.getName());
			r.setCode(0);
			r.setMessage("推送成功 --chen");
		}catch(Exception e) {
			e.printStackTrace();
			r.setCode(11256);
			r.setMessage("推送失败"+jsonparam);
		}
		return r;

	}
}
