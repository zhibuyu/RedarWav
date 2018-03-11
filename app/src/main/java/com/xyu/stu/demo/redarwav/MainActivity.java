package com.xyu.stu.demo.redarwav;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<FoudItemBeam> datas;
    RippleBackground rippleBackground;
    ImageView button;
    private ImageView founditem1, founditem2, founditem3, founditem4, founditem5, founditem6, founditem7, founditem8, founditem9, founditem10;
    List<ImageView> imageViews;
    List<Integer> ImageView_indexs;//随机后的下标集合
    List<ImageView> showImageViews;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rippleBackground = (RippleBackground) findViewById(R.id.content);
        button = (ImageView) findViewById(R.id.centerImage);
        handler = new Handler();
        datas = new ArrayList<FoudItemBeam>();
        founditem1 = (ImageView) findViewById(R.id.founditem1);
        founditem2 = (ImageView) findViewById(R.id.founditem2);
        founditem3 = (ImageView) findViewById(R.id.founditem3);
        founditem4 = (ImageView) findViewById(R.id.founditem4);
        founditem5 = (ImageView) findViewById(R.id.founditem5);
        founditem6 = (ImageView) findViewById(R.id.founditem6);
        founditem7 = (ImageView) findViewById(R.id.founditem7);
        founditem8 = (ImageView) findViewById(R.id.founditem8);
        founditem9 = (ImageView) findViewById(R.id.founditem9);
        founditem10 = (ImageView) findViewById(R.id.founditem10);
        ImageView_indexs=new ArrayList<Integer>();
        imageViews = new ArrayList<ImageView>();
        showImageViews = new ArrayList<ImageView>();
        imageViews.add(founditem1);
        imageViews.add(founditem2);
        imageViews.add(founditem3);
        imageViews.add(founditem4);
        imageViews.add(founditem5);
        imageViews.add(founditem6);
        imageViews.add(founditem7);
        imageViews.add(founditem8);
        imageViews.add(founditem9);
        imageViews.add(founditem10);

        datas.add(new FoudItemBeam("101","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2833170359,1500593660&fm=11&gp=0.jpg"));
        datas.add(new FoudItemBeam("102","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=327616603,1692478365&fm=27&gp=0.jpg"));
        datas.add(new FoudItemBeam("103","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3394601552,878024322&fm=27&gp=0.jpg"));
        datas.add(new FoudItemBeam("104","https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=889831674,38236601&fm=27&gp=0.jpg"));
        datas.add(new FoudItemBeam("105","https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2774434897,1587008990&fm=27&gp=0.jpg"));
        datas.add(new FoudItemBeam("106","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1343711917,506615306&fm=27&gp=0.jpg"));
//        datas.add(new FoudItemBeam("107","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2629407689,400440485&fm=27&gp=0.jpg"));
//        datas.add(new FoudItemBeam("108","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3474194472,3615724314&fm=27&gp=0.jpg"));
//        datas.add(new FoudItemBeam("109","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2906093720,3293118713&fm=27&gp=0.jpg"));
//        datas.add(new FoudItemBeam("110","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3117759552,2550768390&fm=27&gp=0.jpg"));
        initEvent();
    }

    private void initEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rippleBackground.startRippleAnimation();
                Clean();
                Show(datas);
            }
        });

    }

    private boolean IsContain(List<Integer> datas, int data) {
        for (int i = 0; i < datas.size(); i++) {
            if (data == datas.get(i)) {
                return true;
            }
        }
        return false;
    }

    private void Show(List<FoudItemBeam> datas) {
        ImageView_indexs.clear();
        ImageView_indexs = randomCommon(0, 10, datas.size());
        showImageViews.clear();
        for (int i = 0; i < imageViews.size(); i++) {
            final ImageView imageView = imageViews.get(i);
            if (IsContain(ImageView_indexs, i)) {
                showImageViews.add(imageView);
            } else {
                imageView.setVisibility(View.GONE);
            }
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ShowImageView();
            }
        }, 2000);
    }

    private void ShowImageView() {
        for (int i = 0; i < showImageViews.size(); i++) {
            final int finalI = i;
            showImageViews.get(finalI).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, datas.get(finalI).getId(), Toast.LENGTH_SHORT).show();
                }
            });
            RequestOptions myOptions = new RequestOptions()
                    .transform(new GlideCircleTransform(MainActivity.this))
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);
            Glide.with(MainActivity.this).load(datas.get(finalI).getHead_url())
                    .apply(myOptions)
                    .into(showImageViews.get(i));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    founditem(showImageViews.get(finalI));
                }
            }, 500);
        }

    }



    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public List<Integer> randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < result.size(); j++) {
                if (num == result.get(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(num);
                count++;
            }
        }
        return result;
    }

    private void Clean(){
        for(ImageView imageView:showImageViews){
            imageView.clearAnimation();
            imageView.setVisibility(View.GONE);
        }

    }
    private void founditem(ImageView imageView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ArrayList<Animator> animatorList = new ArrayList<Animator>();
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imageView, "ScaleX", 0f, 1.2f, 1f);
        animatorList.add(scaleXAnimator);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imageView, "ScaleY", 0f, 1.2f, 1f);
        animatorList.add(scaleYAnimator);
        animatorSet.playTogether(animatorList);
        imageView.setVisibility(View.VISIBLE);
        animatorSet.start();
    }
}
