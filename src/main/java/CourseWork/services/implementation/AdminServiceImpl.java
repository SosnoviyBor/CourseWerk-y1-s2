package CourseWork.services.implementation;

import CourseWork.dao.DaoFactory;
import CourseWork.models.AdminObject;
import CourseWork.services.AdminService;

public class AdminServiceImpl implements AdminService {

    DaoFactory daoFactory;

    public AdminServiceImpl(DaoFactory dao) { this.daoFactory = dao; }

    @Override
    public AdminObject getAdminObjectByLogin(String login) { return daoFactory.getAdminDao().getAdminObjectByLogin(login); }

    @Override
    public boolean isPasswordCorrect(AdminObject admin, String password) { return admin.getPassword().equals(password); }

}