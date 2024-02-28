package patrick.example.crud_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.example.crud_app.model.MarkModel;
import patrick.example.crud_app.repository.MarkRepository;

import java.util.List;

@Service
public class MarkService {
    private final MarkRepository markRepository;

    @Autowired
    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<MarkModel> getAllMarks() {
        return markRepository.findAll();
    }

    public MarkModel saveMark(MarkModel mark) {
        return markRepository.save(mark);
    }

    public List<MarkModel> saveMarks(List<MarkModel> marks) {
        return markRepository.saveAll(marks);
    }

    public MarkModel getMarkById(Long id) {
        return markRepository.findById(id).orElseThrow(() -> new RuntimeException("Mark not found"));
    }

    public void deleteMark(Long id) {
        markRepository.deleteById(id);
    }

    public MarkModel updateMark(Long id, MarkModel markDetails) {
        MarkModel mark = getMarkById(id);
        mark.setStudent(markDetails.getStudent());
        mark.setSubject(markDetails.getSubject());
        mark.setMark(markDetails.getMark());
        mark.setDate_recorded(markDetails.getDate_recorded());
        return saveMark(mark);
    }
}
