package model.user;


import model.self.Reserve;

import java.util.ArrayList;

public class Student extends User {
    public static ArrayList<Student> students;
    public boolean inDorm;
    public ArrayList<Reserve> reserveList;
    public int id;
    public int wallet;

    static {
        students = new ArrayList<>();
    }

    public Student(String username, String password, String name, int id, boolean inDorm) {
        super(username, password, name);
        this.inDorm = inDorm;
        this.id = id;
        wallet = 0;
        students.add(this);
    }
    public static Student getStudent(int id) {
        for (Student student : students) {
            if (student.id == id)
                return student;
        }
        return null;
    }
    public void deposit(int amount) {
        wallet += amount;
    }

    public void reserve(Reserve reserve) {
        reserveList.add(reserve);
        wallet -= reserve.price;
    }
    public boolean hasFood(int day, String type) {
        for (Reserve reserve :
                reserveList) {
            if (reserve.day == day && reserve.type.equals(type))
                return false;
        }
        return true;
    }
}