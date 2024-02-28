package patrick.example.crud_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patrick.example.crud_app.model.MarkModel;
import patrick.example.crud_app.service.MarkService;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarkController {

    private final MarkService markService;

    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping
    public List<MarkModel> getAllMarks() {
        return markService.getAllMarks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarkModel> getMarkById(@PathVariable Long id) {
        MarkModel mark = markService.getMarkById(id);
        return ResponseEntity.ok(mark);
    }

    @PostMapping
    public MarkModel createMark(@RequestBody MarkModel mark) {
        return markService.saveMark(mark);
    }

    @PostMapping("/batch")
    public List<MarkModel> createMarks(@RequestBody List<MarkModel> marks) {
        return markService.saveMarks(marks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarkModel> updateMark(@PathVariable Long id, @RequestBody MarkModel markDetails) {
        MarkModel updatedMark = markService.updateMark(id, markDetails);
        return ResponseEntity.ok(updatedMark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMark(@PathVariable Long id) {
        markService.deleteMark(id);
        return ResponseEntity.noContent().build();
    }
}
