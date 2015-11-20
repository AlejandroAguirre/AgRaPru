package mx.indexpro.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.indexpro.dao.Conecta;

public class ConsultaEmpleado {
	private Connection connection;
	public ConsultaEmpleado(){
	connection =Conecta.getConnection();
	}
	public void addEmpleado(Empleado empleado){
		//String sql="insert into EMP(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement("insert into EMP(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1,empleado.getEmpno());
			preparedStatement.setString(2,empleado.getEname());
			preparedStatement.setString(3,empleado.getJob());
			preparedStatement.setDouble(4,empleado.getMgr());
			preparedStatement.setDate(5,new java.sql.Date(empleado.getHiredate().getTime()));
			preparedStatement.setDouble(6,empleado.getSal());
			preparedStatement.setDouble(7,empleado.getComm());
			preparedStatement.setInt(8,empleado.getDeptno());
			preparedStatement.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void deleteEmpleado(int empno){
		String sql="delete from EMP where EMPNO=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, empno);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateEmpleado(Empleado empleado){
		//String sql="update EMP set  EMPNO=?, ENAME=?, JOB=?, MGR=?, HIREDATE=? ,SAL=?, COMM=?, DEPTNO=? where EMPNO=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement("update EMP set ENAME=?, JOB=?, MGR=?, HIREDATE=?, SAL=?, COMM=?, DEPTNO=? where EMPNO=?");
			preparedStatement.setString(1,empleado.getEname());
			preparedStatement.setString(2,empleado.getJob());
			preparedStatement.setDouble(3,empleado.getMgr());
			preparedStatement.setDate(4,new java.sql.Date(empleado.getHiredate().getTime()));
			preparedStatement.setDouble(5,empleado.getSal());
			preparedStatement.setDouble(6,empleado.getComm());
			preparedStatement.setInt(7,empleado.getDeptno());
			preparedStatement.setInt(8,empleado.getEmpno());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static List<Empleado> getAllEmp(){
		List<Empleado> emp=new ArrayList<Empleado>();
		try{
			Conecta cn=new Conecta();
			Connection conexion=null;
			PreparedStatement pr=null;
			ResultSet rs=null;
			String sql="select * from EMP order by EMPNO";
			conexion=cn.getConnection();
			pr = conexion.prepareStatement(sql);
			rs=pr.executeQuery();
			rs=pr.getResultSet();
			while(rs.next()){
				Empleado empl=new Empleado();
				empl.setEmpno(rs.getInt("EMPNO"));
				empl.setEname(rs.getString("ENAME"));
				empl.setJob(rs.getString("JOB"));
				empl.setMgr(rs.getDouble("MGR"));
				empl.setHiredate(rs.getDate("HIREDATE"));
				empl.setSal(rs.getDouble("SAL"));
				empl.setComm(rs.getDouble("COMM"));
				empl.setDeptno(rs.getInt("DEPTNO"));
				emp.add(empl);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return emp;
	}
	public Empleado getEmpleadoId(int empno){
		Empleado empl=new Empleado();
		//String sql="select *from EMP where EMPNO=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement("select * from EMP where EMPNO=?");
			preparedStatement.setInt(1,empno);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()){
				empl.setEmpno(rs.getInt("EMPNO"));
				empl.setEname(rs.getString("ENAME"));
				empl.setJob(rs.getString("JOB"));
				empl.setMgr(rs.getDouble("MGR"));
				empl.setHiredate(rs.getDate("HIREDATE"));
				empl.setSal(rs.getDouble("SAL"));
				empl.setComm(rs.getDouble("COMM"));
				empl.setDeptno(rs.getInt("DEPTNO"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return empl;
	}
	public static List<Depno> getDeptnoF(){
		List<Depno> emp=new ArrayList<Depno>();
		try{
			Conecta cn=new Conecta();
			Connection conexion=null;
			PreparedStatement pr=null;
			ResultSet rs=null;
			String sql="select DEPTNO from DEPT";
			conexion=cn.getConnection();
			pr = conexion.prepareStatement(sql);
			rs=pr.executeQuery();
			rs=pr.getResultSet();
			while(rs.next()){
				Depno empl=new Depno();
				empl.setDeptno(rs.getInt("DEPTNO"));
				emp.add(empl);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return emp;
	}
}
