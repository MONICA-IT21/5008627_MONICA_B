package DESIGN_AND_PATTERN.MVCPatternExample;

public class MVCPatternTest {
    public static void main(String[] args) {
    
        Student model = retrieveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("HARITHA");
        controller.setStudentGrade("A");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Monica B");
        student.setId("IT182");
        student.setGrade("A");
        return student;
    }
}

