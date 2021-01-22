package com.roma.ResumeRepository;

import com.roma.Resume.Resume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends CrudRepository<Resume, String> {

}