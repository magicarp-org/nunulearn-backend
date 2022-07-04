package me.chanwookim.nunulearnbackend;

import me.chanwookim.nunulearnbackend.domain.Category;
import me.chanwookim.nunulearnbackend.domain.Course;
import me.chanwookim.nunulearnbackend.domain.Member;
import me.chanwookim.nunulearnbackend.domain.Tag;
import me.chanwookim.nunulearnbackend.repository.CourseRepository;
import me.chanwookim.nunulearnbackend.repository.MemberRepository;
import me.chanwookim.nunulearnbackend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NunulearnBackendApplication implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;

    @Autowired
    public NunulearnBackendApplication(CourseRepository courseRepository, MemberRepository memberRepository, TagRepository tagRepository) {
        this.courseRepository = courseRepository;
        this.memberRepository = memberRepository;
        this.tagRepository = tagRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(NunulearnBackendApplication.class, args);
    }

    public void run(String... args) throws Exception {

    }
//    public void run(String... args) throws Exception {
//        Member member = new Member();
//        member.setName("chanwoo");
//        memberRepository.save(member);
//
//        Course course1 = new Course();
//        course1.setAuthor(member);
//        course1.setCategory(Category.DEV);
//        course1.setTitle("스프링 데이터");
//        Tag tag1 = new Tag();
//        tag1.setTagName("스프링");
//        Tag tag2 = new Tag();
//        tag2.setTagName("자바");
//        Tag tag3 = new Tag();
//        tag3.setTagName("Spring");
//        Tag tag4 = new Tag();
//        tag4.setTagName("Java");
//
//        tagRepository.saveAll(List.of(tag1,tag2,tag3,tag4));
//
//        course1.setTag(List.of(tag1,tag2,tag3,tag4));
//        course1.setThumbnailUrl("https://cdn.inflearn.com/public/courses/328723/cover/062da05a-55e9-49f1-a9ad-3e67ea079fe9/328723-eng.png");
//        course1.setPrice(10000);
//        course1.setDescription("스프링 데이터 강의 ㅎㅎ ");
//        course1.setKeyword(course1.getTitle()+course1.getAuthor().getName()+ course1.getCategory()+course1.getTagToString());
//        courseRepository.save(course1);
//
//        Course course2 = new Course();
//        course2.setAuthor(member);
//        course2.setCategory(Category.DEV);
//        course2.setTitle("스프링 부트");
//        course2.setThumbnailUrl("https://cdn.inflearn.com/public/courses/328723/cover/062da05a-55e9-49f1-a9ad-3e67ea079fe9/328723-eng.png");
//        course2.setPrice(11000);
//        course2.setDescription("스프링 부트 강의 ㅎㅎ ");
//        courseRepository.save(course2);
//
//    }

}
