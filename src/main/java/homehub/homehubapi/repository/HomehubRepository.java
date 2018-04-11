package homehub.homehubapi.repository;

import homehub.homehubapi.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomehubRepository extends JpaRepository<Configuration, String> {
}
