package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动表，等待，正在进行，结束，如果活动完成，则进活动成功表，活动失败表（未报名）
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class RelationActivityVO extends SuperVO {
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
