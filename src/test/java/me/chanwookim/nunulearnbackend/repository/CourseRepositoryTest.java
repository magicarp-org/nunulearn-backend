package me.chanwookim.nunulearnbackend.repository;

import me.chanwookim.nunulearnbackend.domain.Course;
import me.chanwookim.nunulearnbackend.domain.Member;
import me.chanwookim.nunulearnbackend.domain.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TagRepository tagRepository;


    @Test
    void 강의_저장() {
        Course course = new Course();
        courseRepository.save(course);

        assertEquals(1, courseRepository.findAll().size());
    }

    @Test
    void 강의_키워드_검색() {
        Member member = new Member();
        member.setName("Tester");
        memberRepository.save(member);

        Tag tag = new Tag();
        tag.setTagName("T");
        tagRepository.save(tag);

        Course course = new Course();
        course.setTitle("Title");
        course.setAuthor(member);
        course.setTag(List.of(tag));
        course.setKeyword(course.getTitle()+course.getAuthor().getName()+ course.getCategory()+course.getTagToString());
        courseRepository.save(course);

        System.out.println("course.getKeyword() = " + course.getKeyword());

        List<Course> result = courseRepository.findByKeywordContains("Title");

        assertEquals("Title", result.get(0).getTitle());

    }


}