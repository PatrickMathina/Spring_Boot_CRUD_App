package patrick.example.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patrick.example.crud_app.model.MarkModel;

@Repository
public interface MarkRepository extends JpaRepository<MarkModel, Long> {
    // Custom query methods can be defined here
}
