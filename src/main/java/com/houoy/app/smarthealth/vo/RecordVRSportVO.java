package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by iandtop on 2017/10/24.
 */
public class RecordVRSportVO extends SuperVO {

    @ApiModelProperty(required = false)
    private String pk_record_sport;
    @ApiModelProperty(value = "编码",required = true)
    private String record_sport_code;
    @ApiModelProperty(value = "名称",example = "name",required = true)
    private String record_sport_name;
    @ApiModelProperty(value = "描述",example = "desc",required = true)
    private String record_sport_desc;



    @Override
    public String getPKField() {
        return "pk_record_sport";
    }

    @Override
    public String getTableName() {
        return "im_sport";
    }

    @Override
    public Object getPKValue() {
        return pk_record_sport;
    }
}

