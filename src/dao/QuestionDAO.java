package dao;

import bean.Question;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.MysqlDataSource;

//some JDBC method
public class QuestionDAO {
	
	public static void main(String[] args) throws Exception{
		new QuestionDAO().getList();
	}
	
    public Connection getConnection() throws SQLException{
    	
    	Properties prop = new Properties();
    	FileInputStream fis = null;
    	MysqlDataSource ds = null;
    	Connection con = null;    
    	
    	try {
    		fis = new FileInputStream("D:\\javacode\\NerveGame\\db.properties");
    		prop.load(fis);
    		ds = new MysqlDataSource();
    		ds.setUrl(prop.getProperty("DB.URL"));
    		ds.setUser(prop.getProperty("DB.USERNAME"));
    		ds.setPassword(prop.getProperty("DB.PASSWORD"));
    		
    		con = ds.getConnection();    		
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}finally {
    		try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	return con;
    }

    //get table
    public List getList() {
        List<Question> questions = new ArrayList<>();
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "SELECT * FROM question ORDER BY id";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
    
    //get question(id)
    public Question getQuestionById(int id){
        Question q = null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "SELECT * FROM question WHERE id="+id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }

    //get question(row)
    public Question getQuestionByRow(int num) {
        Question q = null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "SELECT * FROM question LIMIT " + (num-1) + ", 1";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return q;
    }

    //how many row in the table
    public int getTotalRow() {
        int r = 0;
        try (Connection c = getConnection();
                Statement s = c.createStatement();) {
            String sql = "SELECT COUNT(id) FROM question";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                r = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    //
    public int getRowNum(int id) {
        int r = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            //
            String sql = "SELECT COUNT(*) FROM question WHERE id=" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                r = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    //delete
    public void delete(int id) {
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "DELETE FROM question WHERE id=" + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //add row by id
    public void addById(Question q) {
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "INSERT INTO question VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, q.id);
            ps.setString(2, q.question);
            ps.setString(3, q.answer1);
            ps.setString(4, q.answer2);
            ps.setString(5, q.answer3);
            ps.setString(6, q.answer4);
            ps.setString(7, q.answer5);
            ps.setString(8, q.answer6);
            ps.setString(9, q.answer7);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //把順序往前
    public void rowUpward(int id) {
    	try(Connection c = getConnection();  Statement s = c.createStatement()){
    		String sql = "SET SQL_SAFE_UPDATES=0;" +     				
    				"UPDATE question " + 
    				"SET id = 0 WHERE id = ?;" + 
    				"UPDATE question " + 
    				"SET id = id+1 WHERE id = ?;" + 
    				"UPDATE question " + 
    				"SET id = ? WHERE id = 0;";
    		PreparedStatement ps = c.prepareStatement(sql);
    		ps.setInt(1, id);
    		ps.setInt(2, id-1);
    		ps.setInt(3, id-1);
    		
    		ps.execute();
    		ps.close();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
