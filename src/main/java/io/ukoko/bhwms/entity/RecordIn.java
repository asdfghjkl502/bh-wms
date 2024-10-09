package io.ukoko.bhwms.entity;

import lombok.Data;

import java.util.Date;

/**
 * 映射数据库record_in(入库记录表)表
 */
@Data
public class RecordIn {
  /*
    入库ID
   */
  private Integer recordInId;
  /*
    供应商ID
   */
  private Integer supplierId;
  /*
    供应商信息 多对一
   */
  private Supplier supplier;
  /*
    产品ID
   */
  private Integer productId;
  /*
    产品信息 多对一
   */
  private Product product;
  /*
    入库数量
   */
  private Integer recordInNumber;
  /*
    入库时间
   */
  private Date recordInTime;
  /*
    入库负责人ID
   */
  private Integer userId;
  /*
    入库负责人信息 多对一
   */
  private User user;
  /*
    仓库ID
   */
  private Integer repoId;
  /*
    入库仓库信息(多对一)
   */
  private Repository repository;
  /*
    备注
   */
  private String remarks;
  /*
        创建时间
     */
  private Date createTime;
  /*
      更新时间
   */
  private Date updateTime;
  /*
      是否删除 0:删除 1:未删除
   */
  private int isDelete = 1;
}
