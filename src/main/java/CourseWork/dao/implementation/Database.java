package CourseWork.dao.implementation;

import CourseWork.models.AdminObject;
import CourseWork.models.NewsObject;

import java.util.TreeMap;

public class Database {

    public TreeMap<Integer, NewsObject> newses;
    public TreeMap<Integer, AdminObject> admins;

    public Database() {
        newses = new TreeMap<>();
        admins = new TreeMap<>();
    }

    public DaoFactoryImpl getDaoFactory() {
        return new DaoFactoryImpl(this);
    }

}
