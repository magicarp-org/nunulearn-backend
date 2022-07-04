package me.chanwookim.nunulearnbackend.controller;

import me.chanwookim.nunulearnbackend.domain.Course;
import me.chanwookim.nunulearnbackend.dto.CourseResponseDto;
import me.chanwookim.nunulearnbackend.dto.CreateCourseRequestDto;
import me.chanwookim.nunulearnbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    List<CourseResponseDto> getCourses() {
        return courseService.findCourses();
    }

    @PostMapping
    CourseResponseDto createCourse(CreateCourseRequestDto course) {
        return courseService.newCourse(course);
    }

    @GetMapping("/{id}")
    CourseResponseDto getCourse(@PathParam("id") Long id) {
        return courseService.findCourseById(id);
    }
}
