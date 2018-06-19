package controllers;

import dao.ProfesionDAO;
import entity.Personal;
import entity.Profesion;
import services.serviceImpl.PersonalServiceImpl;
import services.serviceInterface.PersonalService;
import transaction.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyServlet",urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password= req.getParameter("password");
        Personal personal;
        PersonalService service = (PersonalServiceImpl)getServletContext().getAttribute("service");
        personal=service.getPersonal(1);
        if(personal.getLogin().equals(login)&&personal.getPassword().equals(password)){
            resp.sendRedirect("jsp/cabinet.jsp");
        }
    }
}
