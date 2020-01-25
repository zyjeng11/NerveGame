package website.zhiyu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import dao.QuestionDAO;
import java.util.List;

@WebServlet(urlPatterns = {"/QuestionServlet"})
public class QuestionServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int row = 1;
        //從上一題傳來的
        try {
            row = Integer.parseInt(request.getParameter("row"));
        } catch (NumberFormatException e) {}        
        
        //從 clear.jsp 來的
        int id = 0;
        try{
            id = Integer.parseInt(request.getParameter("id"));
            row = new QuestionDAO().getRowNum(id);
        }catch(NumberFormatException e){}
        
        int next = row + 1; 
        int tr = new QuestionDAO().getTotalRow();
        if (row < tr) {
            Question q = new QuestionDAO().getQuestionByRow(row);
            request.setAttribute("question", q);    
            request.setAttribute("next", next);
            request.getRequestDispatcher("question.jsp").forward(request, response);
        }else{
            List qs = new QuestionDAO().getList();
            request.setAttribute("questions", qs);
            request.getRequestDispatcher("clear.jsp").forward(request, response);
        }
    }

}
