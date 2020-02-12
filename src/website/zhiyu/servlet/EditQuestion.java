package website.zhiyu.servlet;

import bean.Question;
import dao.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/edit"})
public class EditQuestion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        new QuestionDAO().delete(id);
                        
        //Ž»
        Question q = new Question();
        q.id = id;
        q.question = request.getParameter("question");
        q.answer1 = request.getParameter("answer1");
        q.answer2 = request.getParameter("answer2");
        q.answer3 = request.getParameter("answer3");
        q.answer4 = request.getParameter("answer4");
        q.answer5 = request.getParameter("answer5");
        q.answer6 = request.getParameter("answer6");
        q.answer7 = request.getParameter("answer7");
        new QuestionDAO().addById(q);
        
        response.sendRedirect("editor");
    }     
}
