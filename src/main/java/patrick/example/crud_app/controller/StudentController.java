package patrick.example.crud_app.controller;

import patrick.example.crud_app.model.StudentModel;
import patrick.example.crud_app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This class serves as the REST controller that handles HTTP requests related to student operations.
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a single student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable Long id) {
        StudentModel student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // Create a new student
    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel student) {
        return studentService.saveStudent(student);
    }

    // Create multiple students at once
    @PostMapping("/batch")
    public List<StudentModel> createStudents(@RequestBody List<StudentModel> students) {
        return studentService.saveStudents(students);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id, @RequestBody StudentModel studentDetails) {
        StudentModel existingStudent = studentService.getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setFirst_name(studentDetails.getFirst_name());
            existingStudent.setLast_name(studentDetails.getLast_name());
            existingStudent.setDate_of_birth(studentDetails.getDate_of_birth());
            // Any other fields to update
            StudentModel updatedStudent = studentService.saveStudent(existingStudent);
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build(); // Or any appropriate response
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
