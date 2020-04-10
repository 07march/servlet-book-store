package by.store.servlet;

import by.store.entity.Author;
import by.store.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorServlet", urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {

    private AuthorService authorService;

    @Override
    public void init() {
        authorService = (AuthorService) getServletContext().getAttribute("authorService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("operation") != null) {
            String operation = req.getParameter("operation");
            switch (operation) {
                case "find":
                    String type = req.getParameter("type");
                    switch (type) {
                        case "all":
                            Author[] all = authorService.findAll();
                            req.setAttribute("authors", all);
                            if (!isEmpty()) {
                                req.getRequestDispatcher("author/findAllAuthors.jsp").forward(req, resp);
                            } else {
                                req.setAttribute("message", "oops, the library is empty!");
                                req.getRequestDispatcher("author/findAllAuthors.jsp").forward(req, resp);
                            }
                            break;
                        case "id":
                            String value = req.getParameter("value");
                            if (value == null) {
                                if (authorService.findAll().length != 0){
                                    req.setAttribute("all", authorService.findAll());
                                } else {
                                    req.setAttribute("message", "oops, the library is empty!");
                                }
                                req.getRequestDispatcher("author/findAuthorById.jsp").forward(req, resp);
                                break;
                            } else {
                                int id = Integer.parseInt(value);
                                Author byId = authorService.findById(id);
                                if (byId == null) {
                                    req.setAttribute("message", "author not found");
                                    req.getRequestDispatcher("author/findAuthorById.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "found author: " + byId.getName());
                                    req.getRequestDispatcher("author/findAuthorById.jsp").forward(req, resp);
                                }
                            }
                            break;
                        case "name":
                            String value1 = req.getParameter("value");
                            if (value1 == null) {
                                req.getRequestDispatcher("author/findAuthorByName.jsp").forward(req, resp);
                                break;
                            } else {
                                Author byName = authorService.findByName(value1);
                                if (byName == null) {
                                    req.setAttribute("message", "author not found");
                                    req.getRequestDispatcher("author/findAuthorByName.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "found author: " + byName.getName());
                                    req.getRequestDispatcher("author/findAuthorByName.jsp").forward(req, resp);
                                }
                            }
                            break;
                    }
                    break;
                case "delete":
                    String id = req.getParameter("id");
                    if (id == null) {
                        if (authorService.findAll().length != 0){
                            req.setAttribute("all", authorService.findAll());
                        } else {
                            req.setAttribute("message", "oops, the library is empty!");
                        }
                        req.getRequestDispatcher("author/deleteAuthorById.jsp").forward(req, resp);
                        break;
                    } else {
                        int i = Integer.parseInt(id);
                        Author byId = authorService.findById(i);
                        authorService.delete(i);
                        if (byId == null) {
                            req.setAttribute("message", "author not found");
                            req.getRequestDispatcher("author/deleteAuthorById.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("message", "author is deleted");
                            req.getRequestDispatcher("author/deleteAuthorById.jsp").forward(req, resp);
                        }
                    }
                    break;
                case "update":
                    String value = req.getParameter("value");
                    if (value == null) {
                        if (authorService.findAll().length != 0){
                            req.setAttribute("all", authorService.findAll());
                        } else {
                            req.setAttribute("message", "oops, the library is empty!");
                        }
                        req.getRequestDispatcher("author/updateAuthorById.jsp").forward(req, resp);
                        break;
                    } else {
                        String id1 = req.getParameter("id");
                        authorService.updateAuthorById(value, Integer.parseInt(id1));
                        if (isIdPresent(Integer.parseInt(id1))) {
                            req.setAttribute("message", "change was successful!");
                            req.getRequestDispatcher("author/updateAuthorById.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("message", "this author id not found! try again!");
                            req.getRequestDispatcher("author/updateAuthorById.jsp").forward(req, resp);
                        }
                    }
                    break;
            }
        } else {
            req.getRequestDispatcher("author/author.jsp").forward(req, resp);
        }
    }

    private boolean isIdPresent(int id) {
        Author byId = authorService.findById(id);
        return byId != null;
    }

    private boolean isEmpty() {
        Author[] all = authorService.findAll();
        int length = all.length;
        return length == 0;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        authorService.add(new Author(name));
        req.setAttribute("message", "author is added!");
        req.getRequestDispatcher("author/author.jsp").forward(req, resp);
    }
}
