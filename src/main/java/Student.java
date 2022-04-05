public class Student extends StdList {
    private String name;
    private String lastName;
    private String major;
    private int std_id;

    public Student(String name, String lastName, String major, int std_id) {
        this.name = name;
        this.lastName = lastName;
        this.major = major;
        this.std_id = std_id;
        add_to_list(name, lastName,major,std_id);
        writing_std(name, lastName,major,std_id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }
}
