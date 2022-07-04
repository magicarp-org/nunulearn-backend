package me.chanwookim.nunulearnbackend.repository;

import me.chanwookim.nunulearnbackend.domain.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TagRepositoryTest {
    @Autowired
    TagRepository tagRepository;

    @Test
    void 태그생성_성공() {
        Tag tag = new Tag();
        tag.setTagName("Tag");

        tagRepository.save(tag);
        List<Tag> allTag = tagRepository.findAll();

        assertEquals("Tag", allTag.get(0).getTagName());
    }

    @Test
    void 태그리스트_조회_성공() {
        Tag tag1 = new Tag();
        Tag tag2 = new Tag();
        tag1.setTagName("tag1");
        tag2.setTagName("tag2");

        tagRepository.save(tag1);
        tagRepository.save(tag2);

        List<Tag> tagList = tagRepository.findAll();

        assertEquals(2, tagList.size());
        assertEquals("tag1", tagList.get(0).getTagName());

    }

    @Test
    void Test_findByTagName_성공() {
        Tag tag = new Tag();
        tag.setTagName("tag");
        tagRepository.save(tag);
        List<Tag> result = tagRepository.findByTagName("tag");
        System.out.println("result = " + result.stream().map(tag1 -> tag1.getTagName()).collect(Collectors.toList()));
        assertEquals("tag", result.get(0).getTagName());
    }
}