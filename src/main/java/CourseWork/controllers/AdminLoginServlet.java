package CourseWork.controllers;

import CourseWork.models.AdminObject;
import CourseWork.services.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    protected void requestProcessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getSession().invalidate();

        ServletContext context = getServletContext();
        AdminService adminService = (AdminService) context.getAttribute("adminService");
        String login = request.getParameter("login");
        AdminObject admin = adminService.getAdminObjectByLogin(login);
        String password = request.getParameter("password");

        if (admin == null || !adminService.isPasswordCorrect(admin, password)) {
            request.setAttribute("message", "Неправильно введений логін або пароль");
            request.getRequestDispatcher("adminPage.jsp").forward(request,response);
            return;
        }

        request.getSession().setAttribute("admin", admin);
        request.getRequestDispatcher("adminPage.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestProcessor(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestProcessor(request, response);
    }

}
