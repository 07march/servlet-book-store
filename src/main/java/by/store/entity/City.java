package by.store.entity;

import java.io.Serializable;

public class City implements Serializable {
   private int id;
  private String name;

  public City(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public City() {
  }

  public City(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "City{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}


