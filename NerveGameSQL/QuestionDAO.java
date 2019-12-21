package dao;

import bean.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class QuestionDAO {
    public QuestionDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nerve_game?charactorEncoding=utf-8", "root", "password");
    }
    public Question get(int id){
        Question q = null;
        try(Connection c = getConnection();  Statement s = c.createStatement();){
            String sql = "select * from question where id = "+ id;
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
    public static void main(String[] args) {
        Question q = new QuestionDAO().get(1);
        System.out.println(q.question);
    }
}
