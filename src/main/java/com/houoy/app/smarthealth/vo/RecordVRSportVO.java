package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by iandtop on 2017/10/24.
 */
public class RecordVRSportVO extends SuperVO {

    @ApiModelProperty(required = false)
    private String pk_record_sport;
    @ApiModelProperty(value = "编码", required = true)
    private String record_sport_code;
    @ApiModelProperty(value = "名称", example = "name", required = true)
    private String record_sport_name;

    @ApiModelProperty(value = "人pk",required = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", required = true)
    private String person_name;

    @ApiModelProperty(value = "运动地点pk",required = false)
    private String pk_place;
    @ApiModelProperty(value = "运动地点名称", required = true)
    private String place_name;

    @ApiModelProperty(value = "运动视频pk", required = false)
    private String pk_video;
    @ApiModelProperty(value = "运动视频名称", required = true)
    private String video_name;

    @ApiModelProperty(value = "运动开始时间", required = true)
    private String time_start;
    @ApiModelProperty(value = "运动结束时间", required = true)
    private String time_end;
    @ApiModelProperty(value = "运动时长", required = true)
    private String time_length;

    @ApiModelProperty(value = "平均心率", required = true)
    private String heart_rate;
    @ApiModelProperty(value = "最大心率", required = true)
    private String heart_rate_max;
    @ApiModelProperty(value = "消耗的卡路里", required = false)
    private String calorie;


    @Override
    public String getPKField() {
        return "pk_record_sport";
    }

    @Override
    public String getTableName() {
        return "record_sport";
    }

    @Override
    public Object getPKValue() {
        return pk_record_sport;
    }
}

