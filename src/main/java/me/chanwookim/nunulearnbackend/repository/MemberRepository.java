package me.chanwookim.nunulearnbackend.repository;

import me.chanwookim.nunulearnbackend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
