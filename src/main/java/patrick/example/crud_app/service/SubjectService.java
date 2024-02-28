package patrick.example.crud_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.example.crud_app.model.SubjectModel;
import patrick.example.crud_app.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectModel> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectModel saveSubject(SubjectModel subject) {
        return subjectRepository.save(subject);
    }

    public List<SubjectModel> saveSubjects(List<SubjectModel> subjects) {
        return subjectRepository.saveAll(subjects);
    }

    public SubjectModel getSubjectById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    public SubjectModel updateSubject(Long id, SubjectModel subjectDetails) {
        SubjectModel subject = getSubjectById(id);
        subject.setSubject_name(subjectDetails.getSubject_name());
        return saveSubject(subject);
    }
}
