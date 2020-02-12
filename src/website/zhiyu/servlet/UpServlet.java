package website.zhiyu.servlet;

import dao.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/up"})
public class UpServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new QuestionDAO().rowUpward(id);
		response.sendRedirect("editor");
	}
}
