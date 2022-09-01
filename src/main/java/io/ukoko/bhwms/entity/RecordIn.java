package io.ukoko.bhwms.entity;

import java.util.Date;

/**
 * 映射数据库record_in(入库记录表)表
 */
public class RecordIn {
  /*
    入库ID
   */
  private Integer recordInId;
  /*

   */
  private Integer supplierId;
  private Integer productId;
  private Integer recordInNumber;
  private Date recordInTime;
  private Integer userId;
  private Integer repoId;
  private String remarks;


}
