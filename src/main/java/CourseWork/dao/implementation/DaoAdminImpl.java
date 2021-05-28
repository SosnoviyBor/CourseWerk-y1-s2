package CourseWork.dao.implementation;

import CourseWork.dao.DaoAdmin;
import CourseWork.models.AdminObject;

public class DaoAdminImpl implements DaoAdmin {

    Database db;

    DaoAdminImpl(Database database) { this.db=database; }

    @Override
    public AdminObject getAdminObjectByLogin(String login) {
        return db.admins.values()
                .stream()
                .filter(admin -> admin.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

}
