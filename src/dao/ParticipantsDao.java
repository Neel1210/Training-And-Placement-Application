/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbConnection.DBConnection;
import pojo.CurrentUser;
import pojo.LoginPojo;
import pojo.ParticipantsPojo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class ParticipantsDao {
    public static boolean addNewParticipants(ParticipantsPojo pt)
    {
        try
        {   
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select * from users where userid=?");
            ps.setString(1,pt.getUserId().toUpperCase().trim());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already have an account on this phone no or mail","Error",JOptionPane.ERROR_MESSAGE);
                return false;   
            }
            else
            {
                ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,'Pt','Y')");
                ps.setString(1,pt.getUserId());
                ps.setString(2,pt.getpId());
                ps.setString(3,pt.getName());
                ps.setString(4,pt.getPassword());
                
                if(1==ps.executeUpdate())
                {
                    ps=DBConnection.getConnection().prepareStatement("insert into participants values(?,?,?,?,?)");
                    ps.setString(1,pt.getpId()); 
                    ps.setString(2,pt.getPhone());
                    ps.setString(3,pt.getSkills());
                    ps.setString(4,pt.getQualifications());
                    
                    FileInputStream resume = new FileInputStream(pt.getResume().getPath());
                    ps.setBlob(5,resume);

                    return 1==ps.executeUpdate();
                }
                else
                {
                    //Undo - roll back code
                } 
            }
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"DB-Error While Adding New Participants","Error",JOptionPane.ERROR);
        }
        catch(FileNotFoundException fnf)
        {
            fnf.printStackTrace();
            JOptionPane.showMessageDialog(null,"DB-Error While Adding New Participants","Error",JOptionPane.ERROR);
        }
        return false;
    }
    
    public static ResultSet getParticipantsProfile(String pid) throws SQLException
    {   
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select * from participants where pid=?");
        ps.setString(1,pid);
        return ps.executeQuery();
    }
    
    public static Blob getParticipantsResume(String pid) throws SQLException
    {   
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select resume from participants where pid=?");
        ps.setString(1,pid);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return rs.getBlob(1);
        else 
            return null;
    }
    
    public static boolean updateCv(String userId,File file)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update participants set resume=? where userid=?");
        
        try
        {
            FileInputStream resume = new FileInputStream(file.getPath());
            ps.setBlob(1,resume);
        }
        catch(FileNotFoundException fnf)
        {
            fnf.printStackTrace();
            JOptionPane.showMessageDialog(null,"DB-Error While uploading cv","Error",JOptionPane.ERROR);
        }
        
        ps.setString(2,userId);
        return 1==ps.executeUpdate();   
    }
    
    public static int getParticipantsId() throws SQLException
    {   
        int count;
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select count(*) from participants");
        if(rs.next())
        {
            System.out.println("total rows"+rs.getInt(1));
            
            return 101+rs.getInt(1);
        }
        return -1;
    }
    
    public static boolean validateParticipant(LoginPojo lp)throws SQLException        
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from participants where ((mail=?) or (phone=?)) and password=?");    
        ps.setString(1,lp.getEmail().trim().toUpperCase());
        ps.setLong(2,lp.getPhone());
        ps.setString(3,lp.getPassword().trim());
        ResultSet rs =ps.executeQuery();
        if(rs.next())
        {
            CurrentUser.setId(rs.getString(1));
            CurrentUser.setName(rs.getString(2));
            CurrentUser.setType("User");
            return true;
        }
        return false;
    }
    
    public static ResultSet viewAllParticipantsAdmin()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs =st.executeQuery("select pid,name,userid,skills,qualifications from participants order by pid");
        return rs;
    }
    
    public static ResultSet viewParticipantsById(String id)throws SQLException
    {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from participants where pid=?");    
       ps.setString(1,id);
       return ps.executeQuery();
    }
    
    public static ResultSet viewParticipantsById1(String id)throws SQLException
    {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("select pid,name,skills,qualifications from participants where pid=?");    
       ps.setString(1,id);
       return ps.executeQuery();
    }
    
    public static ResultSet viewAllSelectedParticipants()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs =st.executeQuery("select pid,name,userid,skills,qualifications from participants");
        return rs;
    }
    
    
    
}
