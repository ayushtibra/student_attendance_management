package bhavin;

import java.util.*;  
import java.sql.*;  

public class StudentDao {  
  
    public static Connection getConnection(){  
       Connection c = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver" );
           c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "sa", "");

        } catch (Exception ex) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            ex.printStackTrace();
        }

        return c;  
    }  
    public static int save(Student e){  
        int status=0,ID=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Student(UId,name,password,Cname) values (?,?,?,?)");
            ID=IdGenerator()+1;
            ps.setInt(1,ID);
            ps.setString(2,e.getName());
            ps.setString(3,e.getPassword());
            ps.setString(4,e.getCname());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int IdGenerator(){
    	int Id=-1;
    	try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select max(UID) from Student");
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){  
                Id=rs.getInt(1);
               
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
    	return Id;
    	
    }
    public static int update(Student e){  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Student set UId=?,name=?,password=?,Cname=? where UId=?");
            
            ps.setInt(1,e.getUId());
            ps.setString(2,e.getName());
            ps.setString(3,e.getPassword());
            ps.setString(4,e.getCname());
            ps.setInt(5,e.getUId());  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int UId){
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Student where UId=?");
            ps.setInt(1,UId);
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getStudentById(int UId){
        Student s=new Student();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Student where UId=?");
            ps.setInt(1,UId);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){  
                s.setUId(rs.getInt(1));
                s.setName(rs.getString(2));  
                s.setPassword(rs.getString(3));  
                s.setCname(rs.getString(4));
  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return s;  
    }  
    public static int check(String name,String password){
        Student s=new Student();  
        int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Student where name=? and password=? ");
            ps.setString(1,name);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            
           while(rs.next()){
        	  
                s.setUId(rs.getInt(1));
                s.setName(rs.getString(2));  
                s.setPassword(rs.getString(3));  
                s.setCname(rs.getString(4));
             //	System.out.println(s.getUId()+s.getName()+s.getPassword());
           }
                if(name.equals(s.getName()) && s.getPassword().equals(password)){
                	status=1;
                }
                else status=0;
             // System.out.println(status);
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    public static List<Student> getAllStudents(){
        List<Student> list=new ArrayList<Student>();  
          
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Student");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Student e=new Student();  
                e.setUId(rs.getInt(1));
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setCname(rs.getString(4));
 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
   
} 


