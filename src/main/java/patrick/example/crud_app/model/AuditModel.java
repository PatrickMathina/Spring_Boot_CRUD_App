package patrick.example.crud_app.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;
    private String actionType;
    private String description;
    private String tableName;
    private Long recordId;
    private Date actionTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;

    // Constructors
    public AuditModel(Long auditId, String actionType, String description, String tableName, Long recordId,
                      Date actionTimestamp, UserModel user) {
        this.auditId = auditId;
        this.actionType = actionType;
        this.description = description;
        this.tableName = tableName;
        this.recordId = recordId;
        this.actionTimestamp = actionTimestamp;
        this.user = user;
    }

    public AuditModel() {
    }

    // Getters, and Setters
    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getActionTimestamp() {
        return actionTimestamp;
    }

    public void setActionTimestamp(Date actionTimestamp) {
        this.actionTimestamp = actionTimestamp;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
