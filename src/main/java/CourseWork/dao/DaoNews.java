package CourseWork.dao;

import CourseWork.models.NewsObject;
import java.util.Collection;

public interface DaoNews {

    Collection<NewsObject> getNewsByKeywords(String text);

    NewsObject get(Integer id);

    Collection<NewsObject> findAll();

    void insert(NewsObject news);

    Collection<NewsObject> getNewsByCategory(Integer Id);

}
