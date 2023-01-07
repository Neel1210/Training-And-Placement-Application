/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbConnection.DBConnection;
import pojo.ResultPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Neel_Esh
 */
public class ResultsDao {
    public static boolean applyForJob(ResultPojo rs)throws SQLException {
        
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select * from results where participantid=? and jobid=?");
        ps.setString(1,rs.getParticipantId());
        ps.setString(2,rs.getJobId());
        ResultSet rs1=ps.executeQuery();
        if(rs1.next())
        {
            return false;
        }
        else
        {
            ps=DBConnection.getConnection().prepareStatement("insert into results values(?,?,?,'No')");
            ps.setString(1,rs.getParticipantId());
            ps.setString(2,rs.getJobId());
            ps.setDouble(3,rs.getStatus());
            return 1==ps.executeUpdate();
        }  
    }
    
    public static ResultSet getAllAppliedJob(ResultPojo rs)throws SQLException {
        
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select jobid from results where participantid=? and percentage=-1 order by jobid");
        ps.setString(1,rs.getParticipantId());
        ps.setDouble(2,rs.getStatus());
        return ps.executeQuery();
    }
    
    public static ResultSet getAllCompletedJob(ResultPojo rs)throws SQLException {
        
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select jobid from results where participantid=? and percentage>1 order by jobid");
        ps.setString(1,rs.getParticipantId());
        ps.setDouble(2,rs.getStatus());
        return ps.executeQuery();
    }
    
    public static ResultSet getAllParticipantIdByCompanyName(String cmpName)throws SQLException // Hr
    {
        
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select DISTINCT participantid from results where (select companyName from hr where) companyname=? order by participantid");
        ps.setString(1,cmpName);
        return ps.executeQuery();
    }
    
    public static ResultSet getAllQualifiedParticipantIdByCompanyName(String cmpName,int per,String jobId)throws SQLException // Admin & Hr
    { 
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select DISTINCT participantid from results where companyname=? and jobid=? and percentage>? order by participantid");
        ps.setString(1,cmpName);
        ps.setString(2,jobId);
        ps.setInt(3,per);
        return ps.executeQuery();
    }
    
    public static boolean setStatus(ResultPojo rs)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update results set percentage=? where participantid=? and jobid=?");
        ps.setDouble(1,rs.getStatus());
        ps.setString(2,rs.getParticipantId());
        ps.setString(3,rs.getJobId());
        return 1==ps.executeUpdate();
    }
    
    public static int getPercent(String pId,String jobId)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("Select percentage from results where participantid=? and jobid=?");
        ps.setString(1,pId);
        ps.setString(2,jobId);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            return rs.getInt(1);
        return 0;
    }
    
    public static boolean setSelectedByHr(String pId,String jobId)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update results set selectedbyhr='Yes' where participantid=? and jobid=?");
        ps.setString(1,pId);
        ps.setString(2,jobId);
        return 1==ps.executeUpdate();
    }
}
