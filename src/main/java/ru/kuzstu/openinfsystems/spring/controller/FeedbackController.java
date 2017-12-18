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
import ru.kuzstu.openinfsystems.spring.model.FeedbackMessage;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "feedback/index";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @Transactional
    public String post(@RequestParam String name,
                       @RequestParam String email,
                       @RequestParam String message) {
        FeedbackMessage feedbackMessage = new FeedbackMessage();
        feedbackMessage.setCreated(Calendar.getInstance().getTime());
        feedbackMessage.setSenderName(name);
        feedbackMessage.setSenderEmail(email);
        feedbackMessage.setMessage(message);

        Session session = sessionFactory.getCurrentSession();
        session.save(feedbackMessage);

        return "redirect:/feedback/list";
    }

    @RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
    public String single(@PathVariable("id") int feedbackMessageId, Model model) {
        Session session = sessionFactory.getCurrentSession();

        FeedbackMessage feedbackMessage = session.get(FeedbackMessage.class, feedbackMessageId);
        model.addAttribute("feedbackMessage", feedbackMessage);

        return "feedback/single";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<FeedbackMessage> criteriaQuery = criteriaBuilder.createQuery(FeedbackMessage.class);
        Root<FeedbackMessage> feedbackMessageRoot = criteriaQuery.from(FeedbackMessage.class);
        criteriaQuery.select(feedbackMessageRoot);
        criteriaQuery.orderBy(criteriaBuilder.desc(feedbackMessageRoot.get("created")));

        List<FeedbackMessage> feedbackMessageList = session.createQuery(criteriaQuery)
                                                           .getResultList();
        model.addAttribute("feedbackMessageList", feedbackMessageList);
        return "feedback/list";
    }

}
