/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbConnection.DBConnection;
import pojo.JobPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class JobDao {
    
    
    //Methods For Admin
    
    public static ResultSet viewAllJob()throws SQLException // Admin
    {
        Statement st=DBConnection.getConnection().createStatement();
        return st.executeQuery("select * from jobs order by jobid"); 
    }
    
    //Methods For Hr
    
    public static ResultSet getAllJobByCompanyName(String cmpName)throws SQLException //Admin & Hr
    {
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select jobid,jobtitle,tags,status from jobs where hrid=(select hr.hrid from hr where companyname=?) order by jobid");
            ps.setString(1,cmpName);
            return ps.executeQuery();       
    }
    
    public static boolean addNewJob(JobPojo job)throws SQLException // For Hr
    {
        
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("insert into jobs values(?,?,?,?,?)");
            ps.setString(1,job.getJobId());
            ps.setString(2,job.getJobTitle());
            ps.setString(3,job.getHrId());
            ps.setString(4,job.getTags());
            ps.setInt(5,job.getStatus());
            return 1==ps.executeUpdate();
    }
    
    public static void setJobStatus(String jobId)throws SQLException // For Hr
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update jobs set status=1 where jobId=?");
        ps.setString(1,jobId);
        ps.executeUpdate();
    }

    public static int getJobId() throws SQLException // For Hr
    {   
        int count;
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select max(jobid) from jobs");
        if(rs.next())
        {
            if(rs.getString(1)==null)
                return 101;
            
            return Integer.parseInt(rs.getString(1).substring(4))+1;
        }
        return -1;
    }
    
    public static ResultSet getAllJobByHrId(String cmpName)throws SQLException // For Hr
    {
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select jobid,jobtitle,tags,status from jobs where hrid=(select hr.hrid from hr where companyname=?) order by jobid");
            ps.setString(1,cmpName);
            return ps.executeQuery();       
    }
    
    
    
    public static ResultSet getAllOpenJobByCompanyName(String cmpName)throws SQLException //Hr
    {
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select jobid,jobtitle,tags,status from jobs where hrid=(select hr.hrid from hr where companyname=?) and status=1 order by jobid");
            ps.setString(1,cmpName);
            return ps.executeQuery();
            
    }
    
    public static ResultSet getAllPendingJobByCompanyName(String cmpName)throws SQLException //Hr
    {
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select jobid,jobtitle,tags,status from jobs where hrid=(select hr.hrid from hr where companyname=?) and status=0 order by jobid");
            ps.setString(1,cmpName);
            return ps.executeQuery();
            
    }
    
    public static boolean removeJobByJobId(String jobId) throws SQLException // Hr
    {   
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update jobs set status=-1 where jobId=?");
        ps.setString(1,jobId);
        return 1==ps.executeUpdate();
    }
    
    public static boolean editJob(JobPojo job)throws SQLException // Hr
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("update jobs set jobtitle=?,tags=? where jobid=?");
        ps.setString(1,job.getJobTitle());
        ps.setString(2,job.getTags());
        ps.setString(3,job.getJobId());
        return 1==ps.executeUpdate();
    }
    
    //Methods For PT
    
    public static ResultSet getJobDetailsByJobId(String jobId)throws SQLException // Hr & Pt
    {
            PreparedStatement ps;
            ps=DBConnection.getConnection().prepareStatement("select jobid,jobtitle,hr.companyname,tags,status from jobs,hr where jobid=? and hr.hrid=jobs.hrid");
            ps.setString(1,jobId);
            return ps.executeQuery();
            
    }
    
    public static ResultSet getAllOpenJob()throws SQLException // Pt
    {
        Statement st=DBConnection.getConnection().createStatement();
        return st.executeQuery("select jobid,jobtitle,hr.companyname,tags from jobs,hr where status=1 order by jobid "); 
    }
    
    public static ResultSet getAllOpenJobUsingTags(String tag)throws SQLException //Pt And Not used
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select * from jobs where status=1 and tags='?%' order by jobid");
        ps.setString(1,tag);
        return ps.executeQuery(); 
    }
}

