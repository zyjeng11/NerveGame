package website.zhiyu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.QuestionDAO;
import bean.Question;

@WebServlet(urlPatterns = {"/add"})
public class AddQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //取得最後一行的id
        int row = new QuestionDAO().getTotalRow(); 
        Question lastQ = new QuestionDAO().getQuestionByRow(row);        
        int lastId = lastQ.id;
        
        //要加入的題目
        Question q = new Question();
        q.id = lastId + 1;
        q.question = (String)request.getParameter("question");
        q.answer1 = (String)request.getParameter("answer1");
        q.answer2 = (String)request.getParameter("answer2");
        q.answer3 = (String)request.getParameter("answer3");
        q.answer4 = (String)request.getParameter("answer4");
        q.answer5 = (String)request.getParameter("answer5");
        q.answer6 = (String)request.getParameter("answer6");
        q.answer7 = (String)request.getParameter("answer7");
        new QuestionDAO().addById(q);
        
        response.sendRedirect("editer");
    }   

}
