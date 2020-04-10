package by.store.service;

import by.store.entity.Book;
import by.store.entity.Order;
import by.store.entity.Store;
import by.store.entity.User;

public interface OrderService {
  void add(Order order);
  void delete(int id);
  boolean update(Book[] books, int id);
  Order findByStore(Store store);
  Order[] findAll();
  Order findByUser(User user);
  Order[] findAllByStore(Store store);
}
