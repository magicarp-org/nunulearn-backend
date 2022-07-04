package me.chanwookim.nunulearnbackend.domain;

import me.chanwookim.nunulearnbackend.dto.CourseResponseDto;
import me.chanwookim.nunulearnbackend.dto.CreateCourseRequestDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "course")
public class Course extends BaseEntity{
    private String title;
    private String thumbnailUrl;
    private int price;
    @OneToOne
    private Member author;
    private Category category;
    @OneToMany
    private List<Tag> tag;
    private String description;
    private String keyword;

    public void of(CreateCourseRequestDto courseRequestDto) {
        title = courseRequestDto.getTitle();
        thumbnailUrl = courseRequestDto.getThumbnailUrl();
        price = courseRequestDto.getPrice();
        category = courseRequestDto.getCategory();
        description = courseRequestDto.getDescription();
        this.setUpdated_at(LocalDateTime.now());
    }


    public String getTagToString() {
        return tag.stream()
                .map(tag -> tag.getTagName())
                .collect(Collectors.toList())
                .toString();
    }


    public CourseResponseDto toResponseDto() {
        CourseResponseDto response = new CourseResponseDto();
        response.setTitle(title);
        response.setThumbnailUrl(thumbnailUrl);
        response.setPrice(price);
        response.setAuthor(author);
        response.setDescription(description);
        response.setKeyword(keyword);
        return response;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
