package bhavin;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentAttendanceDao{
	
	public static int max_Student = 0;
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("org.hsqldb.jdbcDriver");  
            con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","sa","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
	}

public static List<Student> getAllStudent(String Cname) {
	

	

		List<Student> list = new ArrayList<Student>();
		
		try{
			Connection con = StudentAttendanceDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Student where Cname=?");
            ps.setString(1,Cname);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Student s = new Student();
				s.setUId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPassword(rs.getString(3));
				s.setCname(rs.getString(4));
				list.add(s);
		
			}
			con.close();	
		}catch(Exception ex){ex.printStackTrace();}
		
		return list;
	}

public static void InsertAttendance(Attendance a) {
	@SuppressWarnings("unused")
	int NullPointerChecker=0;
	try{
		
		Connection con=StudentAttendanceDao.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"insert into Attendance(Uid,Cname,date,Status) values (?,?,?,?)");
		ps.setInt(1, a.getUid());
		ps.setString(2,a.getCname());
		ps.setDate(3,a.getDate());
		ps.setString(4,a.getStatus());
		
		
		
	 NullPointerChecker=ps.executeUpdate();
		
		con.close();
		
	}catch(Exception e){e.printStackTrace();}

	
}
	
}
