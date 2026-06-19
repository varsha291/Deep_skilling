class Student {

    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {

    public void displayStudentDetails(Student student) {

        System.out.println("Student Details");
        System.out.println("Name : " + student.getName());
        System.out.println("ID   : " + student.getId());
        System.out.println("Grade: " + student.getGrade());
    }
}

class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudent(String name, String grade) {
        model.setName(name);
        model.setGrade(grade);
    }

    public void showStudent() {
        view.displayStudentDetails(model);
    }
}

public class Ex10_MVC {

    public static void main(String[] args) {

        Student student = new Student("Varsha", 101, "A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        controller.showStudent();
    }
}