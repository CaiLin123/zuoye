package zuoye;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet1",urlPatterns = "/l")
public class loginServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = UserDao.select(username);
            if (user != null && user.getPassword().equals(password)){
                System.out.println("登录成功");
                getServletContext().setAttribute("user",user);
                response.sendRedirect("http://localhost:8080");
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/登录.html");
                rd.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
