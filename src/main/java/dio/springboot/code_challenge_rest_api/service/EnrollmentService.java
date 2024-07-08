package dio.springboot.code_challenge_rest_api.service;

import dio.springboot.code_challenge_rest_api.domain.model.Enrollment;

public interface EnrollmentService {
    Enrollment create(Enrollment enrollmentToCreate);
    Enrollment findById(Long id);
}
