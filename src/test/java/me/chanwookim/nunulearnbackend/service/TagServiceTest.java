package me.chanwookim.nunulearnbackend.service;

import me.chanwookim.nunulearnbackend.domain.Tag;
import me.chanwookim.nunulearnbackend.dto.TagRequestDto;
import me.chanwookim.nunulearnbackend.dto.TagResponseDto;
import me.chanwookim.nunulearnbackend.exception.TagNameDuplicateException;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {

    @InjectMocks
    TagService tagService;

    @Mock
    TagRepository tagRepository;


    @Test
    void tag만들기_성공() {
        String tagName = "test tag";
        TagRequestDto tagRequestDto = new TagRequestDto();
        tagRequestDto.setTagName(tagName);
        Tag tag = new Tag();
        tag.of(tagRequestDto);
        tag.setId(0L);



        Mockito.when(tagRepository.findAll())
                .thenReturn(List.of(tag));

        Mockito.when(tagRepository.save(any(Tag.class)))
                        .thenReturn(tag);

        tagService.createTag(tagRequestDto);

        assertEquals(0, tagService.findTags().get(0).getId());
        assertEquals(tagName, tagService.findTags().get(0).getName());
    }

    @Test
    void tag만들기_중복_에러() {
        String tagName = "Tag";
        TagRequestDto tagRequestDto = new TagRequestDto();
        tagRequestDto.setTagName(tagName);
        Tag tag = new Tag();
        tag.of(tagRequestDto);

        Mockito.when(tagRepository.findByTagName("Tag"))
                .thenReturn(List.of(tag));

        Assertions.assertThrows(TagNameDuplicateException.class, ()->tagService.createTag(tagRequestDto));
    }

    @Test
    void tagList가져오기_성공() {
        Tag tag1 = new Tag();
        Tag tag2 = new Tag();
        Tag tag3 = new Tag();

        tag1.setTagName("Tag1");
        tag2.setTagName("Tag2");
        tag3.setTagName("Tag3");

        Mockito.when(tagRepository.findAll())
                        .thenReturn(List.of(tag1, tag2, tag3));

        System.out.println(tagService.findTags());
        List<TagResponseDto> result = tagService.findTags();

        System.out.println("tagser = " + tagService);

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("Tag1", result.get(0).getName());

    }

    @Test
    void TagName을_TagId로_변환() {
        Tag tag = new Tag();
        tag.setTagName("Tag");
        tag.setId(1L);

        Mockito.when(tagRepository.findByTagName("Tag"))
                .thenReturn(List.of(tag));

        Long tagId = tagService.convertTagNametoId("Tag");

        Assertions.assertEquals(1L, tagId);

    }

    @Test
    void TagId를_TagName으로_변환() {
        Tag tag = new Tag();
        tag.setTagName("Tag");
        tag.setId(1L);

        Mockito.when(tagRepository.findById(1L))
                .thenReturn(Optional.of(tag));

        String tagName = tagService.convertTagIdtoName(1L);
        Assertions.assertEquals("Tag", tagName);

    }

}