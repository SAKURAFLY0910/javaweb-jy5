package main.com.itdr.mapper;

import main.com.itdr.pojo.Order;

import java.util.List;

public interface Mapper {
 List<Order> getAll();
 Order getone(Integer id);
}
