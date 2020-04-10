package by.store.repository.filedb;

import by.store.entity.*;

import java.util.List;

public interface DB {
  <T> void change(List<T> list, int id, Class<T> clazz);
  <T> List<T> getList(Class<T> clazz);
  int getId(Class<?> clazz);
}
