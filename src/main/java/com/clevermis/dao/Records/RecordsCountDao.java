package com.clevermis.dao.Records;

import com.clevermis.entity.Records;
import java.util.List;
import java.util.Map;

/**
 * @program: YouthWork
 * @description:
 * @author: Clevermis
 * @create: 2023-01-08 17:42
 **/
public interface RecordsCountDao {

  /**
   * @param form_id
   * @methodname getrecords  的功能描述 TODO:输出记录ID对应的表单
   * @Param: * @param records
   * @return: java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
   * @throw:
   * @Author: Clevermis
   * @version: V1.0.0
   * @Date: 2023/1/8 21:16
   */
  List<Map<String, Object>> getrecords(Records records, int form_id);
}
