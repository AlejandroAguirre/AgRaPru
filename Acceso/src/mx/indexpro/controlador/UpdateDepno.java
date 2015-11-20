package mx.indexpro.controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.modelo.ConsultaDepno;
import mx.indexpro.modelo.ConsultaEmpleado;
import mx.indexpro.modelo.Depno;
import mx.indexpro.modelo.Empleado;


public class UpdateDepno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_USER = "/deptno.jsp"; 
	private ConsultaDepno con;

    public UpdateDepno() {
        super();
        con=new ConsultaDepno();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           	Depno de=new Depno();
        	String dname=request.getParameter("dname");
        	de.setDname(dname);
        	String loc=request.getParameter("loc");
        	de.setLoc(loc);
        	int deptno=Integer.parseInt(request.getParameter("deptno"));
        	de.setDeptno(deptno);
        	System.out.println(dname+"___"+ loc+"___"+deptno);
        	con.updateDeptno(de);
        	System.out.println(dname+"___"+ loc+"___"+deptno);
        	RequestDispatcher view = request.getRequestDispatcher("deptno.jsp");
        	view.forward(request, response);
        } finally {
            out.close();
        }
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	processRequest(request, response);
    }

}
