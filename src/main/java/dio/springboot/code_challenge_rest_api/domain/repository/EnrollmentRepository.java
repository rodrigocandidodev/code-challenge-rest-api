package dio.springboot.code_challenge_rest_api.domain.repository;

import dio.springboot.code_challenge_rest_api.domain.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
