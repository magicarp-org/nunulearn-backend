package me.chanwookim.nunulearnbackend.dto;

import me.chanwookim.nunulearnbackend.domain.Category;
import me.chanwookim.nunulearnbackend.domain.Course;
import me.chanwookim.nunulearnbackend.domain.Member;
import me.chanwookim.nunulearnbackend.domain.Tag;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class CourseResponseDto {
    String title;
    String thumbnailUrl;
    int price;
    Member author;
    String description;
    String keyword;
    List<Tag> tag;

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
