package com.arahansa.domain;

import lombok.Data;

/**
 * Created by kangyong on 2016-08-27.
 */
@Data
public class DataTableReq {
  private int draw;
  private int start;
  private int length;
}

