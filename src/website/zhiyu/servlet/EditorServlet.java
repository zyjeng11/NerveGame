package website.zhiyu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.QuestionDAO;
import bean.Question;
import java.util.*;

@WebServlet(urlPatterns = {"/editor"})
public class EditorServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        List<Question> questions = new QuestionDAO().getList();
        
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("teacher.jsp").forward(request, response);
    }
}
