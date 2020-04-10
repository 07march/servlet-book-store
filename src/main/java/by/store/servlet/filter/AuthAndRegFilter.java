package by.store.servlet.filter;

import by.store.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthAndRegFilter", servletNames = {"AuthUserServlet", "RegUserServlet"})
public class AuthAndRegFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null){
            chain.doFilter(req, res);
        } else res.sendRedirect("/main");
    }
}
