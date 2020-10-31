package com.example;
import static org.junit.Assert.*;
import java.io.*;
import javax.servlet.http.*;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest extends Mockito{

    @Test
    public void testAdd() throws Exception {

        int k= new Calculator().add(10, 12);
        assertEquals("Problem with Add function:", 22, k);
        
    }
    
    @Test
    public void testAddServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    


        when(request.getParameter("n1")).thenReturn("8");
        when(request.getParameter("n2")).thenReturn("2");
        when(request.getParameter("r1")).thenReturn("r1");
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new Calculator().doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
        assertTrue("Expecting Addition but not found",stringWriter.toString().contains("Addition"));
    }
    
    //@Test
    public void testSubServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    


        when(request.getParameter("n1")).thenReturn("8");
        when(request.getParameter("n2")).thenReturn("2");
        when(request.getParameter("r2")).thenReturn("r2");
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new Calculator().doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
        assertTrue("Expecting Subtraction but not found",stringWriter.toString().contains("Subtraction"));
    }

    //@Test
    public void testMulServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    


        when(request.getParameter("n1")).thenReturn("8");
        when(request.getParameter("n2")).thenReturn("2");
        when(request.getParameter("r3")).thenReturn("r3");
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new Calculator().doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
        assertTrue("Expecting Multiplication but not found",stringWriter.toString().contains("Multiplication"));
    }
    
    //@Test
    public void testDivServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    


        when(request.getParameter("n1")).thenReturn("8");
        when(request.getParameter("n2")).thenReturn("2");
        when(request.getParameter("r4")).thenReturn("r4");
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new Calculator().doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
        assertTrue("Expecting Division but not found",stringWriter.toString().contains("Division"));
    }

    @Test
    public void testExcServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new Calculator().doGet(request, response);
        
        writer.flush(); // it may not have been flushed yet...
        System.out.print(stringWriter.toString());
    }


    
    //@Test
    public void testSub() throws Exception {

        int k= new Calculator().sub(8,7);
        assertEquals("Problem with Sub function:", 1, k);

    }
    
    //@Test
    public void testMul() throws Exception {

        int k= new Calculator().mul(8,6);
        assertEquals("Problem with Mul function:", 48, k);

    }

    @Test
    public void testDiv() throws Exception {

        int k= new Calculator().div(8,4);
        assertEquals("Problem with Mul function:", 2, k);

    }
}
