package CourseWork.controllers;

import CourseWork.models.NewsObject;
import CourseWork.services.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "NewsSearchServlet", value = "/NewsSearchServlet")
public class NewsSearchServlet extends HttpServlet {

    protected void requestProcessor (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String inp = request.getParameter("searchedText");
        ServletContext context = getServletContext();
        NewsService newsService = (NewsService) context.getAttribute("newsService");
        Collection<NewsObject> newsFound = newsService.getNewsByKeywords(inp);

        request.setAttribute("viewedNews", newsFound);
        request.getRequestDispatcher("index.jsp").forward(request,response);
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
