package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class CoinVO extends SuperVO {
    private String pk_coin;
    private String coin_code;
    private String coin_name;
    private Long coin;//积分
    private String pk_person;//钱包属于谁
    private String ts;

    @Override
    public String getPKField() {
        return "pk_coin";
    }

    @Override
    public String getTableName() {
        return "im_coin";
    }

    @Override
    public Object getPKValue() {
        return pk_coin;
    }
}
