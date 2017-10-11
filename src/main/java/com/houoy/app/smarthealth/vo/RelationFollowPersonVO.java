package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人员关注人员关系表
 *
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class RelationFollowPersonVO extends SuperVO {
    private String pk_relfp;
    private String pk_person;
    private String follow_pk_person;
    private Integer effective;//if has canceled follow
    private String ts;

    //redundancy fields
    private String person_name;
    private String follow_person_name;

    @Override
    public String getPKField() {
        return "pk_relfp";
    }

    @Override
    public String getTableName() {
        return "im_person_follow";
    }

    @Override
    public Object getPKValue() {
        return pk_relfp;
    }
}
