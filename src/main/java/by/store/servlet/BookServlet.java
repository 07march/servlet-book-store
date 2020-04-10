package by.store.servlet;

import by.store.entity.Author;
import by.store.entity.Book;
import by.store.entity.Role;
import by.store.entity.User;
import by.store.service.AuthorService;
import by.store.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private BookService bookService;
    private AuthorService authorService;

    @Override
    public void init() {
        bookService = (BookService) getServletContext().getAttribute("bookService");
        authorService = (AuthorService) getServletContext().getAttribute("authorService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("price");
        int price1 = Integer.parseInt(price);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String author = request.getParameter("author");
        Author byName = authorService.findByName(author);
        bookService.add(new Book(new BigDecimal(price1), byName, title, description));
        request.setAttribute("message", "book added!");
        Author[] all = authorService.findAll();
        request.setAttribute("authors", all);
        request.getRequestDispatcher("book/book.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("operation") != null) {
            String operation = req.getParameter("operation");
            switch (operation) {
                case "find":
                    String type = req.getParameter("type");
                    switch (type) {
                        case "all":
                            Book[] all = bookService.findAll();
                            req.setAttribute("books", all);
                            if (!isEmpty()) {
                                User currentUser = (User) req.getSession().getAttribute("currentUser");
                                if (currentUser != null){
                                    if (currentUser.getRole().equals(Role.ADMIN)) {
                                        req.setAttribute("isAdmin", true);
                                    } else req.setAttribute("isAdmin", false);
                                }
                                req.getRequestDispatcher("book/findAllBooks.jsp").forward(req, resp);
                            } else {
                                req.setAttribute("message", "oops, the library is empty!");
                                req.getRequestDispatcher("book/findAllBooks.jsp").forward(req, resp);
                            }
                            break;
                        case "id":
                            String value = req.getParameter("value");
                            User currentUser = (User) req.getSession().getAttribute("currentUser");
                            if (currentUser != null){
                                if (currentUser.getRole().equals(Role.ADMIN)) {
                                    req.setAttribute("isAdmin", true);
                                } else req.setAttribute("isAdmin", false);
                            }
                            if (value == null) {
                                if (bookService.findAll().length != 0) {
                                    req.setAttribute("allBooks", bookService.findAll());
                                } else {
                                    req.setAttribute("message", "oops, the library is empty!");
                                }
                                req.getRequestDispatcher("book/findBookById.jsp").forward(req, resp);
                                break;
                            } else {
                                Book byId = bookService.findById(Integer.parseInt(value));
                                if (byId == null) {
                                    req.setAttribute("message", "book not found");
                                    req.getRequestDispatcher("book/findBookById.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("book", byId);
                                    req.setAttribute("message", byId.getTitle());
                                    req.getRequestDispatcher("book/findBookById.jsp").forward(req, resp);
                                }
                            }
                            break;
                        case "title":
                            String value1 = req.getParameter("value");
                            if (value1 == null) {
                                req.getRequestDispatcher("book/findBookByTitle.jsp").forward(req, resp);
                                break;
                            } else {
                                Book byTitle = bookService.findByTitle(value1);
                                if (byTitle == null) {
                                    req.setAttribute("message", "book not found");
                                    req.getRequestDispatcher("book/findBookByTitle.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", byTitle.getTitle());
                                    req.getRequestDispatcher("book/findBookByTitle.jsp").forward(req, resp);
                                }
                            }
                            break;
                        case "allByPrice":
                            String value2 = req.getParameter("value");
                            if (value2 == null) {
                                req.getRequestDispatcher("book/findAllBooksByPrice.jsp").forward(req, resp);
                                break;
                            }
                            Book[] allByPrice = bookService.findAllByPrice(new BigDecimal(value2));
                            req.setAttribute("books", allByPrice);
                            if (allByPrice.length == 0) {
                                req.setAttribute("message", "books not found");
                                req.getRequestDispatcher("book/findAllBooksByPrice.jsp").forward(req, resp);
                            } else {
                                req.setAttribute("message", "operation successful! Number of books: " + allByPrice.length);
                                req.getRequestDispatcher("book/findAllBooksByPrice.jsp").forward(req, resp);
                            }
                            break;
                        case "allByAuthorName":
                            String value3 = req.getParameter("value");
                            if (value3 == null) {
                                req.getRequestDispatcher("book/findAllBooksByAuthorName.jsp").forward(req, resp);
                                break;
                            }
                            Book[] byAuthorName = bookService.findByAuthorName(value3);
                            if (byAuthorName == null) {
                                req.setAttribute("message", "books not found");
                                req.getRequestDispatcher("book/findAllBooksByAuthorName.jsp").forward(req, resp);
                            } else {
                                req.setAttribute("books", byAuthorName);
                                req.setAttribute("message", "operation successful! Number of books: " + byAuthorName.length);
                                req.getRequestDispatcher("book/findAllBooksByAuthorName.jsp").forward(req, resp);
                            }
                    }
                    break;
                case "update":
                    String type1 = req.getParameter("type");
                    switch (type1) {
                        case "title":
                            String value = req.getParameter("value");
                            if (value == null) {
                                if (bookService.findAll().length != 0) {
                                    req.setAttribute("allBooks", bookService.findAll());
                                } else {
                                    req.setAttribute("message", "oops, the library is empty!");
                                }
                                req.getRequestDispatcher("book/updateBookTitle.jsp").forward(req, resp);
                                break;
                            } else {
                                int id = Integer.parseInt(req.getParameter("id"));
                                bookService.updateTitle(value, id);
                                if (isIdPresent(id)) {
                                    req.setAttribute("message", "update was successful!");
                                    req.getRequestDispatcher("book/updateBookTitle.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "this book id not found! try again!");
                                    req.getRequestDispatcher("book/updateBookTitle.jsp").forward(req, resp);
                                }
                            }
                            break;
                        case "price":
                            String value1 = req.getParameter("value");
                            if (value1 == null) {
                                if (bookService.findAll().length != 0) {
                                    req.setAttribute("allBooks", bookService.findAll());
                                } else {
                                    req.setAttribute("message", "oops, the library is empty!");
                                }
                                req.getRequestDispatcher("book/updateBookPrice.jsp").forward(req, resp);
                                break;
                            } else {
                                int id = Integer.parseInt(req.getParameter("id"));
                                bookService.updatePrice(new BigDecimal(value1), id);
                                if (isIdPresent(id)) {
                                    req.setAttribute("message", "update was successful!");
                                    req.getRequestDispatcher("book/updateBookPrice.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "this book id not found! try again!");
                                    req.getRequestDispatcher("book/updateBookPrice.jsp").forward(req, resp);
                                }
                            }
                            break;
                    }
                    break;
                case "delete":
                    String type2 = req.getParameter("type");
                    switch (type2) {
                        case "title":
                            String value = req.getParameter("value");
                            if (value == null) {
                                req.getRequestDispatcher("book/deleteBookByTitle.jsp").forward(req, resp);
                                break;
                            } else {
                                Book byTitle = bookService.findByTitle(value);
                                bookService.delete(value);
                                if (byTitle == null) {
                                    req.setAttribute("message", "this book not found! try again!");
                                    req.getRequestDispatcher("book/deleteBookByTitle.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "book deleted!");
                                    req.getRequestDispatcher("book/deleteBookByTitle.jsp").forward(req, resp);
                                }
                            }
                            break;
                        case "id":
                            String value1 = req.getParameter("value");
                            if (value1 == null) {
                                if (bookService.findAll().length != 0) {
                                    req.setAttribute("allBooks", bookService.findAll());
                                } else {
                                    req.setAttribute("message", "oops, the library is empty!");
                                }
                                req.getRequestDispatcher("book/deleteBookById.jsp").forward(req, resp);
                                break;
                            } else {
                                Book byId = bookService.findById(Integer.parseInt(value1));
                                bookService.delete(Integer.parseInt(value1));
                                if (byId == null) {
                                    req.setAttribute("message", "this book not found! try again!");
                                    req.getRequestDispatcher("book/deleteBookById.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "book deleted!");
                                    req.getRequestDispatcher("book/deleteBookById.jsp").forward(req, resp);
                                }
                            }
                            break;
                    }
            }
        } else {
            Author[] all = authorService.findAll();
            req.setAttribute("authors", all);
            req.getRequestDispatcher("book/book.jsp").forward(req, resp);
        }
    }

    private boolean isIdPresent(int id) {
        Book byId = bookService.findById(id);
        return byId != null;
    }

    private boolean isEmpty() {
        Book[] all = bookService.findAll();
        int length = all.length;
        return length == 0;
    }
}
