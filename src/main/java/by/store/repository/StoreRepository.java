package by.store.repository;

import by.store.entity.Store;

public interface StoreRepository {
  void add(Store store);
  void delete(int id);
  boolean update(String name, int id);
  Store[] findAll();
  Store findByName(String name);
}
