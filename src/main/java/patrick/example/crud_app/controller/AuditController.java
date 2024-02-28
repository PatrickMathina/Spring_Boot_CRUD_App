package patrick.example.crud_app.controller;

import patrick.example.crud_app.model.AuditModel;
import patrick.example.crud_app.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/audit")
public class AuditController {

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/byActionType")
    public List<AuditModel> getAuditsByActionType(@RequestParam String actionType) {
        return auditService.getAuditsByActionType(actionType);
    }

    @GetMapping("/byUserId")
    public List<AuditModel> getAuditsByUserId(@RequestParam Long userId) {
        return auditService.getAuditsByUserId(userId);
    }

    @GetMapping("/byTableName")
    public List<AuditModel> getAuditsByTableName(@RequestParam String tableName) {
        return auditService.getAuditsByTableName(tableName);
    }

    @GetMapping("/byDateRange")
    public List<AuditModel> getAuditsBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return auditService.getAuditsBetweenDates(startDate, endDate);
    }
}
