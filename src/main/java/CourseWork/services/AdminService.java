package CourseWork.services;

import CourseWork.models.AdminObject;

public interface AdminService {

    AdminObject getAdminObjectByLogin(String login);

    boolean isPasswordCorrect(AdminObject admin, String password);

}
