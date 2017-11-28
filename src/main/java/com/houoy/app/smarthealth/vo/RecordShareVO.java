package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户分享状态记录
 * Created by andzhao on 2017/10/24.
 */
@Data
@NoArgsConstructor
public class RecordShareVO extends SuperVO {

    @ApiModelProperty(required = false,hidden = true)
    private String pk_record_share;
    @ApiModelProperty(value = "编码", example = "1",hidden = false)
    private String record_share_code;
    @ApiModelProperty(value = "名称", example = "name",hidden = false)
    private String record_share_name;
    @ApiModelProperty(value = "描述HTML格式", example = "<html><title></title><body>分享内容</body></html>", hidden = false)
    private String record_share_desc;
    @ApiModelProperty(hidden = true)
    private byte[] record_share_img;
    @ApiModelProperty(value = "人pk",example = "1",hidden = false)
    private String pk_person;
    @ApiModelProperty(value = "人员名称", example = "1",hidden = false)
    private String person_name;

    //冗余字段
    @ApiModelProperty(value = "是否已经关注此条记录的作者.1为是，0为否", example = "1",hidden = false)
    private String has_follow;

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

