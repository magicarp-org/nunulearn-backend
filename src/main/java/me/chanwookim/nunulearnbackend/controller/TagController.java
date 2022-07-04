package me.chanwookim.nunulearnbackend.controller;

import me.chanwookim.nunulearnbackend.domain.Tag;
import me.chanwookim.nunulearnbackend.dto.TagRequestDto;
import me.chanwookim.nunulearnbackend.dto.TagResponseDto;
import me.chanwookim.nunulearnbackend.exception.TagNameDuplicateException;
import me.chanwookim.nunulearnbackend.repository.TagRepository;
import me.chanwookim.nunulearnbackend.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    List<TagResponseDto> tagList() {
        return tagService.findTags();
    }

    @PostMapping
    TagResponseDto addTag(TagRequestDto tagRequestDto) {
        Tag tag = new Tag();
        tag.of(tagRequestDto);
        TagResponseDto response = tagService.createTag(tagRequestDto);
        return response;
    }

}

