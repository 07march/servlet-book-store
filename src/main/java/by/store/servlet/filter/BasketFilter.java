package by.store.servlet.filter;

import by.store.entity.Role;
import by.store.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BasketFilter", servletNames = "BasketServlet")
public class BasketFilter extends HttpFilter {
     public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
         User currentUser = (User) req.getSession().getAttribute("currentUser");
         if (currentUser.getRole().equals(Role.USER)){
             chain.doFilter(req, resp);
         } else resp.sendRedirect("/main");
     }
}
