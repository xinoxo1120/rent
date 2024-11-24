package com.cloudSerenityHotel.controller.xxx;

import java.io.IOException;

import com.cloudSerenityHotel.base.BaseController;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/xxx/*")
public class XxxController extends BaseController{

	private static final long serialVersionUID = 1L;
	


	
	protected void getXxx(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().write("xxx");
	}

	protected void getYyy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("yyy");
	}
}
