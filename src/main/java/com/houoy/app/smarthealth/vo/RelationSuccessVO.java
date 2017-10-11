package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动成功表，成功举行一次活动
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class RelationSuccessVO extends SuperVO {
    private String from_pk_person;
    private String to_pk_person;
    private String pk_essay;
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
        return null;
    }
}
