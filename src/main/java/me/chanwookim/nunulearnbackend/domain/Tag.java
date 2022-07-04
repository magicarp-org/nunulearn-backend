package me.chanwookim.nunulearnbackend.domain;

import me.chanwookim.nunulearnbackend.dto.TagRequestDto;
import me.chanwookim.nunulearnbackend.dto.TagResponseDto;

import javax.persistence.*;

@Entity
public class Tag extends BaseEntity{
    private String tagName;

    public void of(TagRequestDto requestDto) {
        tagName = requestDto.getTagName();
    }

    public TagResponseDto toResponseDto() {
        TagResponseDto tagResponseDto = new TagResponseDto();
        tagResponseDto.setName(tagName);
        tagResponseDto.setId(getId());
        return tagResponseDto;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}

