package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户阅读文章记录
 * Created by andzhao on 2017/10/24.
 */
public class RecordEssayVO extends SuperVO {

    @ApiModelProperty(required = false)
    private String pk_record_essay;
    @ApiModelProperty(value = "编码", required = true)
    private String record_essay_code;
    @ApiModelProperty(value = "名称", example = "name", required = true)
    private String record_essay_name;

    @ApiModelProperty(value = "人pk", required = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", required = true)
    private String person_name;

    @ApiModelProperty(value = "文章pk", required = false)
    private String pk_essay;
    @ApiModelProperty(value = "文章名称", required = true)
    private String essay_name;

    @ApiModelProperty(value = "阅读时长", required = true)
    private String time_length;

    @Override
    public String getPKField() {
        return "pk_record_essay";
    }

    @Override
    public String getTableName() {
        return "record_essay";
    }

    @Override
    public Object getPKValue() {
        return pk_record_essay;
    }
}

