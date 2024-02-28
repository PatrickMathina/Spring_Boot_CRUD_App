package patrick.example.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patrick.example.crud_app.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
