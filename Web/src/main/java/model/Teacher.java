package model;

public class Teacher extends Person{

    public Teacher(Long id, String name, String surname, String DOB, String seriaNum, boolean active, String email, String phone, String gender) {
        super(id, name, surname, DOB, seriaNum, active, email, phone, gender);
    }

    public Teacher() {
        super();
    }
}
