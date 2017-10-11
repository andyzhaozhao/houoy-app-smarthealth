package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人员关注产品关系表
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class RelationFollowEssayVO extends SuperVO {
    private String pk_person;
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
