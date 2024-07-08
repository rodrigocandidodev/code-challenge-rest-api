package dio.springboot.code_challenge_rest_api.controller;

import dio.springboot.code_challenge_rest_api.domain.model.Enrollment;
import dio.springboot.code_challenge_rest_api.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) {
        var createdEnrollment = enrollmentService.create(enrollment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEnrollment.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdEnrollment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.findById(id));
    }
}
