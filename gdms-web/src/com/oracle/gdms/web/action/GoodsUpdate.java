package com.oracle.gdms.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;

/**
 * Servlet implementation class GoodsUpdate
 */
@WebServlet("/admin/goods/update.php")
public class GoodsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         //System.out.print("修改成功");
		request.setCharacterEncoding("UTF-8");
		String goodsid = request.getParameter("goodsid");
		String name = request.getParameter("name");
		String spec = request.getParameter("spec");
		String price = request.getParameter("price");
		String amount = request.getParameter("amount");
//		System.out.print("id="+goodsid);
//		System.out.print("name="+name);
//		System.out.print("spec="+spec);
//		System.out.print("price="+price);
//		System.out.print("amount="+amount);
		
		GoodsEntity goods=new GoodsEntity();
		goods.setGoodsid(Integer.parseInt(goodsid));
		goods.setSpec(spec);
		goods.setName(name);
		//先找到￥符号		
		int i =price.indexOf("￥");
		price =price.substring(i+1);//跳过￥符号，取后面的内容
		goods.setPrice(Float.parseFloat(price));
		goods.setAmount(Float.parseFloat(amount));
		
		GoodsService service =(GoodsService) Factory.getInstance().getObject("goods.service.impl");
		int count =service.update(goods);
		response.setContentType("application/json;charset=utf-8");
		JSONObject j =new JSONObject();
		if(count>0) {
			j.put("code", 0);
			j.put("msg", "更新成功");
		}else {
			j.put("code", 1005);
			j.put("msg", "更新商商品失败");
		}
		response.getWriter().print(j.toJSONString());
	}

}
