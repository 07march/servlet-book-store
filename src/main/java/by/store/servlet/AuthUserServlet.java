package by.store.servlet;

import by.store.entity.Basket;
import by.store.entity.Book;
import by.store.entity.User;
import by.store.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthUserServlet", urlPatterns = "/auth")
public class AuthUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User byEmail = userService.findByEmail(email);
        if (byEmail == null) {
            req.setAttribute("message", "User not found");
            req.getRequestDispatcher("auth.jsp").forward(req, resp);
            return;
        }
        if (!byEmail.getPassword().equals(password)) {
            req.setAttribute("message", "Password incorrect");
            req.getRequestDispatcher("auth.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("currentUser", byEmail);
            req.getSession().setAttribute("basket", new Basket(new Book[10]));
            resp.sendRedirect("/main");
        }
    }
}
