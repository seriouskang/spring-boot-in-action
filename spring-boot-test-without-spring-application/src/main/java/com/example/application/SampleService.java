package com.example.application;

import com.example.domain.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleRepository sampleRepository;

    public String findContentsById(Long id) {
        return sampleRepository.findContentsById(id);
    }
}
