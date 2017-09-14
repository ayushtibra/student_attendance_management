package bhavin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bhavin.StudentDao;


public class TeacherDao {
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("org.hsqldb.jdbcDriver");  
            con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","sa","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
	
	public static int IdGenerator(){
    	int Id=-1;
    	try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select max(Tid) from Teacher");
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){  
                Id=rs.getInt(1);
              }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
    	return Id;
    	
    }
	
	

	public static int save (Teacher t){
		int status = 0,ID=0;
		try{
			
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into Teacher(Tid,name,password,Cname) values (?,?,?,?)");
		//	System.out.println("hiii");
			ID=IdGenerator()+1;
			
			ps.setInt(1, ID);
			ps.setString(2, t.getName());
			ps.setString(3,t.getPassword());
			ps.setString(4,t.getCname());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e){e.printStackTrace();}
	
		return status;
	}





	public static int delete(int tid) {

		 int status=0;  
	        try{  
	            Connection con=TeacherDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from Teacher where Tid=?");  
	            ps.setInt(1, tid);
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	}





	public static Teacher getTeacherByTid(int tid) {
		Teacher t = new Teacher();
        
        try{  
            Connection con=TeacherDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Teacher where Tid=?");  
            ps.setInt(1,tid);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
               t.setTid(rs.getInt(1));
               t.setName(rs.getString(2));
               t.setPassword(rs.getString(3));
               t.setCname(rs.getString(4));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return t;  
	}





	public static int update(Teacher t) {
		int status = 0;
		try{
			
			Connection con=TeacherDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update Teacher set name=?,password=?,Cname =? where Tid=?");
			
			ps.setString(1, t.getName());
			ps.setString(2,t.getPassword());
			ps.setString(3,t.getCname());
			ps.setInt(4, t.getTid());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e){e.printStackTrace();}
	
		return status;
	}





	public static List<Teacher> getAllTeacher() {
		
		List<Teacher> list = new ArrayList<Teacher>();
		
		try{
			Connection con = TeacherDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Teacher");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Teacher t = new Teacher();
				t.setTid(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setPassword(rs.getString(3));
				t.setCname(rs.getString(4));
				
				list.add(t);
			}
			con.close();	
		}catch(Exception ex){ex.printStackTrace();}
		
		return list;
	}
	
	public static int check(String name,String password){
        Teacher s=new Teacher();  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Teacher where name=? and password=? ");
            ps.setString(1,name);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            
           while(rs.next()){
        	  
                s.setTid(rs.getInt(1));
                s.setName(rs.getString(2));  
                s.setPassword(rs.getString(3));  
                s.setCname(rs.getString(4));
            // 	System.out.println(s.getTid()+s.getName()+s.getPassword());
           }
                if(name.equals(s.getName()) && s.getPassword().equals(password)){
                	status=1;
                }
                else status=0;
          //    System.out.println(status);
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
}


