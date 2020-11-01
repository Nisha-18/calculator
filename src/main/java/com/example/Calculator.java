
package com.example;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
          response.setContentType("text/html");
          PrintWriter out= response.getWriter();
        
    	  out.println("<html>");
    	  out.println("<body bgcolor=\"Aqua\">");
    	  out.println("<h1>Welcome to StarAgile Oct-2020 DevOps Batch with Prashant Beniwal 1-Nov-2020</h1>");
        
    	  int a1= Integer.parseInt(request.getParameter("n1"));
          int a2= Integer.parseInt(request.getParameter("n2"));
          
          if(request.getParameter("r1")!=null)
          {
            out.println("<h1>Addition</h1>"+ add(a1,a2));
          }
          if(request.getParameter("r2")!=null)
          {
            out.println("<h1>Subtraction</h1>"+ sub (a1, a2));
          }
          if(request.getParameter("r3")!=null)
          {
            out.println("<h1>Multiplication</h1>"+ mul (a1, a2));
          }
          if(request.getParameter("r4")!=null)
          {
             out.println("<h1>Division</h1>"+ div (a1, a2));
          }

        	out.println("</body>");
        	out.println("</html>");  
          }
        
          catch(Exception e)
          {
              System.out.println("In  exception");
          }
        }
        public int add(int a, int b) {
            return a + b ;
        }
        
	    public int sub(int a, int b) {
            return a - b;
        }
	    
    	public int mul(int a, int b) {
            return a * b ;
        }
    	
    	public int div(int a, int b) {
            return a / b ;
        }
}
