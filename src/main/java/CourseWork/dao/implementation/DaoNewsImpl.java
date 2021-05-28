package CourseWork.dao.implementation;

import CourseWork.dao.DaoNews;
import CourseWork.models.NewsObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DaoNewsImpl implements DaoNews {

    Database db;

    public DaoNewsImpl(Database database) { this.db=database; };

    private boolean containsAllWords(NewsObject news, String[] words) {
        String allWords = Arrays.toString((news.getName()
                + " "
                + news.getDescription()).toLowerCase().split("[,. \\r\\n]+"));
        return Stream.of(words).allMatch(allWords::contains);
    }

    @Override
    public NewsObject get(Integer id) { return db.newses.get(id); }

    @Override
    public Collection<NewsObject> findAll() { return db.newses.values(); }

    @Override
    public void insert(NewsObject news) {
        int maxId = db.newses.keySet()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        news.setId(maxId + 1);
        db.newses.put(news.getId(), news);
    }

    @Override
    public Collection<NewsObject> getNewsByKeywords(String words) {
        String[] wordsTable = words.toLowerCase().split("[,. \\r\\n]+");
        return db.newses.values()
                .stream()
                .filter(newsModel -> containsAllWords(newsModel, wordsTable))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Collection<NewsObject> getNewsByCategory(Integer id) {
        return db.newses.values()
                .stream()
                .filter(i -> i.getCategory().equals(id))
                .collect(Collectors.toCollection(HashSet::new));
    }

}
