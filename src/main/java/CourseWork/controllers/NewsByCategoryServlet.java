package CourseWork.controllers;

import CourseWork.models.NewsObject;
import CourseWork.services.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "NewsByCategoryServlet", value = "/NewsByCategoryServlet")
public class NewsByCategoryServlet extends HttpServlet {

    protected void requestProcessor (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        NewsService newsService = (NewsService) context.getAttribute("newsService");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Collection<NewsObject> newsFound = newsService.getNewsByCategory(id);

        request.setAttribute("viewedNews", newsFound);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestProcessor(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requestProcessor(request,response);
    }

}
