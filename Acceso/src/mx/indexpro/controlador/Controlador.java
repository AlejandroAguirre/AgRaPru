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

import mx.indexpro.modelo.ConsultaEmpleado;
import mx.indexpro.modelo.Empleado;

public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/index.jsp";
	private static String LIST_USER = "/empleado.jsp";
	private static String EDIT="/editempleado.jsp";
    private ConsultaEmpleado con;
    public Controlador() {
        super();
        con=new ConsultaEmpleado();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        	
        } finally {
            out.close();
        }
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String forward;
        String action = (String)request.getParameter("action");
        System.out.println(action);
        if (action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            con.deleteEmpleado(id);
            forward = LIST_USER;
            request.setAttribute("users", con.getAllEmp());    
        } else if (action.equalsIgnoreCase("edit")){
        	 forward=EDIT;
        	 int userId = Integer.parseInt(request.getParameter("id"));
             System.out.println(userId);
             Empleado emp=con.getEmpleadoId(userId);
             request.setAttribute("emp",emp);
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
    	Empleado e=new Empleado();
    	e.setEmpno(Integer.parseInt(request.getParameter("empno")));
    	e.setEname(request.getParameter("ename"));
    	e.setJob(request.getParameter("job"));
    	e.setMgr(Double.parseDouble(request.getParameter("mgr")));
    	try{
    		Date hiredate= new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("hiredate"));
    		e.setHiredate(hiredate);
    	}catch(ParseException excep){
    		excep.printStackTrace();
    	}
    	e.setSal(Double.parseDouble(request.getParameter("sal")));
    	e.setComm(Double.parseDouble(request.getParameter("comm")));
    	e.setDeptno(Integer.parseInt(request.getParameter("depno")));
    	con.addEmpleado(e);
    	//System.out.println(empno+"___"+ ename+"___"+job+"___"+hiredate+"___"+sal+"____"+comm+"____"+depno);
    	RequestDispatcher view = request.getRequestDispatcher("index.jsp");
    	request.setAttribute("users", ConsultaEmpleado.getAllEmp());
    	view.forward(request, response);
	}

}
