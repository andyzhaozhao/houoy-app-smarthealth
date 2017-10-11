package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单表
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class OrderVO extends SuperVO {
    private String pk_order;
    private String pk_person;
    private String pk_essay;
    private String total;//金额
    private String ts;

    @Override
    public String getPKField() {
        return "pk_person";
    }

    @Override
    public String getTableName() {
        return "im_person";
    }

    @Override
    public Object getPKValue() {
        return pk_order;
    }
}
