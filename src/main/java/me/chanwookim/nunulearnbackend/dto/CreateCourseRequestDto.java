package me.chanwookim.nunulearnbackend.dto;

import me.chanwookim.nunulearnbackend.domain.Category;
import me.chanwookim.nunulearnbackend.domain.Tag;

import java.util.List;

public class CreateCourseRequestDto {
    private String title;
    private String thumbnailUrl;
    private int price;
    private Category category;
    private String description;

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
