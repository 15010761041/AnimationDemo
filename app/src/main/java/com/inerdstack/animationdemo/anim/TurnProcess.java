package com.inerdstack.animationdemo.anim;

import android.util.Log;

/**
 * Created by wangjie on 2016/11/10.
 */

public class TurnProcess {

    private float itemTop;
    private float changeLine;

    public static final int STATE_DARK = 0x01;
    public static final int STATE_DARK_2_LIGHT = 0x02;
    public static final int STATE_LIGHT_2_DARK = 0x3;

    /**
     * 获取变化的状态
     * @param itemTop item到顶部的高度差
     * @param turnLine 动画转变线
     * @param itemHeight item的高度
     * @return
     */
    public static int getState(float itemTop, float turnLine, float itemHeight) {
        if (itemTop <= turnLine || itemTop > (turnLine + 2 * itemHeight)) {
            return STATE_DARK;
        } else if (itemTop > turnLine && itemTop < turnLine + itemHeight) {
            return STATE_DARK_2_LIGHT;
        } else {
            return STATE_LIGHT_2_DARK;
        }
    }

    /**
     * 返回动画完成的进度
     * @param itemTop
     * @param turnLine
     * @param itemHeight
     * @return
     */
    public static int getProcess(float itemTop, float turnLine, float itemHeight) {
        Log.i("anmm", "getProcess--itemTop:" + itemTop + ";turnline:" + turnLine + ";itemHeight:" + itemHeight);
        if (itemTop < turnLine || itemTop > (turnLine + 2 * itemHeight)) {
            Log.i("anmm", "invalid 0");
            return 0;
        } else {
            float percent = (itemTop - turnLine) / (2 * itemHeight);
            return (int) (percent * 100);
        }
    }
}
