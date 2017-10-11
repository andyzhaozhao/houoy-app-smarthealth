package com.houoy.app.smarthealth.vo;

import com.houoy.common.vo.SuperVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 充值记录VO
 *
 * @author andyzhao
 */
@Data
@NoArgsConstructor
public class CoinRechargeVO extends SuperVO {
    private String pk_recharge;
    private String recharge_code;
    private String recharge_name;
    private Long recharge_money;//充值的钱，单位：分
    private Long recharge_coin;//充值的积分
    private Long coin;//当前总积分
    private String pk_person;//钱包属于谁
    private String ts;

    @Override
    public String getPKField() {
        return "pk_recharge";
    }

    @Override
    public String getTableName() {
        return "im_coin_recharge";
    }

    @Override
    public Object getPKValue() {
        return pk_recharge;
    }
}
