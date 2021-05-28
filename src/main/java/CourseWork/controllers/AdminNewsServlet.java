package CourseWork.controllers;

import CourseWork.services.NewsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminNewsServlet", value = "/AdminNewsServlet")
public class AdminNewsServlet extends HttpServlet {

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

    protected void requestProcessor (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ServletContext context = getServletContext();
        NewsService newsService = (NewsService) context.getAttribute("newsService");
        String name = stringParamParser(request.getParameter("name"));
        String desc = stringParamParser(request.getParameter("desc"));
        String date = stringParamParser(request.getParameter("date"));
        Integer category = integerParamParser(request.getParameter("category"));

        if (name==""||desc==""||date==""||category==null) {
            request.setAttribute("message", "<b>Усі поля мають бути заповнені</b>");
            badInput(request,response,name,desc,date,category);
            return;
        }

        if (!dateValidator(date,request)) {
            badInput(request,response,name,desc,date,category);
            return;
        }

        newsService.insert(name,desc,category,date);
        request.setAttribute("message", "Новина була успішно створена");
        request.getRequestDispatcher("adminPage.jsp").forward(request,response);
    }

    protected String stringParamParser(String param) {
        if (param == null) { return ""; }
        return param;
    }

    protected Integer integerParamParser(String param) {
        if (param == "") { return null; }
        return Integer.parseInt(param);
    }

    protected boolean dateValidator (String date, HttpServletRequest request) {
        if (!date.matches("\\d{2}.\\d{2}.\\d{4}")) {
            request.setAttribute("message",
                    "Дата була вказана у неправильному форматі<br>Запишіть її у форматі <b>дд.мм.рррр</b>");
            return false;
        }

        Integer day = Integer.parseInt(date.substring(0,2));
        Integer month = Integer.parseInt(date.substring(3,5));
        Integer year = Integer.parseInt(date.substring(6,10));

        if (day<=0 || month<=0 || year<=0) {
            request.setAttribute("message", "День/місяць/рік не може бути рівним нулю");
            return false;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day <= 31) return true;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day <= 30) return true;

            case 2:
                if (day <= 28) return true;
                if (year % 4 == 0 && day == 29) return true;

            default:
                request.setAttribute("message","Ви вказали неможливу дату");
                return false;
        }
    }

    protected void badInput(HttpServletRequest request, HttpServletResponse response,
                            String name, String desc, String date, Integer category)
            throws ServletException, IOException {
        request.setAttribute("nameVal", name);
        request.setAttribute("descVal", desc);
        request.setAttribute("dateVal", date);
        request.setAttribute("categoryVal", category);
        request.getRequestDispatcher("adminPage.jsp").forward(request,response);
    }

}
