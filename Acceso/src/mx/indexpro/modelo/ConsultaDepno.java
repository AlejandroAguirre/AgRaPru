package mx.indexpro.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.indexpro.dao.Conecta;

public class ConsultaDepno {

	private Connection connection;
	public ConsultaDepno(){
	connection =Conecta.getConnection();
	}
	public void addDepno(Depno demptno){
		try{
			PreparedStatement preparedStatement=connection.prepareStatement("insert into DEPT(DEPTNO,DNAME,LOC) values (?, ?, ?)");
			preparedStatement.setInt(1,demptno.getDeptno());
			preparedStatement.setString(2,demptno.getDname());
			preparedStatement.setString(3,demptno.getLoc());
			preparedStatement.executeUpdate();	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void deleteDempno(int deptno){
		String sql="delete from DEPT where DEPTNO=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptno);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateDeptno(Depno deptno){
		String sql="update DEPT set DNAME=?, LOC=? where DEPTNO=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,deptno.getDname());
			preparedStatement.setString(2,deptno.getLoc());
			preparedStatement.setInt(3,deptno.getDeptno());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static List<Depno> getAllDeptno(){
		List<Depno> array=new ArrayList<Depno>();
		try{
			Conecta cn=new Conecta();
			Connection conexion=null;
			PreparedStatement pr=null;
			ResultSet rs=null;
			String sql="select * from DEPT order by DEPTNO";
			conexion=cn.getConnection();
			pr = conexion.prepareStatement(sql);
			rs=pr.executeQuery();
			rs=pr.getResultSet();
			while(rs.next()){
				Depno de=new Depno();
				de.setDeptno(rs.getInt("DEPTNO"));
				de.setDname(rs.getString("DNAME"));
				de.setLoc(rs.getString("LOC"));
				array.add(de);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return array;
	}
	public Depno getDeptnoId(int deptno){
		Depno de=new Depno();
		String sql="select *from DEPT where DEPTNO=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,deptno);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()){
				de.setDeptno(rs.getInt("DEPTNO"));
				de.setDname(rs.getString("DNAME"));
				de.setLoc(rs.getString("LOC"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return de;
	}
}
