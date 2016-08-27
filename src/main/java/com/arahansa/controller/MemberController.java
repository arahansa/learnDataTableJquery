package com.arahansa.controller;

import com.arahansa.domain.DataTableReq;
import com.arahansa.domain.Member;
import com.arahansa.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import ognl.DynamicSubscript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static ognl.DynamicSubscript.all;

/**
 * Created by kangyong on 2016-08-27.
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

  @Autowired
  MemberRepository memberRepository;


  @PostConstruct
  public void init(){
    IntStream.rangeClosed(0, 20).forEach(n->{
      memberRepository.save(new Member("최강용"+n));
      memberRepository.save(new Member("최강철"+n));
      memberRepository.save(new Member("최강드래곤"+n));
    });
  }

  @PersistenceContext
  private EntityManager entityManager;


  @RequestMapping("/list")
  public Map<String, Object> list(DataTableReq dataTableReq){
    log.debug("dataTableReq: {}", dataTableReq);
    Map<String, Object> resultMap = new HashMap<>();

    final List<Member> all = getTeamFromPathExpression(dataTableReq.getStart(), dataTableReq.getLength());
    log.debug("all : {}", all);
    final long count = memberRepository.count();
    resultMap.put("recordsTotal", count);
    resultMap.put("recordsFiltered", count);
    resultMap.put("data", all);
    resultMap.put("draw", dataTableReq.getDraw());
    return resultMap;
  }

  public List<Member> getTeamFromPathExpression(int startPosition, int maxLength){
    String jpql = "select m from Member m";
    final TypedQuery<Member> typedQuery = entityManager.createQuery(jpql, Member.class);
    typedQuery.setFirstResult(startPosition);
    typedQuery.setMaxResults(maxLength);
    return typedQuery.getResultList();
  }

}

