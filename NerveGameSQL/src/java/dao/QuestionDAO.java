package dao;

import bean.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class QuestionDAO {
    public QuestionDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nerve_game?charactorEncoding=utf-8", "root", "Shan1yaoo4");
    }
    //取得全部資料
    public List getList(){
        List<Question> questions = new ArrayList<>();
        try(Connection c = getConnection();  Statement s = c.createStatement();){
            String sql = "SELECT * FROM question";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Question q = new Question();
                q.id = rs.getInt("id");
                q.question = rs.getString("question");
                q.answer1 = rs.getString("answer1");
                q.answer2 = rs.getString("answer2");
                q.answer3 = rs.getString("answer3");
                q.answer4 = rs.getString("answer4");
                q.answer5 = rs.getString("answer5");
                q.answer6 = rs.getString("answer6");
                q.answer7 = rs.getString("answer7");
                questions.add(q);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return questions;
    }
    //取得資料(row)
    public Question get(int id){
        Question q = null;
        try(Connection c = getConnection();  Statement s = c.createStatement();){
            String sql = "SELECT * FROM question WHERE ID= "+ id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                q = new Question();
                q.id = rs.getInt("id");
                q.question = rs.getString("question");
                q.answer1 = rs.getString("answer1");
                q.answer2 = rs.getString("answer2");
                q.answer3 = rs.getString("answer3");
                q.answer4 = rs.getString("answer4");
                q.answer5 = rs.getString("answer5");
                q.answer6 = rs.getString("answer6");
                q.answer7 = rs.getString("answer7");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return q;
    }    
    //總共有幾行
    public int getTotalRow(){
        int r = 0;
        try(Connection c = getConnection();
                Statement s = c.createStatement();){
            String sql = "SELECT COUNT(id) FROM question";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                r = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return r;
    }
    //刪除
    public void delete(int id){        
        try(Connection c = getConnection(); Statement s = c.createStatement();){
            String sql = "DELETE FROM question WHERE id="+ id;
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //新增
    public void add(Question q){
        try(Connection c = getConnection();  Statement s = c.createStatement();){
            String sql = "INSERT INTO question VALUES(NULL,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, q.question);
            ps.setString(2, q.answer1);
            ps.setString(3, q.answer2);
            ps.setString(4, q.answer3);
            ps.setString(5, q.answer4);
            ps.setString(6, q.answer5);
            ps.setString(7, q.answer6);
            ps.setString(8, q.answer7);
            
            ps.execute();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
