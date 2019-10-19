package br.inatel.dm110.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val1 = req.getParameter("val1");
		String val2 = req.getParameter("val2");
		String operation = req.getParameter("operation");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		if(operation.equals("sum")) out.println(Float.valueOf(val1) + Float.valueOf(val2)); 
		else if(operation.equals("sub")) out.println(Float.valueOf(val1) - Float.valueOf(val2)); 
		else if(operation.equals("mul")) out.println(Float.valueOf(val1) * Float.valueOf(val2)); 
		else if(operation.equals("div")) out.println(Float.valueOf(val1) / Float.valueOf(val2)); 
		else out.println("Unsupported Operation. Try: sum, sub, mul, div");
	}

}
