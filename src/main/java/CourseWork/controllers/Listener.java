package CourseWork.controllers;

import CourseWork.dao.DaoFactory;
import CourseWork.dao.implementation.Database;
import CourseWork.dao.implementation.Test;
import CourseWork.models.NewsObject;
import CourseWork.services.AdminService;
import CourseWork.services.NewsService;
import CourseWork.services.implementation.AdminServiceImpl;
import CourseWork.services.implementation.NewsServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Collection;

public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized (ServletContextEvent sce) {

        Database database = new Database();
        DaoFactory daoFactory = database.getDaoFactory();

        Test.generate(database);

        NewsService newsService = new NewsServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("newsService", newsService);

        AdminService adminService = new AdminServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("adminService", adminService);

        Collection<NewsObject> allNews = newsService.getAllNews();
        sce.getServletContext().setAttribute("viewedNews", allNews);

    }

}
