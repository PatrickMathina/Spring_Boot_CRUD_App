package patrick.example.crud_app.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class MarkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mark_id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private SubjectModel subject;

    private int mark;
    private java.sql.Date date_recorded;

    protected MarkModel() {
    }

    public MarkModel(StudentModel student, SubjectModel subject, int mark, java.sql.Date date_recorded) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
        this.date_recorded = date_recorded;
    }

    // Getters and Setters

    public Long getMark_id() {
        return mark_id;
    }

    public void setMark_id(Long mark_id) {
        this.mark_id = mark_id;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getDate_recorded() {
        return date_recorded;
    }

    public void setDate_recorded(Date date_recorded) {
        this.date_recorded = date_recorded;
    }
}
