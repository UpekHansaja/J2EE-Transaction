package lk.jiat.ee.jta.servlet;

import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.lang.Object;

@WebServlet("/home")
public class Home extends HttpServlet {

    @PersistenceContext(unitName = "JTAPU")
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JTAPU");
//        EntityManager em = factory.createEntityManager();

        Query query = em.createNativeQuery("SELECT * FROM user;");
        List<Object[]> list = query.getResultList();

        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>User List</h1>");
        resp.getWriter().println("<table border='1'>");
        resp.getWriter().println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
        for (Object[] li : list) {
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<td>" + li[0] + "</td>");
            resp.getWriter().println("<td>" + li[2] + "</td>");
            resp.getWriter().println("<td>" + li[3] + "</td>");
            resp.getWriter().println("</tr>");
        }
        resp.getWriter().println("</table>");
        resp.getWriter().println("</body></html>");
//        em.close();
//        factory.close();
    }
}
