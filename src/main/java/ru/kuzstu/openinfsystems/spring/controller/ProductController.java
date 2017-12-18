package ru.kuzstu.openinfsystems.spring.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuzstu.openinfsystems.spring.model.Product;
import ru.kuzstu.openinfsystems.spring.model.ProductOrder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    @Transactional
    public String buy(@PathVariable("id") int productId) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, productId);

        ProductOrder order = new ProductOrder();
        order.setCreated(Calendar.getInstance().getTime());
        order.setProduct(product);
        session.save(order);

        return "redirect:/order/list";
    }

    @RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
    public String single(@PathVariable("id") int productId, Model model) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, productId);

        model.addAttribute("product", product);
        return "product/single";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);
        criteriaQuery.select(productRoot);
        criteriaQuery.orderBy(criteriaBuilder.desc(productRoot.get("price")));

        List<Product> productList = session.createQuery(criteriaQuery)
                                           .getResultList();
        model.addAttribute("productList", productList);
        return "product/list";
    }

}
