package by.store.servlet;

import by.store.entity.Address;
import by.store.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddressServlet", urlPatterns = "/address")
public class AddressServlet extends HttpServlet {

    private AddressService addressService;

    @Override
    public void init() {
        addressService = (AddressService) getServletContext().getAttribute("addressService");
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
                            Address[] all = addressService.findAll();
                            req.setAttribute("all", all);
                            if (!isEmpty()) {
                                req.getRequestDispatcher("address/findAllAddresses.jsp").forward(req, resp);
                            } else {
                                req.setAttribute("message", "oops, the library is empty!");
                                req.getRequestDispatcher("address/findAllAddresses.jsp").forward(req, resp);
                            }
                            break;
                        case "id":
                            String id1 = req.getParameter("value");
                            if (id1 == null) {
                                if (addressService.findAll().length != 0){
                                    req.setAttribute("allAddresses", addressService.findAll());
                                } else {
                                    req.setAttribute("message", "oops, the library is empty!");
                                }
                                req.getRequestDispatcher("address/findAddressById.jsp").forward(req, resp);
                                break;
                            } else {
                                int i = Integer.parseInt(id1);
                                Address byId = addressService.findById(i);
                                if (byId == null) {
                                    req.setAttribute("message", "address not found");
                                    req.getRequestDispatcher("address/findAddressById.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "found address:" + byId.getAddress());
                                    req.getRequestDispatcher("address/findAddressById.jsp").forward(req, resp);
                                }
                            }
                            break;
                        case "name":
                            String value = req.getParameter("value");
                            if (value == null) {
                                req.getRequestDispatcher("address/findAddressByName.jsp").forward(req, resp);
                                break;
                            } else {
                                Address byName = addressService.findByName(value);
                                if (byName == null) {
                                    req.setAttribute("message", "address not found");
                                    req.getRequestDispatcher("address/findAddressByName.jsp").forward(req, resp);
                                } else {
                                    req.setAttribute("message", "found address:" + byName.getAddress());
                                    req.getRequestDispatcher("address/findAddressByName.jsp").forward(req, resp);
                                }
                            }
                            break;
                    }
                case "update":
                    String value = req.getParameter("value");
                    if (value == null) {
                        if (addressService.findAll().length != 0){
                            req.setAttribute("allAddresses", addressService.findAll());
                        } else {
                            req.setAttribute("message", "oops, the library is empty!");
                        }
                        req.getRequestDispatcher("address/updateAddressById.jsp").forward(req, resp);
                        break;
                    } else {
                        String id = req.getParameter("id");
                        addressService.updateAddressById(value, Integer.parseInt(id));
                        if (isIdPresent(Integer.parseInt(id))) {
                            req.setAttribute("message", "change was successful!");
                            req.getRequestDispatcher("address/updateAddressById.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("message", "this address id not found! try again!");
                            req.getRequestDispatcher("address/updateAddressById.jsp").forward(req, resp);
                        }
                    }
                    break;
                case "delete":
                    String address = req.getParameter("address");
                    if (address == null) {
                        req.getRequestDispatcher("address/deleteAddressByName.jsp").forward(req, resp);
                        break;
                    } else {
                        Address byName = addressService.findByName(address);
                        addressService.delete(address);
                        if (byName == null) {
                            req.setAttribute("message", "address not found");
                            req.getRequestDispatcher("address/deleteAddressByName.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("message", "address is deleted");
                            req.getRequestDispatcher("address/deleteAddressByName.jsp").forward(req, resp);
                        }
                    }
                    break;
            }
        } else {
            req.getRequestDispatcher("address/address.jsp").forward(req, resp);
        }
    }

    private boolean isIdPresent(int id) {
        Address byId = addressService.findById(id);
        return byId != null;
    }

    private boolean isEmpty() {
        Address[] all = addressService.findAll();
        int length = all.length;
        return length == 0;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        addressService.add(new Address(address));
        req.setAttribute("message", "address is added!");
        req.getRequestDispatcher("address/address.jsp").forward(req, resp);
    }
}
