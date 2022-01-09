package com.yipeng.liu.designpattern.meituan;

import com.yipeng.liu.designpattern.meituan.state.exte.CompensateRewardState;
import com.yipeng.liu.designpattern.meituan.state.exte.OrderCheckState;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.designpattern.meituan.state
 * @date 2022/1/7 10:26
 * @Copyright 韵达快递
 */
public class InviteRewardServiceImpl {

    public boolean sendRewardForInvtee(long userId, long orderId) {
        Request request = new Request(userId, orderId);
        RewardStateContext rewardContext = new RewardStateContext();
        rewardContext.setRewardState(new OrderCheckState());
        rewardContext.echo(rewardContext, request);  //开始返奖，订单校验
        //此处的if-else逻辑只是为了表达状态的转换过程，并非实际的业务逻辑
        if (rewardContext.isResultFlag()) {  //如果订单校验成功，进入预返奖状态
            rewardContext.setRewardState(new BeforeRewardCheckState());
            rewardContext.echo(rewardContext, request);
        } else {//如果订单校验失败，进入返奖失败流程，...
            rewardContext.setRewardState(new RewardFailedState());
            rewardContext.echo(rewardContext, request);
            return false;
        }
        if (rewardContext.isResultFlag()) {//预返奖检查成功，进入待返奖流程，...
            rewardContext.setRewardState(new SendRewardState());
            rewardContext.echo(rewardContext, request);
        } else {  //如果预返奖检查失败，进入返奖失败流程，...
            rewardContext.setRewardState(new RewardFailedState());
            rewardContext.echo(rewardContext, request);
            return false;
        }
        if (rewardContext.isResultFlag()) {  //返奖成功，进入返奖结束流程，...
            rewardContext.setRewardState(new RewardSuccessState());
            rewardContext.echo(rewardContext, request);
        } else {  //返奖失败，进入返奖补偿阶段，...
            rewardContext.setRewardState(new CompensateRewardState());
            rewardContext.echo(rewardContext, request);
        }
        if (rewardContext.isResultFlag()) {  //补偿成功，进入返奖完成阶段，...
            rewardContext.setRewardState(new RewardSuccessState());
            rewardContext.echo(rewardContext, request);
        } else {  //补偿失败，仍然停留在当前态，直至补偿成功（或多次补偿失败后人工介入处理）
            rewardContext.setRewardState(new CompensateRewardState());
            rewardContext.echo(rewardContext, request);
        }
        return true;
    }

}
