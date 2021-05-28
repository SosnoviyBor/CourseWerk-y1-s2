package CourseWork.dao.implementation;

import CourseWork.dao.DaoAdmin;
import CourseWork.dao.DaoFactory;
import CourseWork.dao.DaoNews;

public class DaoFactoryImpl implements DaoFactory {

    Database database;
    DaoNewsImpl newsDao;
    DaoAdminImpl adminDao;

    DaoFactoryImpl(Database database) {
        this.database = database;
        newsDao = new DaoNewsImpl(database);
        adminDao = new DaoAdminImpl(database);
    }

    @Override
    public DaoNews getNewsDao () { return newsDao; }

    @Override
    public DaoAdmin getAdminDao () { return adminDao; }

}
