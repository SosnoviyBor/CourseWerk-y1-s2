package CourseWork.services.implementation;

import CourseWork.dao.DaoFactory;
import CourseWork.models.NewsObject;
import CourseWork.services.NewsService;

import java.util.Collection;

public class NewsServiceImpl implements NewsService {

    DaoFactory daoFactory;

    public NewsServiceImpl(DaoFactory dao) { this.daoFactory = dao; }

    @Override
    public Collection<NewsObject> getAllNews() { return daoFactory.getNewsDao().findAll(); }

    @Override
    public Collection<NewsObject> getNewsByKeywords(String text) {
        if (text == null || text.equals("")) {
            return getAllNews();
        }
        return daoFactory.getNewsDao().getNewsByKeywords(text);
    }

    @Override
    public NewsObject getNewsById(Integer id) { return daoFactory.getNewsDao().get(id); }

    @Override
    public Collection<NewsObject> getNewsByCategory(Integer id) { return daoFactory.getNewsDao().getNewsByCategory(id); }

    @Override
    public void insert(String name, String desc, Integer category, String date) {
        daoFactory.getNewsDao().insert(new NewsObject(0, name, desc, category, date));
    }

}
