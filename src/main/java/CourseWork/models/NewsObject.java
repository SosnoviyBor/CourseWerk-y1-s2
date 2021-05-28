package CourseWork.models;

public class NewsObject {
    private Integer Id;
    private String name;
    private String description;
    private String date;
    private Integer category;

    public NewsObject(Integer Id, String name, String description, Integer category, String date){
        this.Id=Id;
        this.name=name;
        this.description=description;
        this.category=category;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
