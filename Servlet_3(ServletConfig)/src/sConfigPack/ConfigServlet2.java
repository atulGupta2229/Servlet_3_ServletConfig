package sConfigPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ConfigServlet2 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ServletConfig cfg=getServletConfig();
		/*Using getInitParmeter() method*/
		out.println(cfg.getInitParameter("val2").toString()+"<br>");
		
		/*Using getInitParameterNames() method*/
		Enumeration<String> IPnames=cfg.getInitParameterNames();
		while(IPnames.hasMoreElements()) {
			String ipn=IPnames.nextElement().toString();
			out.println("Param Name:"+ipn+"<br>");
		}
		
		/*Using getServletName() method*/
		String sName=cfg.getServletName().toString();
		out.println("Servlet Name:"+sName+"<br>");
		
		/*Using getServletContex()*/
		ServletContext ctx=cfg.getServletContext();
		out.println(ctx.getInitParameter("Context").toString());
	}
}
