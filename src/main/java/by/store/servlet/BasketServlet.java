package by.store.servlet;

import by.store.entity.Basket;
import by.store.entity.Book;
import by.store.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BasketServlet", urlPatterns = "/basket")
public class BasketServlet extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = (BookService) getServletContext().getAttribute("bookService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        switch (operation) {
            case "create":
                int id = Integer.parseInt(request.getParameter("id"));
                Book byId = bookService.findById(id);
                Basket basket = (Basket) request.getSession().getAttribute("basket");
                Book[] books = basket.getBooks();
                for (int i = 0; i < 10; i++) {
                    if (books[i] == null) {
                        books[i] = byId;
                        break;
                    }
                }
                response.sendRedirect("/basket");
                break;
            case "delete":
                int id1 = Integer.parseInt(request.getParameter("id"));
                Basket basket1 = (Basket) request.getSession().getAttribute("basket");
                Book[] books1 = basket1.getBooks();
                for (int i = 0; i < books1.length; i++) {
                    if (books1[i] == null) break;
                    if (books1[i].getId() == id1) {
                        if (books1.length - 1 - i >= 0)
                            System.arraycopy(books1, i + 1, books1, i, books1.length - 1 - i);
                        break;
                    }
                }
                response.sendRedirect("/basket");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Basket basket = (Basket) request.getSession().getAttribute("basket");
        request.setAttribute("basket", basket);
        if (basket.getBooks()[0] == null) {
            request.setAttribute("isEmpty", true);
            request.setAttribute("message", "is empty!");
            request.getRequestDispatcher("basket.jsp").forward(request, response);
        } else {
            Book[] books = basket.getBooks();
            double total = 0;
            List<Book> objects = new ArrayList<>();
            for (Book book : books) {
                if (book != null) {
                    objects.add(book);
                }
            }
            for (Book book : objects) {
                total = book.getPrice().doubleValue() + total;
            }
            request.setAttribute("total", total);
            request.setAttribute("books", objects);
            request.getRequestDispatcher("basket.jsp").forward(request, response);
        }
    }
}
