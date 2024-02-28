package patrick.example.crud_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patrick.example.crud_app.model.SubjectModel;
import patrick.example.crud_app.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SubjectModel> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectModel> getSubjectById(@PathVariable Long id) {
        SubjectModel subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public SubjectModel createSubject(@RequestBody SubjectModel subject) {
        return subjectService.saveSubject(subject);
    }

    @PostMapping("/batch")
    public List<SubjectModel> createSubjects(@RequestBody List<SubjectModel> subjects) {
        return subjectService.saveSubjects(subjects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectModel> updateSubject(@PathVariable Long id, @RequestBody SubjectModel subjectDetails) {
        SubjectModel updatedSubject = subjectService.updateSubject(id, subjectDetails);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
