package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class PersonVO extends SuperVO {
    private String pk_person;
    private String person_code;
    private String person_alias;
    private String person_name;
    private String password;
    private String mobile;
    private String email;
    private String identity;
    private String age;
    private String address;
    private String birthday;
    private String birthplace;
    private String country;
    private String province;
    private String city;
    private String town;
    private String village;
    private String education;
    private String job;
    private String income;
    private String has_house;
    private String has_car;
    private String marriage;
    private String emotion_count;
    private String mate_type;
    private String habbit;
    private String family;
    private String health;
    private String single_long;
    private String enable_marriagetime;
    private String idea_love;
    private String idea_value;
    private String idea_goal;
    private String idea_swear;

    private String img1_comment;
    private String img2_comment;
    private String img3_comment;
    private String img4_comment;
    private String img5_comment;

    private byte[] portrait;
    private byte[] img1;
    private byte[] img2;
    private byte[] img3;
    private byte[] img4;
    private byte[] img5;
    private String safe_state;

    @Override
    public Object getPKValue() {
        return pk_person;
    }

    @Override
    public String getPKField() {
        return "pk_person";
    }


    @Override
    public String getTableName() {
        return "im_person";
    }
}
