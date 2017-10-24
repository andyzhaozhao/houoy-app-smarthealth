package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.TreeVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地点管理
 */
@Data
@NoArgsConstructor
public class PlaceVO extends TreeVO<PlaceVO> {

    @ApiModelProperty(required = false)
    private String pk_place;
    @ApiModelProperty(value = "地址编码",example = "userid",required = true)
    private String place_code;
    @ApiModelProperty(value = "地址名称",example = "userid",required = true)
    private String place_name;
    @ApiModelProperty(value = "地址描述",example = "userid",required = false)
    private String place_desc;
    @ApiModelProperty(value = "父地址pk",example = "userid",required = true)
    private String pk_parent;

    //冗余字段
    private String text;

    @Override
    public String getPKField() {
        return "pk_place";
    }

    @Override
    public String getTableName() {
        return "im_place";
    }

    @Override
    public String getParentPKField() {
        return "pk_parent";
    }

    @Override
    public Object getPKValue() {
        return pk_place;
    }
}
