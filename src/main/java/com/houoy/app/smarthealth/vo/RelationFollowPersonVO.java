package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(required = false,hidden = true)
    private String pk_relfp;
    @ApiModelProperty(value = "用户pk", example = "name",hidden = false)
    private String pk_person;
    @ApiModelProperty(value = "被关注用户pk", example = "name",hidden = false)
    private String follow_pk_person;
    @ApiModelProperty(required = false,hidden = true)
    private Integer effective;//if has canceled follow
    @ApiModelProperty(required = false,hidden = true)
    private String ts;

    //redundancy fields
    @ApiModelProperty(value = "用户名", example = "name",hidden = false)
    private String person_name;
    @ApiModelProperty(value = "被关注用户名", example = "name",hidden = false)
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
