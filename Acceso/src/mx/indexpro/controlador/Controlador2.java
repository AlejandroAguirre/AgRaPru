package mx.indexpro.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.modelo.ConsultaDepno;
import mx.indexpro.modelo.Depno;
import mx.indexpro.modelo.Empleado;

public class Controlador2 extends HttpServlet {
	private static String INSERT_OR_EDIT = "/index.jsp";
	private static String LIST_USER = "/deptno.jsp";
	private static String EDIT="/editdepno.jsp";
	private static final long serialVersionUID = 1L;
	private ConsultaDepno con;

    public Controlador2() {
        super();
        con=new ConsultaDepno();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward;
        String action = (String)request.getParameter("action");
        System.out.println("Ingreso "+action);
        if (action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            con.deleteDempno(id);;
            forward = LIST_USER;
            request.setAttribute("users", con.getAllDeptno());    
        } else if (action.equalsIgnoreCase("edit")){
        	 forward=EDIT;
        	 int depId = Integer.parseInt(request.getParameter("id"));
             System.out.println("Quiere editar "+depId);
             Depno dep=con.getDeptnoId(depId);
             request.setAttribute("dep",dep);
        } else if (action.equals("insert")){
            forward = INSERT_OR_EDIT;
          //  request.setAttribute("users", con.getAllUsers());
        }else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Depno e=new Depno();
    	int deptno=Integer.parseInt(request.getParameter("deptno"));
    	String dname=request.getParameter("dname");
    	String loc=request.getParameter("loc");
    	System.out.println(" "+deptno+" "+dname+" "+loc);
    	e.setDeptno(deptno);
    	e.setDname(dname);
    	e.setLoc(loc);
    	con.addDepno(e);
    	RequestDispatcher view = request.getRequestDispatcher("index.jsp");
    	//request.setAttribute("users", ConsultaEmpleado.getAllEmp());
    	view.forward(request, response);
	}

}
