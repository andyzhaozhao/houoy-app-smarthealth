package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class RoleVO extends SuperVO {
    private String pk_role;
    private String pk_corp;
    private String role_code;
    private String role_name;

    @Override
    public String getPKField() {
        return "pk_role";
    }

    @Override
    public String getTableName() {
        return "sm_role";
    }

    @Override
    public Object getPKValue() {
        return pk_role;
    }
}
