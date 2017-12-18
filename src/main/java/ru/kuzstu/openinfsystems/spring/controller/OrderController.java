package ru.kuzstu.openinfsystems.spring.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuzstu.openinfsystems.spring.model.ProductOrder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProductOrder> criteriaQuery = criteriaBuilder.createQuery(ProductOrder.class);
        Root<ProductOrder> orderRoot = criteriaQuery.from(ProductOrder.class);
        criteriaQuery.select(orderRoot);
        criteriaQuery.orderBy(criteriaBuilder.desc(orderRoot.get("created")));

        List<ProductOrder> orderList = session.createQuery(criteriaQuery)
                                              .getResultList();
        model.addAttribute("orderList", orderList);
        return "order/list";
    }

}
