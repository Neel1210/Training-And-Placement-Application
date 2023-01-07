/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbConnection.DBConnection;
import pojo.QuestionPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neel_Esh
 */
public class QuestionsDao {
    public static boolean setPaper(List<QuestionPojo> question)throws SQLException
    {
        PreparedStatement ps;
        for(QuestionPojo que:question)
        {
            ps=DBConnection.getConnection().prepareStatement("insert into questions values(?,?,?,?,?,?,?,?)");
            ps.setString(1,que.getJobId());
            ps.setInt(2,que.getqNo());
            ps.setString(3,que.getQuestion());
            ps.setString(4,que.getOption1());
            ps.setString(5,que.getOption2());
            ps.setString(6,que.getOption3());
            ps.setString(7,que.getOption4());
            ps.setInt(8,que.getCorrectOption());
            ps.executeUpdate();
        }
        return true;     
    }
    
    public static boolean editPaper(List<QuestionPojo> question)throws SQLException
    {
        PreparedStatement ps;
        for(QuestionPojo que:question)
        {
            ps=DBConnection.getConnection().prepareStatement("update questions set question=?,option1=?,option2=?,option3=?,option4=?,correctoption=? where jobid=? and qno=?");
            
            ps.setString(1,que.getQuestion());
            ps.setString(2,que.getOption1());
            ps.setString(3,que.getOption2());
            ps.setString(4,que.getOption3());
            ps.setString(5,que.getOption4());
            ps.setInt(6,que.getCorrectOption());
            ps.setString(7,que.getJobId());
            ps.setInt(8,que.getqNo());
            ps.executeUpdate();
        }
        return true;     
    }
    public static List getPaper(String jobId)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select * from questions where jobid=?");
        ps.setString(1, jobId);
        ResultSet rs=ps.executeQuery(); 
        List<QuestionPojo> list = new ArrayList<QuestionPojo>();
        while(rs.next())
        {
            QuestionPojo que=new QuestionPojo();
            que.setJobId(rs.getString(1));
            que.setqNo(rs.getInt(2));
            que.setQuestion(rs.getString(3));
            que.setOption1(rs.getString(4));
            que.setOption2(rs.getString(5));
            que.setOption3(rs.getString(6));
            que.setOption4(rs.getString(7));
            que.setCorrectOption(rs.getInt(8));
            list.add(que);
        }   
        return list;
    }
    
    public static boolean removePaper(String jobId)throws SQLException
    {
        PreparedStatement ps;
        ps=DBConnection.getConnection().prepareStatement("select * from questions where jobid=?");
        ps.setString(1, jobId);
        ResultSet rs=ps.executeQuery(); 
        List<QuestionPojo> list = new ArrayList<QuestionPojo>();
        while(rs.next())
        {
            QuestionPojo que=new QuestionPojo();
            que.setJobId(rs.getString(1));
            que.setqNo(rs.getInt(2));
            que.setQuestion(rs.getString(3));
            que.setOption1(rs.getString(4));
            que.setOption2(rs.getString(5));
            que.setOption3(rs.getString(6));
            que.setOption4(rs.getString(7));
            que.setCorrectOption(rs.getInt(8));
            list.add(que);
        }   
        return false;
    }
    
}
