package java4web.servlets;

import java4web.servlets.config.ApplicationConfiguration;
import java4web.servlets.dao.GuestDao;
import java4web.servlets.domain.Guest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GuestServlet extends HttpServlet{

    public GuestDao dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Called GET method");
        List<Guest> guests = dao.findAll();
        guests.forEach(System.out::println);
        request.setAttribute("guests", guests);
        request.getRequestDispatcher("/guest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Called POST method");
        Guest guest = new Guest();
        guest.setName(request.getParameter("name"));
        guest.setMessage(request.getParameter("message"));
        guest.setRating(Integer
                .parseInt(request.getParameter("rating")));
        dao.save(guest);
        System.out.println("New Guest: " + guest.toString());
        response.sendRedirect("/");
    }

    @Override
    public void init() throws ServletException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        dao = ctx.getBean(GuestDao.class);
        System.out.println("Servlet init");
    }
}
