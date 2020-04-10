package by.store.service;

import by.store.entity.Address;

public interface AddressService {
  void add(Address address);
  void delete(String address);
  boolean updateAddressById(String address, int id);
  Address[] findAll();
  Address findById(int id);
  Address findByName(String name);
}
