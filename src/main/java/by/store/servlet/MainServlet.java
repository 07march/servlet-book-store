package by.store.servlet;
import by.store.entity.Role;
import by.store.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//  17.03.2020 Реализовать вывод инф сообщений пользователю
// 17.03.2020 Реализовать информацию о пользователе в сессии
@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null){
            req.setAttribute("message", " guest");
        } else {
            req.setAttribute("message", currentUser.getFirstName());
            if (currentUser.getRole().equals(Role.ADMIN)){
                req.setAttribute("flagAdmin", true);
            } else req.setAttribute("flagUser", true);
        }
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }
}
