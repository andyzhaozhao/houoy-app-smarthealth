package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class HobbyVO extends SuperVO {
    private String pk_hobby;
    private String hobby_code;
    private String hobby_name;
    private String hobby_desc;
    private String pk_person;//提出此爱好的用户
    private String ts;

    @Override
    public String getPKField() {
        return "pk_hobby";
    }

    @Override
    public String getTableName() {
        return "im_hobby";
    }

    @Override
    public Object getPKValue() {
        return pk_hobby;
    }
}
