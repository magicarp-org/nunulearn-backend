package me.chanwookim.nunulearnbackend.service;

import me.chanwookim.nunulearnbackend.domain.Course;
import me.chanwookim.nunulearnbackend.domain.Member;
import me.chanwookim.nunulearnbackend.domain.Tag;
import me.chanwookim.nunulearnbackend.dto.CourseResponseDto;
import me.chanwookim.nunulearnbackend.dto.CreateCourseRequestDto;
import me.chanwookim.nunulearnbackend.repository.CourseRepository;
import me.chanwookim.nunulearnbackend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TagRepository tagRepository;

    @Autowired
    public CourseService(final CourseRepository courseRepository, final TagRepository tagRepository) {
        this.courseRepository = courseRepository;
        this.tagRepository = tagRepository;
    }

    public CourseResponseDto findCourseById(Long id) {
        return courseRepository.findById(id).get().toResponseDto();
    }
    //전체 강의를 반환
    public List<CourseResponseDto> findCourses() {
        return courseRepository.findAll().stream()
                .map(course -> course.toResponseDto())
                .collect(Collectors.toList());
    }

    //키워드 검색결과
    public List<CourseResponseDto> findCoursesByKeyword(String keyword) {
        return courseRepository.findByKeywordContains(keyword).stream()
                .map(course -> course.toResponseDto())
                .collect(Collectors.toList());
    }

    //태그로 강의 검색
    public List<CourseResponseDto> findCouesesByTagId(Integer tagId) {
        return courseRepository.findByTagContaining(tagId).stream()
                .map(course -> course.toResponseDto())
                .collect(Collectors.toList());
    }


    //강의 등록
    public CourseResponseDto newCourse(CreateCourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.of(courseRequestDto);
        Course result = courseRepository.save(course);
        return result.toResponseDto();
    }


}
