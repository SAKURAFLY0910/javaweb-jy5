package main.Mvc.dao;

import main.Mvc.pojo.Product;
import org.springframework.stereotype.Repository;

public interface Indexdao {
    Product getone(Integer id);
}
