/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbConnection.DBConnection;
import pojo.CurrentUser;
import pojo.UserPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Neel_Esh
 */
public class UserDao {
    public static boolean validateUser(UserPojo user)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from users where userid=? and password=? and type=? and active='Y'");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getType());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            CurrentUser.setUserId(rs.getString(1));
            CurrentUser.setId(rs.getString(2));
            CurrentUser.setName(rs.getString(3));
            CurrentUser.setType(rs.getString(5));
            return true;
        }
        return false;
    }
    
    public static boolean checkOldPwd(String UserId,String pwd)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from users where userid=?");
        ps.setString(1,UserId);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {   
            return pwd.equalsIgnoreCase(rs.getString(4)); 
        }
        return false;
    }
    
    public static boolean updatePwd(String UserId,String pwd)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=?, active='Y' where userid=?");
        ps.setString(1,pwd);
        ps.setString(2,UserId);
        return 1==ps.executeUpdate();
    }
    
    public static UserPojo getDetailsByUserId(String userId)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from users where userid=? and type=?");
        ps.setString(1,userId);
        ps.setString(2,"Hr");
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {   
            UserPojo user=new UserPojo();
            user.setUserId(rs.getString(1));
            user.setId(rs.getString(2));
            user.setName(rs.getString(3));
            return user;
        }
        return null;
    }
}
