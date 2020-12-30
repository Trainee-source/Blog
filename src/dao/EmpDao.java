package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import datosImpl.Conexion;
import entidad.posts;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}

	public static List<posts> getRecords(int start,int total){
		Conexion cn;
		cn = new Conexion();
		cn.Open();
		List<posts> lista = new ArrayList<posts>();
		
		String query = "select * from posts WHERE PostPuntaje >= 5 AND PostEstado = 1 limit "+(start-1)+","+total;
		
		try{
			ResultSet rs = cn.query(query);
			
			while(rs.next()){
				posts e=new posts();
				
				e.setPostId(rs.getInt("PostId"));
				e.setPostTitulo(rs.getString("PostTitulos"));
				e.setPostIntroduccion(rs.getString("PostDescripcion"));
				
				lista.add(e);
			}
			cn.close();
		}catch(Exception e){System.out.println(e);}
		
		
		
		
		return lista;
	}
}
