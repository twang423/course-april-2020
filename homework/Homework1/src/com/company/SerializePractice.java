package com.company;

import java.io.*;
import java.util.Arrays;

public class SerializePractice {
    public static void main(String[] args) {
        Employee e = new Employee("Charlie", "01011911", "SDE", 50000);
        Employee m = null;

        ByteArrayOutputStream bufferout = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(bufferout)) {
//            // 写入int:
//            output.writeInt(12345);
//            // 写入String:
//            output.writeUTF("Hello");
//            // 写入Object:
            output.writeObject(e);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println(Arrays.toString(bufferout.toByteArray()));

        ByteArrayInputStream bufferin = new ByteArrayInputStream(bufferout.toByteArray());
        try (ObjectInputStream input = new ObjectInputStream(bufferin)) {
//            int n = input.readInt();
//            String s = input.readUTF();
              m = (Employee) input.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        if (m != null) {
            System.out.println(m.toString());
        }
    }
}

class Employee implements Serializable {
//    private static long serialVersionUID = 123456L;
    private String name;
    private String DOB;
    private String title;
    private int salary;

    Employee (String name, String DOB, String title, int salary) {
        this.name = name;
        this.DOB = DOB;
        this.title = title;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }
    public String getDOB() {
        return this.DOB;
    }
    public String getTitle() {
        return this.title;
    }
    public int getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                '}';
    }
}