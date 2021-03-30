package Input;

import java.io.IOException;

public class StudentLinkedList<T> {
    public static String nameSearch = "";
    public static String yearLevelSearch = "";
    public static String programSearch = "";
    public static String courseSearch1 = "";
    public static String courseSearch2 = "";
    public static String courseSearch3 = "";
    public static String courseSearch4 = "";
    public boolean read = false;

    public static int studentCount = 1;
    public static int searchedIndex = 0;

    //declare linked list nodes
    private class StudentNode {
        String studentName;
        String studentYear;
        String studentProgram;
        String studentCourse1;
        String studentCourse2;
        String studentCourse3;
        String studentCourse4;
        StudentNode next;
    }

    StudentNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    //push student data to the linked list
    public void pushStudentData(String name, String program, String year, String course1, String course2, String course3, String course4) throws IOException {
        StudentNode tail = new StudentNode();
        StudentNode temp = new StudentNode();

        tail.studentName = name;
        tail.studentYear = year;
        tail.studentProgram = program;
        tail.studentCourse1 = course1;
        tail.studentCourse2 = course2;
        tail.studentCourse3 = course3;
        tail.studentCourse4 = course4;
        tail.next = null;

        if (head == null) {
            head = tail;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = tail;
        }
        studentCount = studentCount + 1;
    }

    //traverse and display data in each node
    public void traverse() {
        StudentNode traverse = head;
        for (int i = 0; i < studentCount - 1; ++i) {
            System.out.println("\t\t| "
                    + traverse.studentName
                    + " - " + traverse.studentYear
                    + " - " + traverse.studentProgram
                    + " - " + traverse.studentCourse1
                    + " - " + traverse.studentCourse2
                    + " - " + traverse.studentCourse3
                    + " - " + traverse.studentCourse4
                    + " | ");
            traverse = traverse.next;
        }
    }

    public void editBetweenNodes(String name, String program, String year, String course1, String course2, String course3, String course4) throws IOException {
        StudentNode traverse = head;

        if (searchedIndex > 0) {
            for (int i = 1; i < searchedIndex; ++i) {
                traverse = traverse.next;
            }

            traverse.studentName = name;
            traverse.studentYear = year;
            traverse.studentProgram = program;
            traverse.studentCourse1 = course1;
            traverse.studentCourse2 = course2;
            traverse.studentCourse3 = course3;
            traverse.studentCourse4 = course4;
        }
        return;
    }

    public void deleteBetweenNodes() throws IOException {
        StudentNode body = new StudentNode();
        StudentNode traverse = head;

        if (searchedIndex == 1) {
            head = head.next;
            studentCount = studentCount - 1;
        } else if (searchedIndex > 1) {
            for (int i = 1; i < searchedIndex; ++i) {
                body = traverse;
                traverse = traverse.next;
            }
            body.next = traverse.next;
            studentCount = studentCount - 1;
        }
        return;
    }

    public void search(String name) {
        searchedIndex = 0;

        nameSearch = "";
        yearLevelSearch = "";
        programSearch = "";
        courseSearch1 = "";
        courseSearch2 = "";
        courseSearch3 = "";
        courseSearch4 = "";

        StudentNode traverse = head;
        for (int i = 0; i < studentCount - 1; ++i) {
            if (traverse.studentName.toLowerCase().equals(name.toLowerCase())){
                searchedIndex = i + 1;

                nameSearch = traverse.studentName;
                yearLevelSearch = traverse.studentYear;
                programSearch = traverse.studentProgram;
                courseSearch1 = traverse.studentCourse1;
                courseSearch2 = traverse.studentCourse2;
                courseSearch3 = traverse.studentCourse3;
                courseSearch4 = traverse.studentCourse4;
            }
            traverse = traverse.next;
        }
    }

    public void pushToStaticLinkedList(String name, String program, String yearLevel, String course1, String course2, String course3, String course4) throws IOException{
        allStudents.read = true;
        allStudents.pushStudentData(name, program, yearLevel, course1, course2, course3, course4);
    }
    public static StudentLinkedList allStudents = new StudentLinkedList();
}