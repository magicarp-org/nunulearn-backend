package me.chanwookim.nunulearnbackend.repository;

import me.chanwookim.nunulearnbackend.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByKeywordContains(String keyword);

    List<Course> findByTagContaining(Integer tagId);
}
