package NetSocket;
import java.sql.*;  
public class UserInfo extends Thread{
	Connection conn;
	public void run() {
		connectToMysql();
	}
	
	public void registerSave(String username,String password) {
		try {
			PreparedStatement sql = conn.prepareStatement("insert into `userinfo`(`username`,`password`) values(?,?)"); 
			sql.setString(1, username);
			sql.setString(2, password);
			int rs = sql.executeUpdate();
			if(rs != 0) {
				System.out.println("insert success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean loginIfRight(String username,String password) {	
		boolean find = false;
		try{
			String sql = "select `username`,`password` from `userinfo`";
			Statement statement = conn.createStatement();  
			ResultSet rs = statement.executeQuery(sql); 
			String savedUsername;
			String savedPassword;
			while(rs.next())  {         
	               // 选择Name这列数据     
					savedUsername = rs.getString("username");
					savedPassword = rs.getString("password");
					if(username == savedUsername) {
						if(password == savedPassword) {
							find = true;
							break;
						}
					}
	                  // 输出结果                      
	            }  
	            rs.close();           
		} catch(Exception e) {
			e.printStackTrace();  
		}
		return find;
	}
	
    public void connectToMysql(){  
               // 驱动程序名        
        String driver = "com.mysql.jdbc.Driver";  
               // URL指向要访问的数据库名world        
        String url = "jdbc:mysql://128.199.221.196:3306/xiangqi?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
               // MySQL配置时的用户名           
        String user = "wiwry";           
        // MySQL配置时的密码          
        String password = "8328219a";  
        String username;  
        try {               
        	Class.forName(driver);               
            conn = DriverManager.getConnection(url, user, password);  
            if(!conn.isClosed()) {       
                System.out.println("Succeeded connecting to the Database!"); 
            }          
            Statement statement = conn.createStatement();  
            String sql = "select * from userinfo";     
            ResultSet rs = statement.executeQuery(sql);  
            while(rs.next())  {         
               // 选择Name这列数据     
                username = rs.getString("username");  
                  // 输出结果              
                System.out.println(username);           
            }  
            rs.close(); 
        } catch(ClassNotFoundException e) {  
         System.out.println("Sorry,can`t find the Driver!");              
         e.printStackTrace();  
        } catch(SQLException e) {  
         e.printStackTrace();  
        } catch(Exception e) {  
         e.printStackTrace();  
        }   
    }  
}  
