package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 邀请关系表,一个人邀请另一个人，如果两个人互相邀请，则可以进入报名状态
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class RelationInviteVO extends SuperVO {
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
