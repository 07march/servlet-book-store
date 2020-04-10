package by.store.servlet;

import by.store.entity.*;
import by.store.service.BookService;
import by.store.service.OrderService;
import by.store.service.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

// 04.04.2020 Реализовать удаление заказа пользователем
// 04.04.2020 Реализовать вывод сообщений при опр операциях и кнопки
// 04.04.2020 Реализовать филтр
// 04.04.2020 Решить проблему с созданием заказов
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private OrderService orderService;
    private StoreService storeService;
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        orderService = (OrderService) getServletContext().getAttribute("orderService");
        storeService = (StoreService) getServletContext().getAttribute("storeService");
        bookService = (BookService) getServletContext().getAttribute("bookService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        switch (operation) {
            case "prepare":
                String type = request.getParameter("type");
                switch (type) {
                    case "delivery":
                        request.getRequestDispatcher("order/orderDelivery.jsp").forward(request, response);
                        break;
                    case "pickup":
                        Store[] all = storeService.findAll();
                        request.setAttribute("stores", all);
                        request.getRequestDispatcher("order/orderPickUp.jsp").forward(request, response);
                        break;
                }
            case "create":
                request.setAttribute("flag", false);
                String typeDelivery = request.getParameter("type");
                switch (typeDelivery) {
                    case "delivery":
                        double total = 0;
                        Basket basket = (Basket) request.getSession().getAttribute("basket");
                        for (Book book : basket.getBooks()) {
                            if (book == null) break;
                            total = total + book.getPrice().doubleValue();
                        }
                        User currentUser = (User) request.getSession().getAttribute("currentUser");
                        String address = request.getParameter("address");
                        orderService.add(new Order(true, new BigDecimal(total), basket.getBooks(), currentUser, Order.Status.ACTIVE, new Address(address)));
                        request.setAttribute("flag", true);
                        request.setAttribute("Message", " Order is processed!");
                        request.getRequestDispatcher("order/orderStart.jsp").forward(request, response);
                        request.getSession().setAttribute("basket", new Basket(new Book[10]));
                        break;
                    case "pickup":
                        request.setAttribute("flag", false);
                        String store = request.getParameter("store");
                        Store byName = storeService.findByName(store);
                        double total2 = 0;
                        Basket basket2 = (Basket) request.getSession().getAttribute("basket");
                        for (Book book : basket2.getBooks()) {
                            if (book == null) break;
                            total2 = total2 + book.getPrice().doubleValue();
                        }
                        User currentUser2 = (User) request.getSession().getAttribute("currentUser");
                        orderService.add(new Order(byName, new BigDecimal(total2), basket2.getBooks(), currentUser2, Order.Status.ACTIVE));
                        request.setAttribute("Message", " Order is processed!");
                        request.setAttribute("flag", true);
                        request.getRequestDispatcher("order/orderStart.jsp").forward(request, response);
                        request.getSession().setAttribute("basket", new Basket(new Book[10]));
                        break;

                }
            case "delete":
                User currentUser1 = (User) request.getSession().getAttribute("currentUser");
                Order byUser = orderService.findByUser(currentUser1);
                if (byUser != null) {
                    orderService.delete(byUser.getId());
                    request.setAttribute("deleteMessage", " Last order is deleted!");
                    request.getRequestDispatcher("order/deleteOrder.jsp").forward(request, response);
                    break;
                } else {
                    request.setAttribute("deleteMessage", "oops, the story is empty!");
                    request.getRequestDispatcher("order/deleteOrder.jsp").forward(request, response);
                    break;
                }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation != null) {
            switch (operation) {
                case "find":
                    String type = request.getParameter("type");
                    switch (type) {
                        case "last":
                            User currentUser2 = (User) request.getSession().getAttribute("currentUser");
                            Order all = orderService.findByUser(currentUser2);
                            request.setAttribute("order", all);
                            request.getRequestDispatcher("order/order.jsp").forward(request, response);
                            break;
                        case "info":
                            User currentUser1 = (User) request.getSession().getAttribute("currentUser");
                            Order all1 = orderService.findByUser(currentUser1);
                            request.setAttribute("order", all1);
                            Book[] all2 = bookService.findAll();
                            request.setAttribute("all2", all2);
                            request.getRequestDispatcher("order/findOrder.jsp").forward(request, response);
                            break;
                    }
                case "delete":
                    request.getRequestDispatcher("order/deleteOrder.jsp").forward(request, response);
                    break;
            }
        } else {
            request.getRequestDispatcher("order/orderStart.jsp").forward(request, response);
        }
    }
}
