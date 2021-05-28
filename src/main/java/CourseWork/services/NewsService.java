package CourseWork.services;

import CourseWork.models.NewsObject;
import java.util.Collection;

public interface NewsService {

    Collection<NewsObject> getAllNews();

    Collection<NewsObject> getNewsByKeywords(String text);

    public NewsObject getNewsById(Integer Id);

    Collection<NewsObject> getNewsByCategory(Integer id);

    void insert(String Name, String desc, Integer categ, String date);

}
