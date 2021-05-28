package CourseWork.models;

public class AdminObject {
    private Integer adminId;
    private String name;
    private String login;
    private String password;

    public AdminObject(Integer adminId, String name, String login, String password) {
        this.adminId = adminId;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
