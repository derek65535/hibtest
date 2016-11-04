package com.github.dmandg;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.SQLException;

@RequestMapping("/derek")
@Controller
public class DerekController {

    @Autowired
    MessageProvider msgProvider;

    @Autowired
    Connection database;

    @Autowired
    SessionFactory hib;

    @RequestMapping("/yes")
    @ResponseBody
    public String yes() {
        return msgProvider.getMessage();
    }

    @RequestMapping("/db")
    @ResponseBody
    public String db() throws SQLException {
        return hib.getProperties().toString();
    }
}
