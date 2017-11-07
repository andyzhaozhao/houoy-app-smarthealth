package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 图片上上传vo
 */
@Data
@NoArgsConstructor
public class PersonImageVO extends SuperVO {

    @ApiModelProperty(required = true)
    private String pk_person;
    @ApiModelProperty(value = "图片的base64字符串", example = "aaaabb001010201", required = true)
    private String image;

    @Override
    public String getPKField() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public Object getPKValue() {
        return null;
    }
}
