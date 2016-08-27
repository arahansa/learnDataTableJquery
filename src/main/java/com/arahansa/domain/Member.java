package com.arahansa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kangyong on 2016-08-27.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  public Member(String name){
    this.name = name;
  }

}
