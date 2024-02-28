package patrick.example.crud_app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patrick.example.crud_app.model.AuditModel;
import patrick.example.crud_app.model.UserModel;
import patrick.example.crud_app.repository.AuditRepository;
import patrick.example.crud_app.repository.UserRepository;

import java.util.List;
import java.util.Date;

@Service
public class AuditService {
    private final AuditRepository auditRepository;
    private final UserRepository userRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository, AuditRepository auditRepository1, UserRepository userRepository) {
        this.auditRepository = auditRepository1;
        this.userRepository = userRepository;
    }

    public AuditModel logAuditAction(String actionType, String description, String tableName, Long recordId, Long userId) {
        UserModel user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        AuditModel audit = new AuditModel();
        audit.setActionType(actionType);
        audit.setDescription(description);
        audit.setTableName(tableName);
        audit.setRecordId(recordId);
        audit.setUser(user);
        audit.setActionTimestamp(new Date());
        return auditRepository.save(audit);
    }

    public List<AuditModel> getAllAudits() {
        return auditRepository.findAll();
    }

    public AuditModel saveAudit(AuditModel audit) {
        return auditRepository.save(audit);
    }

    public AuditModel getAuditById(Long id) {
        return auditRepository.findById(id).orElseThrow(() -> new RuntimeException("Audit not found"));
    }

    public void deleteAudit(Long id) {
        auditRepository.deleteById(id);
    }

    // Methods to fetch audit records
    public List<AuditModel> getAuditsByActionType(String actionType) {
        return auditRepository.findByActionType(actionType);
    }

    public List<AuditModel> getAuditsByUserId(Long userId) {
        return auditRepository.findByUser_UserId(userId);
    }

    public List<AuditModel> getAuditsByTableName(String tableName) {
        return auditRepository.findByTableName(tableName);
    }

    public List<AuditModel> getAuditsBetweenDates(Date startDate, Date endDate) {
        return auditRepository.findByActionTimestampBetween(startDate, endDate);
    }
}


