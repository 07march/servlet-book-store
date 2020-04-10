package by.store.repository;

import by.store.entity.Author;

public interface AuthorRepository {
  void add(Author a);
  void delete(int id);
  boolean updateAuthorById(String name, int id);
  Author findById(int id);
  Author findByName(String name);
  Author[] findAll();
}
