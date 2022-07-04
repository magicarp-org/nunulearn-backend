package me.chanwookim.nunulearnbackend;

import me.chanwookim.nunulearnbackend.repository.CourseRepository;
import me.chanwookim.nunulearnbackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringConfig {
    private final CourseRepository courseRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(CourseRepository courseRepository, MemberRepository memberRepository) {
        this.courseRepository = courseRepository;
        this.memberRepository = memberRepository;
    }

}
