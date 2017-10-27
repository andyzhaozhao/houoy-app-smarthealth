package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by iandtop on 2017/10/24.
 */
@Data
@NoArgsConstructor
public class RecordVRSportVO extends SuperVO {

    @ApiModelProperty(required = false,hidden = true)
    private String pk_record_sport;
    @ApiModelProperty(value = "编码", example = "1",hidden = false)
    private String record_sport_code;
    @ApiModelProperty(value = "名称", example = "1",hidden = false)
    private String record_sport_name;

    @ApiModelProperty(value = "人pk",example = "1",hidden = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", example = "1",hidden = false)
    private String person_name;

    @ApiModelProperty(value = "运动地点pk",example = "1",hidden = false)
    private String pk_place;
    @ApiModelProperty(value = "运动地点名称", example = "1",hidden = false)
    private String place_name;

    @ApiModelProperty(value = "运动视频pk", example = "1",hidden = false)
    private String pk_video;
    @ApiModelProperty(value = "运动视频名称", example = "1",hidden = false)
    private String video_name;

    @ApiModelProperty(value = "运动开始时间", example = "2017-10-25 09:09:09",hidden = false)
    private String time_start;
    @ApiModelProperty(value = "运动结束时间", example = "2017-10-25 09:09:09",hidden = false)
    private String time_end;
    @ApiModelProperty(value = "运动时长（秒）", example = "300",hidden = false)
    private String time_length;

    @ApiModelProperty(value = "平均心率(次/秒)", example = "100",hidden = false)
    private String heart_rate;
    @ApiModelProperty(value = "最大心率(次/秒)", example = "128",hidden = false)
    private String heart_rate_max;
    @ApiModelProperty(value = "消耗的卡路里(卡）", example = "555",hidden = false)
    private String calorie;

    //冗余字段
    @ApiModelProperty(value = "指标查询字段:运动时间的起始值，如：2017-10-25 09:09:09", example = "2017-10-25 09:09:09",hidden = false)
    private String indicator_time_start;
    @ApiModelProperty(value = "指标查询字段:运动时间的终止值，如：2018-10-25 09:09:09", example = "2018-10-25 09:09:09",hidden = false)
    private String indicator_time_end;
    @ApiModelProperty(value = "指标查询字段：平均心率的最小值", example = "67",hidden = false)
    private String indicator_heart_rate_min;
    @ApiModelProperty(value = "指标查询字段：平均心率的最大值", example = "168",hidden = false)
    private String indicator_heart_rate_max;
    @ApiModelProperty(value = "指标查询字段：最大心率的最小值", example = "67",hidden = false)
    private String indicator_heart_rate_max_min;
    @ApiModelProperty(value = "指标查询字段：最大心率的最大值", example = "168",hidden = false)
    private String indicator_heart_rate_max_max;
    @ApiModelProperty(value = "指标查询字段：消耗的卡路里最小值", example = "10",hidden = false)
    private String indicator_calorie_min;
    @ApiModelProperty(value = "指标查询字段：消耗的卡路里最大值", example = "500",hidden = false)
    private String indicator_calorie_max;

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

