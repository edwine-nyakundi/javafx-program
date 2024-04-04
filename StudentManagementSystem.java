package student;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentManagementSystem {
    private JFrame frame;
    private JPanel studentPanel;
    private JTextField studentNameField;
    private JTextField studentGradeField;
    private JTextField studentGPAField;
    private JTextField studentVGHoursField;
    private JButton quitButton;
    private JButton deleteButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton updateButton;
    private JButton addButton;

    private ArrayList<Student> studentsList;
    private int currentIndex;

    public StudentManagementSystem(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
        this.currentIndex = 0;

        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentPanel = new JPanel();
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));

        studentNameField = new JTextField(20);
        studentGradeField = new JTextField(20);
        studentGPAField = new JTextField(20);
        studentVGHoursField = new JTextField(20);

        deleteButton = new JButton("Delete");
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        updateButton = new JButton("Update");
        addButton = new JButton("Add");
        quitButton = new JButton("Exit");

        deleteButton.addActionListener(e -> deleteStudent());
        nextButton.addActionListener(e -> showNextStudent());
        previousButton.addActionListener(e -> showPreviousStudent());
        updateButton.addActionListener(e -> updateStudent());
        addButton.addActionListener(e -> addStudent());
        quitButton.addActionListener(e -> System.exit(0));

        studentPanel.add(new JLabel("Student Name:"));
        studentPanel.add(studentNameField);
        studentPanel.add(new JLabel("Grade:"));
        studentPanel.add(studentGradeField);
        studentPanel.add(new JLabel("GPA:"));
        studentPanel.add(studentGPAField);
        studentPanel.add(new JLabel("Volunteer Hours:"));
        studentPanel.add(studentVGHoursField);
        studentPanel.add(addButton);
        studentPanel.add(deleteButton);
        studentPanel.add(previousButton);
        studentPanel.add(nextButton);
        studentPanel.add(updateButton);
        studentPanel.add(quitButton);

        frame.getContentPane().add(studentPanel);
        frame.pack();
        frame.setVisible(true);

        displayStudentDetails();
    }

    private void displayStudentDetails() {
        if (studentsList.isEmpty()) {
            clearFields();
            return;
        }
        Student student = studentsList.get(currentIndex);
        studentNameField.setText(student.getName());
        studentGradeField.setText(student.getGrade());
        studentGPAField.setText(String.valueOf(student.getGPA()));
        studentVGHoursField.setText(String.valueOf(student.getVolunteerHours()));
    }

    private void clearFields() {
        studentNameField.setText("");
        studentGradeField.setText("");
        studentGPAField.setText("");
        studentVGHoursField.setText("");
    }

    private void deleteStudent() {
        if (!studentsList.isEmpty()) {
            studentsList.remove(currentIndex);
            if (currentIndex >= studentsList.size()) {
                currentIndex--;
            }
            if (!studentsList.isEmpty()) {
                displayStudentDetails();
            } else {
                clearFields();
            }
        }
    }

    private void showNextStudent() {
        if (!studentsList.isEmpty()) {
            currentIndex = (currentIndex + 1) % studentsList.size();
            displayStudentDetails();
        }
    }

    private void showPreviousStudent() {
        if (!studentsList.isEmpty()) {
            currentIndex = (currentIndex - 1 + studentsList.size()) % studentsList.size();
            displayStudentDetails();
        }
    }

    private void updateStudent() {
        if (!studentsList.isEmpty()) {
            Student student = studentsList.get(currentIndex);
            student.setName(studentNameField.getText());
            student.setGrade(studentGradeField.getText());
            student.setGPA(Double.parseDouble(studentGPAField.getText()));
            student.setVolunteerHours(Integer.parseInt(studentVGHoursField.getText()));
        }
    }

    private void addStudent() {
        Student student = new Student(
                studentNameField.getText(),
                studentGradeField.getText(),
                Double.parseDouble(studentGPAField.getText()),
                Integer.parseInt(studentVGHoursField.getText())
        );
        studentsList.add(student);
        currentIndex = studentsList.size() - 1;
    }

    public static void main(String[] args) {
        ArrayList<Student> studentsList = new ArrayList<>();
        SwingUtilities.invokeLater(() -> new StudentManagementSystem(studentsList));
    }
}
