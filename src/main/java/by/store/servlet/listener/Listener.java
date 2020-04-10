package by.store.servlet.listener;

import by.store.repository.*;
import by.store.service.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        BookRepository bookRepository = new PgBookRepository();
        UserRepository userRepository = new PgUserRepository();
        OrderRepository orderRepository = new PgOrderRepository();
        AddressRepository addressRepository = new PgAddressRepository();
        CityRepository cityRepository = new PgCityRepository();
        StoreRepository storeRepository = new PgStoreRepository();
        AuthorRepository authorRepository = new PgAuthorRepository();

        AddressService addressService = new AddressServiceImpl(addressRepository);
        AuthorService authorService = new AuthorServiceImpl(authorRepository);
        BookService bookService = new BookServiceImpl(bookRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository);
        CityService cityService = new CityServiceImpl(cityRepository);
        StoreService storeService = new StoreServiceImpl(storeRepository);
        UserService userService = new UserServiceImpl(userRepository);

        sce.getServletContext().setAttribute("bookService", bookService);
        sce.getServletContext().setAttribute("addressService", addressService);
        sce.getServletContext().setAttribute("authorService", authorService);
        sce.getServletContext().setAttribute("cityService", cityService);
        sce.getServletContext().setAttribute("orderService", orderService);
        sce.getServletContext().setAttribute("storeService", storeService);
        sce.getServletContext().setAttribute("userService", userService);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
