package com.hencoder.hencoderpracticelayout1.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * 需要把它写成正方形的 ImageView
 */
public class Practice02SquareImageView extends ImageView {
    private static final String TAG = "Practice02SquareImageVi";

    public Practice02SquareImageView(Context context) {
        super(context);
    }

    public Practice02SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 限制来源: layout_xxx
     *
     * @param widthMeasureSpec  父 View 对子 View 宽度限制,压缩数据，包含限制对类型与尺寸值
     * @param heightMeasureSpec 父 View 对子 View 高度限制
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 首先保存默认的尺寸

        // 先用 getMeasuredWidth() 和 getMeasuredHeight() 取到 super.onMeasure() 的计算结果
        int width = 200;
        int height = 300;
        //以上是你想要对尺寸, 以下是修正对尺寸
        width = resolveSize(width, widthMeasureSpec);
        height = resolveSize(height, heightMeasureSpec);
        // 在 resolveSizeAndState 计算不同限制下的尺寸值
        Log.d(TAG, "onMeasure: width= " + width + ",height= " + height);
        // 再用 setMeasuredDimension(width, height) 来保存最终的宽度和高度
        setMeasuredDimension(width, height);
    }
}
