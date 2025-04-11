package com.example.demo.Repository;

import com.example.demo.Model.Product;
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
		List<User>list;
    @Autowired
    JdbcTemplate jdbcTemplate;

    
    public boolean isAddNewUser(User user) {
<<<<<<< Updated upstream
      int value = jdbcTemplate.update("insert into User(UserName, Password, RoleID) values(?, ?, ?)"
, new PreparedStatementSetter() {

=======
      int value = jdbcTemplate.update("insert into User values('0',?, ?, ?)", new PreparedStatementSetter() {
>>>>>>> Stashed changes
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getPassword());
                    ps.setInt(3, user.getRoleId());
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
                    u.setUserId(rs.getInt("UserID"));
                    u.setUserName(rs.getString("UserName"));
                    u.setPassword(rs.getString("Password"));
                    u.setRoleId(rs.getInt("RoleID"));
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
                    u.setUserId(rs.getInt("UserID"));
                    u.setUserName(rs.getString("UserName"));
                    u.setPassword(rs.getString("Password"));
                    u.setRoleId(rs.getInt("RoleID"));
                    return u;
                }
            }
        );
    }
    
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public User searchUserById(int id) {
      
        list = jdbcTemplate.query("select * from User where UserID = ?",new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, id); 
                }
            },
            new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
<<<<<<< Updated upstream
                    user.setUserId(rs.getInt("UserID"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassword(rs.getString("Password"));
                    user.setRoleId(rs.getInt("RoleID"));
=======
                    user.setUserID(rs.getInt("UserID"));
                    user.setUserName(rs.getString("UserName"));
                    user.setPassword(rs.getString("Password"));
                    user.setRoleID(rs.getInt("RoleID"));
>>>>>>> Stashed changes
                    return user;
                }
            }
        );

       
        if (list.size() > 0) {
            return list.get(0); 
        } else {
            return null;
        }
    }

    public User deletehUserById(int id) {

        list = jdbcTemplate.query( "select * from User where UserID = ?",
                  new PreparedStatementSetter() {
                      @Override
                      public void setValues(PreparedStatement ps) throws SQLException {
                          ps.setInt(1, id);
                      }
                  },
                  new RowMapper<User>() {
                      @Override
                      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                          User user = new User();
<<<<<<< Updated upstream
                          user.setUserId(rs.getInt("UserID"));
                          user.setUserName(rs.getString("UserName"));
                          user.setPassword(rs.getString("Password"));
                          user.setRoleId(rs.getInt("RoleID"));
=======
                          user.setUserID(rs.getInt("UserID"));
                          user.setUserName(rs.getString("UserName"));
                          user.setPassword(rs.getString("Password"));
                          user.setRoleID(rs.getInt("RoleID"));
>>>>>>> Stashed changes
                          return user;
                      }
                  }
              );

        if (list.size() > 0) {
            return list.get(0); 
        } else {
            return null;
        }
             
          }
    public User updateUserById(int id, User user) {
        int value =jdbcTemplate.update("update User set UserName = ?, Password = ?, RoleID = ? WHERE UserID = ?",
            new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getPassword());
<<<<<<< Updated upstream
                    ps.setInt(3, user.getRoleId());
                    ps.setInt(4, user.getUserId());
=======
                    ps.setInt(3, user.getRoleID());
                    ps.setInt(4, user.getUserID());
>>>>>>> Stashed changes
                }
            }
        );
		
     
        if (value > 0) {
<<<<<<< Updated upstream
            user.setUserId(id);  
=======
            user.setUserID(id);  
>>>>>>> Stashed changes
            return user;
        } else {
            return null;
        }


    } 
<<<<<<< Updated upstream

=======
    
>>>>>>> Stashed changes
}
