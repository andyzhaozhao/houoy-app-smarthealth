package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.TreeVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地点管理
 */
@Data
@NoArgsConstructor
public class PlaceVO extends TreeVO<PlaceVO> {
    private String pk_place;
    private String place_code;
    private String place_name;
    private String place_desc;
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
