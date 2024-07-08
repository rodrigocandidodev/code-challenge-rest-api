package dio.springboot.code_challenge_rest_api.service.impl;

import dio.springboot.code_challenge_rest_api.domain.model.Enrollment;
import dio.springboot.code_challenge_rest_api.domain.repository.EnrollmentRepository;
import dio.springboot.code_challenge_rest_api.service.EnrollmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment create(@NotNull Enrollment enrollmentToCreate) {
        if(enrollmentRepository.existsById(enrollmentToCreate.getId())) {
            String message = "You're trying to create a duplicated enrollment";
            throw new IllegalArgumentException(message);
        }
        return enrollmentRepository.save(enrollmentToCreate);
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
