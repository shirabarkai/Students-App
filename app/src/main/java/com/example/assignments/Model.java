package com.example.assignments;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    private List<Student> data = new LinkedList<>();

    public static Model instance() {
        return _instance;
    }

    private Model() {

        // Temp data
        addStudent(new Student("Noa Hacohen",    "207593898",  false, "", "0524268862", "Jerusalem"));
        addStudent(new Student("Daniel Sabag" , "209173822",  true, "", "0542499462", "TelAviv"));
        addStudent(new Student("Ross Geller","208596433",  false, "", "0579645820", "NewYork"));
        addStudent(new Student("Sponge Bob", "123567253",  false, "", "-", "Bikini Bottom"));
        addStudent(new Student("Rachel Green", "207598648",  false, "", "0526873594", "NewYork"));
        addStudent(new Student("Amit Atzmon", "23252632",  false, "", "0524268899", "Raanana"));
        addStudent(new Student("Ron Ben Israel", "123652485",  false, "", "0528596644", "Eilat"));
        addStudent(new Student("Amit Ben Ezra" , "207873887",  false, "", "0528738873", "Holon"));
        addStudent(new Student("Nadav Alon", "2075846673",  false, "", "0528453311", "Raanana"));
        addStudent(new Student("Omer Alon", "236589456",  false, "", "0524896675", "Givataim"));

    }

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student st) {
        data.add(st);
    }

    public void removeStudent(Student st) {
        data.remove(st);
    }

    public void updateStudentData(int index, Student st) {
        data.set(index,st);
    }

}

