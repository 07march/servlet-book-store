package by.store.servlet;

import by.store.entity.City;
import by.store.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CityServlet", urlPatterns = "/city")
public class CityServlet extends HttpServlet {

    private CityService cityService;

    @Override
    public void init() {
        cityService = (CityService) getServletContext().getAttribute("cityService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        cityService.add(new City(name));
        request.setAttribute("message", "City added!");
        request.getRequestDispatcher("city/city.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("operation") != null) {
            String operation = request.getParameter("operation");
            switch (operation) {
                case "find":
                    String type = request.getParameter("type");
                    switch (type) {
                        case "all":
                            City[] all = cityService.findAll();
                            request.setAttribute("cities", all);
                            if (!isEmpty()) {
                                request.getRequestDispatcher("city/findAllCities.jsp").forward(request, response);
                            } else {
                                request.setAttribute("message", "oops, the library is empty!");
                                request.getRequestDispatcher("city/findAllCities.jsp").forward(request, response);
                            }
                            break;
                        case "name":
                            String value = request.getParameter("value");
                            if (value == null) {
                                request.getRequestDispatcher("city/findCityByName.jsp").forward(request, response);
                                break;
                            } else {
                                City byName = cityService.findByName(value);
                                if (byName == null) {
                                    request.setAttribute("message", "this city not found!");
                                    request.getRequestDispatcher("city/findCityByName.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("message", "city found: " + byName.getName());
                                    request.getRequestDispatcher("city/findCityByName.jsp").forward(request, response);
                                }
                            }
                            break;
                    }
                case "delete":
                    String type1 = request.getParameter("type");
                    switch (type1) {
                        case "name":
                            String name = request.getParameter("name");
                            if (name == null) {
                                request.getRequestDispatcher("city/deleteCityByName.jsp").forward(request, response);
                                break;
                            } else {
                                City byName = cityService.findByName(name);
                                if (byName == null) {
                                    request.setAttribute("message", "city not found!");
                                    request.getRequestDispatcher("city/deleteCityByName.jsp").forward(request, response);
                                } else {
                                    cityService.delete(name);
                                    request.setAttribute("message", "city is deleted!");
                                    request.getRequestDispatcher("city/deleteCityByName.jsp").forward(request, response);
                                }
                            }
                            break;
                        case "id":
                            String value = request.getParameter("value");
                            if (value == null) {
                                if (cityService.findAll().length != 0) {
                                    request.setAttribute("allCities", cityService.findAll());
                                } else {
                                    request.setAttribute("message", "oops, the library is empty!");
                                }
                                request.getRequestDispatcher("city/deleteCityById.jsp").forward(request, response);
                                break;
                            } else {
                                String id = request.getParameter("id");
                                City byId = cityService.findById(Integer.parseInt(id));
                                if (byId == null) {
                                    request.setAttribute("message", "city not found!");
                                    request.getRequestDispatcher("city/deleteCityById.jsp").forward(request, response);
                                } else {
                                    cityService.delete(Integer.parseInt(id));
                                    request.setAttribute("message", "city is deleted!");
                                    request.getRequestDispatcher("city/deleteCityById.jsp").forward(request, response);
                                }
                            }
                            break;
                    }
                case "update":
                    String value = request.getParameter("value");
                    if (value == null) {
                        if (cityService.findAll().length != 0) {
                            request.setAttribute("allCities", cityService.findAll());
                        } else {
                            request.setAttribute("message", "oops, the library is empty!");
                        }
                        request.getRequestDispatcher("city/updateCityName.jsp").forward(request, response);
                        break;
                    } else {
                        String id = request.getParameter("id");
                        City byId = cityService.findById(Integer.parseInt(id));
                        request.setAttribute("oldName", byId);
                        cityService.update(value, Integer.parseInt(id));
                        if (isIdPresent(Integer.parseInt(id))) {
                            request.setAttribute("message", "change was successful!");
                            request.getRequestDispatcher("city/updateCityName.jsp").forward(request, response);
                        } else {
                            request.setAttribute("message", "this author id not found! try again!");
                            request.getRequestDispatcher("city/updateCityName.jsp").forward(request, response);
                        }
                    }
                    break;
            }
        } else {
            request.getRequestDispatcher("city/city.jsp").forward(request, response);
        }
    }

    private boolean isIdPresent(int id) {
        City byId = cityService.findById(id);
        return byId != null;
    }

    private boolean isEmpty() {
        City[] all = cityService.findAll();
        int length = all.length;
        return length == 0;
    }
}
