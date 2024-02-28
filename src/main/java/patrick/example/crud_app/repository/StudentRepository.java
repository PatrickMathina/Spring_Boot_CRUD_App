package patrick.example.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patrick.example.crud_app.model.StudentModel;

// This interface is used with Spring's Dependency Injection.
// Spring Data JPA will automatically implement this interface at runtime.
// No need to manually implement the methods for basic CRUD operations
// since JpaRepository already provides them.
@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    // Custom query methods can be defined here
}
