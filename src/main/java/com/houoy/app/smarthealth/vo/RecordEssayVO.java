package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户阅读文章记录
 * Created by andzhao on 2017/10/24.
 */
@Data
@NoArgsConstructor
public class RecordEssayVO extends SuperVO {

    @ApiModelProperty(required = false, hidden = true)
    private String pk_record_essay;
    @ApiModelProperty(value = "编码", example = "1",  hidden = false)
    private String record_essay_code;
    @ApiModelProperty(value = "名称", example = "name",  hidden = false)
    private String record_essay_name;

    @ApiModelProperty(value = "人pk", example = "1",  hidden = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", example = "1",  hidden = false)
    private String person_name;

    @ApiModelProperty(value = "文章pk", example = "1",  hidden = false)
    private String pk_essay;
    @ApiModelProperty(value = "文章名称", example = "1",  hidden = false)
    private String essay_name;

    @ApiModelProperty(value = "阅读时长（秒）", example = "260",  hidden = false)
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

