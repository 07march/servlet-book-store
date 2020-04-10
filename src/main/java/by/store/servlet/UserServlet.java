package by.store.servlet;

import by.store.entity.User;
import by.store.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 28.03.2020 Добавить вывод сообщений
// 28.03.2020 Добавить удаление пользователя
// 28.03.2020 перенести все SQL в файл
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("operation") != null) {
            String operation = req.getParameter("operation");
            switch (operation) {
                case "update":
                    String type = req.getParameter("type");
                    switch (type) {
                        case "info":
                            req.getRequestDispatcher("user/updateUserInfo.jsp").forward(req, resp);
                            break;
                        case "password":
                            req.getRequestDispatcher("user/updateUserPassword.jsp").forward(req, resp);
                            break;
                    }
                    break;
                case "delete":
                    req.getRequestDispatcher("user/deleteUserAccount.jsp").forward(req, resp);
                    break;
            }
        } else {
            req.getRequestDispatcher("user/user.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        switch (operation) {
            case "update":
                String type = req.getParameter("type");
                switch (type) {
                    case "info":
                        String name = req.getParameter("firstName");
                        String lastName = req.getParameter("lastName");
                        if (name != null) {
                            userService.updateFirstName(name, currentUser.getEmail());
                            req.setAttribute("message", "change successfull! New name: " + name);
                            req.getRequestDispatcher("user/updateUserInfo.jsp").forward(req, resp);
                            break;
                        }
                        if (lastName != null) {
                            userService.updateLastName(lastName, currentUser.getEmail());
                            req.setAttribute("message", "change successfull! New lastName: " + lastName);
                            req.getRequestDispatcher("user/updateUserInfo.jsp").forward(req, resp);
                            break;
                        }
                        break;
                    case "password":
                        String password = req.getParameter("password");
                        userService.updatePassword(password, currentUser.getEmail());
                        req.setAttribute("message", "change successfull! New password: " + password);
                        req.getRequestDispatcher("user/updateUserPassword.jsp").forward(req, resp);
                        break;
                }
                break;
            case "delete":
                String email = currentUser.getEmail();
                userService.delete(email);
                resp.sendRedirect("/logout");
                break;
        }
    }
}
