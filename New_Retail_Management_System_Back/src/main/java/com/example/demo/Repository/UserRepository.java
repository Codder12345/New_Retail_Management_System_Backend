package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userRepo")
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    
    public boolean isAddNewUser(User user) {
<<<<<<< Updated upstream

      
      int value = jdbcTemplate.update("insert into user(UserName , Password, roleID) values(?, ?, ?)", new PreparedStatementSetter() {

=======
      int value = jdbcTemplate.update("insert into user(UserName , Password, roleID) values(?, ?, ?)", new PreparedStatementSetter() {
>>>>>>> Stashed changes
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getPassword());
                    ps.setInt(3, user.getRoleID());
                }
      
    });
      return value>0?true:false;
  	
    }

	


    public User loginUser(String username, String password) {
        List<User> users = jdbcTemplate.query("select * from  User where UserName = ? and Password = ?",new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, username);
                    ps.setString(2, password);
                }
            },
            new RowMapper<User>() { public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User u = new User();
                    u.setUserID(rs.getInt("UserID"));
                    u.setUserName(rs.getString("UserName"));
                    u.setPassword(rs.getString("Password"));
                    u.setRoleID(rs.getInt("RoleID"));
                    return u;
                }
            }
        );
        return users.size() >0 ?  users.get(0):null;
    }

   
    public List<User> getAllUsers() {
        return jdbcTemplate.query("select * from User", new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User u = new User();
                    u.setUserID(rs.getInt("UserID"));
                    u.setUserName(rs.getString("UserName"));
                    u.setPassword(rs.getString("Password"));
                    u.setRoleID(rs.getInt("RoleID"));
                    return u;
                }
            }
        );
    }
    
    
   
   


    
  
    	
    

}
