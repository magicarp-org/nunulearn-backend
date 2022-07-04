package me.chanwookim.nunulearnbackend.repository;

import me.chanwookim.nunulearnbackend.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByTagName(String name);
}
