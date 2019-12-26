
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.QuestionDAO;
import bean.Question;

@WebServlet(urlPatterns = {"/EditQuestion"})
public class EditQuestion extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Question q = new Question();        
        q.question = (String)request.getParameter("question");
        q.answer1 = (String)request.getParameter("answer1");
        q.answer2 = (String)request.getParameter("answer2");
        q.answer3 = (String)request.getParameter("answer3");
        q.answer4 = (String)request.getParameter("answer4");
        q.answer5 = (String)request.getParameter("answer5");
        q.answer6 = (String)request.getParameter("answer6");
        q.answer7 = (String)request.getParameter("answer7");
        new QuestionDAO().add(q);
        
        response.sendRedirect("EditerServlet");
    }   

}
