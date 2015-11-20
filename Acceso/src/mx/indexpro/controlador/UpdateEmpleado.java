package mx.indexpro.controlador;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.modelo.ConsultaEmpleado;
import mx.indexpro.modelo.Empleado;
/**
 * Servlet implementation class UpdateEmpleado
 */
public class UpdateEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static String EDIT = "/EditDeptno.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private ConsultaEmpleado con;
    public UpdateEmpleado() {
        super();
        con=new ConsultaEmpleado();
    }  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           	Empleado e=new Empleado();
        	String ename=request.getParameter("ename");
        	e.setEname(ename);
        	String job=request.getParameter("job");
        	e.setJob(job);
        	double mgr=Double.parseDouble(request.getParameter("mgr"));
        	e.setMgr(mgr);
        	String hiredate1=request.getParameter("hiredate");
        	try{
        		Date hiredate= new SimpleDateFormat("dd/MM/yyyy").parse(hiredate1);
        		e.setHiredate(hiredate);
        	}catch(ParseException excep){
        		excep.printStackTrace();
        	}
        	double sal=Double.parseDouble(request.getParameter("sal"));
        	e.setSal(sal);
        	double comm=Double.parseDouble(request.getParameter("comm"));
        	e.setComm(comm);
        	int depno=Integer.parseInt(request.getParameter("depno"));
        	e.setDeptno(depno);
        	int id=Integer.parseInt(request.getParameter("empno"));
        	e.setEmpno(id);
        	//out.println("<p>"+id+"</p>");
        	//out.println("<p>"+ename+"</p>");
        	//out.println("<p>"+job+"</p>");
        	//out.println("<p>"+mgr+"</p>");
        	//out.println("<p>"+hiredate1+"</p>");
        	//out.println("<p>"+sal+"</p>");
        	//out.println("<p>"+comm+"</p>");
        	//out.println("<p>"+depno+"</p>");
        	con.updateEmpleado(e);
        	//System.out.println(empno+"___"+ ename+"___"+job+"___"+hiredate+"___"+sal+"____"+comm+"____"+depno);
        	RequestDispatcher view = request.getRequestDispatcher("empleado.jsp");
        	//request.setAttribute("users", ConsultaEmpleado.getAllEmp());
        	view.forward(request, response);
           //System.out.println("kpi2 clienteid:"+customer+" idgrupo"+group+" nombregrupo"+nameGroup+" desde"+dateFrom+":"+dateTo);
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
