package main.Mvc.Service;

import main.Mvc.dao.Indexdao;
import main.Mvc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceIm  implements IndexService {

    @Autowired
    private Indexdao indexdao;
    public Product getone(Integer id) {
        Product product = indexdao.getone(id);
        return product;
    }
}
