package by.store.repository;

import by.store.entity.Address;

public interface AddressRepository {
  void add(Address address);
  void delete(String address);
  boolean updateAddressById(String newAddress, int id);
  Address[] findAll();
  Address findById(int id);
  Address findByName(String name);
}
