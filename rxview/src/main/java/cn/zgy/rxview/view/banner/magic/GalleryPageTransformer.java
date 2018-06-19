package cn.zgy.rxview.view.banner.magic;

import android.os.Build;
import android.view.View;

import cn.zgy.rxview.view.banner.view.BannerViewPager;


/**
 * 实现画廊效果 - PageTransformer
 *
 * @author a_liYa
 * @date 2018/3/6 09:51.
 */
public class GalleryPageTransformer implements BannerViewPager.PageTransformer {

    private float mMaxScale;
    private float mMinScale;
    private int mPageMargin;
    private BannerViewPager mViewPager;

    public GalleryPageTransformer(BannerViewPager viewPager, int pageMargin,
                                  float maxScale, float minScale) {
        mMaxScale = maxScale;
        mMinScale = minScale;
        mPageMargin = pageMargin;
        mViewPager = viewPager;
        viewPager.setOffscreenPageLimit(3);
    }

    @Override
    public void transformPage(View page, float position) {
        final int marginPixels = Math.round(mPageMargin -
                (mMaxScale - mMinScale) * getClientWidth(mViewPager) / 2f);
        if (marginPixels != mViewPager.getPageMargin()) {
            mViewPager.post(new Runnable() {
                @Override
                public void run() {
                    mViewPager.setPageMargin(marginPixels);
                }
            });
        }

        if (page.getParent() instanceof View) {
            View parent = (BannerViewPager) page.getParent();
            int scrollX = parent.getScrollX();
            /**
             * 参考自{@link BannerViewPager#onPageScrolled(int, float, int)}
             */
            position = (float) (page.getLeft() - parent.getPaddingLeft() - scrollX) /
                    getClientWidth(parent);
        }

        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        // 范围 [0, 1]
        float progress = Math.abs(position);

        float scaleValue = mMaxScale - (mMaxScale - mMinScale) * progress;

        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            page.getParent().requestLayout();
        }

    }

    private float getClientWidth(View view) {
        return view.getMeasuredWidth() - view.getPaddingLeft() - view.getPaddingRight();
    }

}
