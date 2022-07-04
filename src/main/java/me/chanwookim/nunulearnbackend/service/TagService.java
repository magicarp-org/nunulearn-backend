package me.chanwookim.nunulearnbackend.service;

import me.chanwookim.nunulearnbackend.domain.Tag;
import me.chanwookim.nunulearnbackend.dto.TagRequestDto;
import me.chanwookim.nunulearnbackend.dto.TagResponseDto;
import me.chanwookim.nunulearnbackend.exception.TagNameDuplicateException;
import me.chanwookim.nunulearnbackend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(final TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    //태그 목록
    public List<TagResponseDto> findTags() {
        return tagRepository.findAll().stream()
                .map(tag -> tag.toResponseDto())
                .collect(Collectors.toList());
    }

    //태그 등록
    public TagResponseDto createTag(TagRequestDto tagRequest) {
        Tag tag = new Tag();
        tag.setTagName(tagRequest.getTagName());

        if (tagRepository.findByTagName(tagRequest.getTagName()).size() != 0) {
            System.out.println("tag name duplicate");
            throw new TagNameDuplicateException();
        }

        Tag result = tagRepository.save(tag);

        System.out.println("result = " + tagRepository.findAll().stream().map(tag1 -> tag1.getTagName()).collect(Collectors.toList()));
        return result.toResponseDto();
    }

    public String convertTagIdtoName(Long id) {
        return tagRepository.findById(id).get().getTagName();
    }

    public Long convertTagNametoId(String name) {
        return tagRepository.findByTagName(name).get(0).getId();
    }
}
