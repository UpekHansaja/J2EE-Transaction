package lk.jiat.ee.jta.servlet;

import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.ee.jta.ejb.local.UserBean;

import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    @PersistenceContext(unitName = "JTAPU")
    EntityManager em;

    @EJB
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userBean.register("Upek", "upekhansajabk@gmail.com", "1234", "0781048585");

    }
}
