package CourseWork.dao;

import CourseWork.models.AdminObject;

public interface DaoAdmin {

    AdminObject getAdminObjectByLogin(String login);

}
