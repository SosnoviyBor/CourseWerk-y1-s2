package CourseWork.controllers;

import CourseWork.models.NewsObject;
import CourseWork.services.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OpenNewsServlet", value = "/OpenNewsServlet")
public class OpenNewsServlet extends HttpServlet {

    protected void requestProcessor (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("charset=UTF-8");

        ServletContext context = getServletContext();
        NewsService newsService = (NewsService) context.getAttribute("newsService");
        NewsObject news = newsService.getNewsById( Integer.parseInt( request.getParameter("open") ) );

        request.setAttribute("News", news);
        request.getRequestDispatcher("openedNews.jsp").forward(request,response);
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
