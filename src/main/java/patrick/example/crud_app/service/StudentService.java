package patrick.example.crud_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.example.crud_app.model.StudentModel;
import patrick.example.crud_app.repository.StudentRepository;

import java.util.List;


// This setup allows you to perform CRUD operations on StudentModel objects
// by using the methods inherited from JpaRepository.
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CRUD operations methods:

    // Read all students
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }

    // Create or Update a student
    public StudentModel saveStudent(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    // Save a list of students (accepts a list of students)
    public List<StudentModel> saveStudents(List<StudentModel> students) {
        return studentRepository.saveAll(students);
    }

    // Read a single student by ID
    public StudentModel getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Delete a student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Additional methods can be added here as needed
}
