package patrick.example.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patrick.example.crud_app.model.AuditModel;

import java.util.Date;
import java.util.List;

public interface AuditRepository extends JpaRepository<AuditModel, Long> {
    List<AuditModel> findByActionType(String actionType);

    List<AuditModel> findByUser_UserId(Long userId);
    List<AuditModel> findByTableName(String tableName);

    List<AuditModel> findByActionTimestampBetween(Date startDate, Date endDate);
}



