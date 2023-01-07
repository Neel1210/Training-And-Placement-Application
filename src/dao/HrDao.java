/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbConnection.DBConnection;
import pojo.CurrentUser;
import pojo.HrPojo;
import pojo.LoginPojo;
import pojo.UserPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class HrDao {
    public static boolean addNewHr(HrPojo hr) throws SQLException
    {
           
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select * from users where userid=?");
            ps.setString(1,hr.getUserId().toUpperCase().trim());
           
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already have a Hr account on this mail","Error",JOptionPane.ERROR_MESSAGE);
                return false;   
            }
            
                ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?,'Y')");
                ps.setString(1,hr.getUserId());
                ps.setString(2,hr.getHrId());
                ps.setString(3,hr.getName());
                ps.setString(4,hr.getPassword());
                ps.setString(5,hr.getType());
                
                if(1==ps.executeUpdate())
                {
                    ps=DBConnection.getConnection().prepareStatement("insert into hr values(?,?,?,?)");
                    ps.setString(1,hr.getHrId());
                    ps.setString(2,hr.getPhone());
                    ps.setString(3,hr.getCompanyName());
                    ps.setString(4,hr.getProfession());
                    
                    return 1==ps.executeUpdate();
                }
                return false;
            
            
        }
        
    
    public static int getHrId() throws SQLException
    {   
        int count;
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select max(hrid) from hr");
        if(rs.next())
        {
            if(rs.getString(1)==null)
                return 101;
            return Integer.parseInt(rs.getString(1).substring(3))+1;
        }
        return 101;
    }
    
   
    public static String getCompanyNameById(String hrid)throws SQLException {
        
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("select companyname from hr where hrid=?");    
       ps.setString(1,hrid);
       ResultSet rs =ps.executeQuery();
       if(rs.next())
       {
           System.out.println(rs.getString(1));
           return rs.getString(1);
       }
       return null;
    }
    
    public static ResultSet getAllCompanyName()throws SQLException {
        
       Statement st=DBConnection.getConnection().createStatement();
       return st.executeQuery("select companyname from hr order by companyname");
    }
    
    public static ResultSet viewAllHr() throws SQLException
    {   
        Statement st=DBConnection.getConnection().createStatement();
        return st.executeQuery("select hr.hrid , users.userid , users.name , hr.phone , hr.companyname , users.active from hr,users where hr.hrid=users.id  order by hr.hrid ");
    }
    
    public static ResultSet viewAllActiveHr() throws SQLException
    {   
        Statement st=DBConnection.getConnection().createStatement();
        return st.executeQuery("select hr.hrid , users.userid , users.name , hr.phone , hr.companyname from hr,users where hr.hrid=users.id and users.active='Y' order by hr.hrid ");
    }
    
    public static boolean removeHr(String userId)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update users set active='N' where userid=?");
        ps.setString(1,userId.toUpperCase().trim());
        return 1==ps.executeUpdate();
    }
    
    public static boolean modifyHr(UserPojo user)throws SQLException
    {
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("update users set password=?,active='Y' where userid=?");
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getUserId().trim());
            return 1==ps.executeUpdate();
    }
}


