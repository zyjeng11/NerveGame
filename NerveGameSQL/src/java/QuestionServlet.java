
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import dao.QuestionDAO;

@WebServlet(urlPatterns = {"/QuestionServlet"})
public class QuestionServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int start = 1;
        int pass = 0;
        try {
            pass = Integer.parseInt(request.getParameter("pass"));
        } catch (NumberFormatException e) {
        }

        if ((start + pass) < 13) {
            Question q = new QuestionDAO().get(start + pass);
            response.getWriter().write(q.question);
            request.setAttribute("question", q);
            request.getRequestDispatcher("question1.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("clear.jsp").forward(request, response);
        }
    }

}
