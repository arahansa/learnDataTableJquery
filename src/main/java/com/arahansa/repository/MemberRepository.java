package com.arahansa.repository;

import com.arahansa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kangyong on 2016-08-27.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
