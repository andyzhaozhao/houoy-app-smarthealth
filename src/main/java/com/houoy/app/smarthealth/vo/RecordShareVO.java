package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户分享状态记录
 * Created by andzhao on 2017/10/24.
 */
public class RecordShareVO extends SuperVO {

    @ApiModelProperty(required = false)
    private String pk_record_share;
    @ApiModelProperty(value = "编码", required = true)
    private String record_share_code;
    @ApiModelProperty(value = "名称", example = "name", required = true)
    private String record_share_name;
    @ApiModelProperty(value = "描述HTML格式", example = "desc", required = true)
    private String record_share_desc;

    @ApiModelProperty(value = "人pk",required = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", required = true)
    private String person_name;


    @Override
    public String getPKField() {
        return "pk_record_share";
    }

    @Override
    public String getTableName() {
        return "record_share";
    }

    @Override
    public Object getPKValue() {
        return pk_record_share;
    }
}

