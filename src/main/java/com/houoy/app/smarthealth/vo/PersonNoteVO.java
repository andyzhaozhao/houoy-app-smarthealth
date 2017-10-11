package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class PersonNoteVO extends SuperVO {
    private String pk_note;
    private String note_code;
    private String note_alias;
    private String note_name;
    private String note_desc;
    private String auth;//1 all  2 follow 3 private
    private String indicator1;
    private String indicator2;
    private String indicator3;
    private String indicator4;
    private String indicator5;

    private String pk_person;//who's note
    private String img1;
    private String img2;
    private String img3;

    private String ts;

    @Override
    public Object getPKValue() {
        return pk_note;
    }

    @Override
    public String getPKField() {
        return "pk_note";
    }


    @Override
    public String getTableName() {
        return "im_person_note";
    }
}
