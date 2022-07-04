package me.chanwookim.nunulearnbackend.service;

import me.chanwookim.nunulearnbackend.domain.Course;
import me.chanwookim.nunulearnbackend.domain.Member;
import me.chanwookim.nunulearnbackend.domain.Tag;
import me.chanwookim.nunulearnbackend.dto.CourseResponseDto;
import me.chanwookim.nunulearnbackend.dto.CreateCourseRequestDto;
import me.chanwookim.nunulearnbackend.repository.CourseRepository;
import me.chanwookim.nunulearnbackend.repository.MemberRepository;
import me.chanwookim.nunulearnbackend.repository.TagRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    CourseService courseService;

    @Mock
    CourseRepository courseRepository;

    @Mock
    MemberRepository memberRepository;

    @Mock
    TagRepository tagRepository;


    @Test
    void findCourses_성공() {
        CreateCourseRequestDto request = createCourseRequestDto();
        Course course = new Course();
        course.of(request);

        Mockito.when(courseRepository.findAll())
                .thenReturn(List.of(course));

        List<CourseResponseDto> allCourse = courseService.findCourses();

        assertEquals(1, allCourse.size());
        assertEquals("Title", allCourse.get(0).getTitle());

    }


    @Test
    void findCoursesByKeyword_성공() {
        CreateCourseRequestDto request = createCourseRequestDto();
        Course course = new Course();
        course.of(request);

        Mockito.when(courseRepository.findByKeywordContains("Title"))
                .thenReturn(List.of(course));

        List<CourseResponseDto> result = courseService.findCoursesByKeyword("Title");

        assertEquals(1, result.size());
        assertEquals("Title", result.get(0).getTitle());
    }

    @Test
    void newCourse_성공() {

        CreateCourseRequestDto request = createCourseRequestDto();
        Course course = new Course();
        course.of(request);

        Mockito.when(courseRepository.save(any(Course.class)))
                .thenReturn(course);
        Mockito.when(courseRepository.findAll())
                .thenReturn(List.of(course));

        courseService.newCourse(request);
        List<CourseResponseDto> result = courseService.findCourses();

        assertEquals(1, result.size());
        Assertions.assertEquals("Title", result.get(0).getTitle());

    }

    @Test
    void findCoursesByTagId_성공() {

        Course course = createCourse();

        Tag tag = new Tag();
        tag.setTagName("Tag");
        tag.setId(1L);


        course.setTag(List.of(tag));

        List<CourseResponseDto> response = courseService.findCouesesByTagId(1);
//        System.out.println("course = " + course.getTagToString());

        Assertions.assertEquals("Tag",response.get(0).getTitle());

    }

    @Test
    void findCourseById_성공() {
        Course course = createCourse();
        course.setId(1L);

        Mockito.when(courseRepository.findById(1L))
                .thenReturn(Optional.of(course));


        CourseResponseDto responseDto = courseService.findCourseById(1L);

        Assertions.assertEquals("test course", responseDto.getTitle());


    }

    private Member createMember() {
        Member member = new Member();
        member.setName("tester");
        memberRepository.save(member);

        return member;
    }

    private Course createCourse() {
        Member member = createMember();
        Course course = new Course();
        course.setAuthor(member);
        course.setTitle("test course");
        courseRepository.save(course);
        return course;
    }

    private CreateCourseRequestDto createCourseRequestDto() {
        CreateCourseRequestDto request = new CreateCourseRequestDto();
        request.setTitle("Title");
        return request;
    }
}