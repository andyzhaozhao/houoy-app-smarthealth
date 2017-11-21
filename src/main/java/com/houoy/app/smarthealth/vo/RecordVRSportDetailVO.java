package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 运动记录详细信息
 * Created by iandtop on 2017/10/24.
 */
@Data
@NoArgsConstructor
public class RecordVRSportDetailVO extends SuperVO {

    @ApiModelProperty(required = false, hidden = true)
    private String pk_sport_detail;
    @ApiModelProperty(value = "编码", example = "1", hidden = false)
    private String sport_detail_code;
    @ApiModelProperty(value = "名称", example = "1", hidden = false)
    private String sport_detail_name;

    @ApiModelProperty(value = "人pk", example = "1", hidden = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", example = "1", hidden = false)
    private String person_name;

    @ApiModelProperty(value = "运动地点pk", example = "1", hidden = false)
    private String pk_place;
    @ApiModelProperty(value = "运动地点名称", example = "1", hidden = false)
    private String place_name;

    @ApiModelProperty(value = "运动视频pk", example = "1", hidden = false)
    private String pk_video;
    @ApiModelProperty(value = "运动视频名称", example = "1", hidden = false)
    private String video_name;

    @ApiModelProperty(value = "运动开始时间", example = "2017-10-25 09:09:09", hidden = false)
    private String timestamp;
    @ApiModelProperty(value = "心率(次/秒)", example = "128", hidden = false)
    private String heart;
    @ApiModelProperty(value = "消耗的卡路里(卡）", example = "555", hidden = false)
    private String calorie;

    @Override
    public String getPKField() {
        return "pk_sport_detail";
    }

    @Override
    public String getTableName() {
        return "sport_detail";
    }

    @Override
    public Object getPKValue() {
        return pk_sport_detail;
    }
}

