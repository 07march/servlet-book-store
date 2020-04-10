package by.store.servlet;

import by.store.entity.Role;
import by.store.entity.User;
import by.store.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegUserServlet", urlPatterns = "/reg")
public class RegUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String id = req.getParameter("id");
        userService.add(new User(Integer.parseInt(id), firstName, lastName, email, password, Role.USER));
        req.setAttribute("message", "registration completed successfully!");
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }
}
