package com.logistics.jubao.videodemo;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class VideoItemAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {
    public VideoItemAdapter(@LayoutRes int layoutResId, @Nullable List<VideoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBean item) {
        helper.setText(R.id.tv_name, item.getName());

    }
}
