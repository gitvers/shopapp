package com.example.shopapp.SubFragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopapp.Adapters.BannerPagerAdapter;
import com.example.shopapp.Adapters.ViewPagerHomeAdapter1;
import com.example.shopapp.Adapters.ViewPagerHomeAdapter2;
import com.example.shopapp.Adapters.ViewPagerHomeAdapter3;
import com.example.shopapp.Models.BannerModel;
import com.example.shopapp.Models.ViewPagerHomeModel1;
import com.example.shopapp.Models.ViewPagerHomeModel2;
import com.example.shopapp.Models.ViewPagerHomeModel3;
import com.example.shopapp.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;


public class Home extends Fragment {

    ViewPager2 viewPager2, subView1, subView2, subView3;
    ArrayList<BannerModel> list;
    BannerPagerAdapter adapter;
    WormDotsIndicator dotsIndicator;
    NestedScrollView nestedScrollView;
    ScrollListener scrollListener;
    Handler sliderHandler = new Handler();
    ArrayList<ViewPagerHomeModel1> imageList;
    ViewPagerHomeAdapter1 viewPagerHomeAdapter1;
    ArrayList<ViewPagerHomeModel2> imagelist2;
    ViewPagerHomeAdapter2 viewPagerHomeAdapter2;
    ArrayList<ViewPagerHomeModel3> imagelist3;
    ViewPagerHomeAdapter3 viewPagerHomeAdapter3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        nestedScrollView = view.findViewById(R.id.scroll);
        viewPager2 = view.findViewById(R.id.banner_pager);
        dotsIndicator = view.findViewById(R.id.dot);
        subView1 = view.findViewById(R.id.view_pager1);
        subView2 = view.findViewById(R.id.view_pager2);
        subView3 = view.findViewById(R.id.view_pager3);

        list = new ArrayList<>();
        imageList = new ArrayList<>();
        imagelist2 = new ArrayList<>();
        imagelist3 = new ArrayList<>();

        //bannerlist
        list.add(new BannerModel(R.drawable.banner));
        list.add(new BannerModel(R.drawable.banner));
        list.add(new BannerModel(R.drawable.banner));
        list.add(new BannerModel(R.drawable.banner));
        list.add(new BannerModel(R.drawable.banner));

        adapter = new BannerPagerAdapter(getContext(), list);
        viewPager2.setAdapter(adapter);
        dotsIndicator.attachTo(viewPager2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);

                if (position == viewPager2.getAdapter().getItemCount() - 1) {
                    // Refresh the ViewPager2
                    viewPager2.setCurrentItem(viewPager2.getAdapter().getItemCount() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            viewPager2.setCurrentItem(0);
                            viewPager2.getAdapter().notifyDataSetChanged();
                        }
                    }, 3000);

                }
            }
        });


        //viewpager-1
        imageList.add(new ViewPagerHomeModel1(R.drawable.funky));
        imageList.add(new ViewPagerHomeModel1(R.drawable.funky));
        imageList.add(new ViewPagerHomeModel1(R.drawable.funky));
        imageList.add(new ViewPagerHomeModel1(R.drawable.funky));
        imageList.add(new ViewPagerHomeModel1(R.drawable.funky));

        viewPagerHomeAdapter1 = new ViewPagerHomeAdapter1(getContext(), imageList, subView1);
        subView1.setAdapter(viewPagerHomeAdapter1);
        subView1.setCurrentItem(1);
        subView1.setOffscreenPageLimit(3);
        subView1.setClipChildren(false);
        subView1.setClipToPadding(false);
        subView1.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(60));
        transformer.addTransformer((page, position1) -> {
            float a = 1 - Math.abs(position1);
            page.setScaleY(0.85f + a * 0.14f);
        });
        subView1.setPageTransformer(transformer);


        //viewpager-2

        imagelist2.add(new ViewPagerHomeModel2(R.drawable.women));
        imagelist2.add(new ViewPagerHomeModel2(R.drawable.women));
        imagelist2.add(new ViewPagerHomeModel2(R.drawable.women));
        imagelist2.add(new ViewPagerHomeModel2(R.drawable.women));
        imagelist2.add(new ViewPagerHomeModel2(R.drawable.women));

        viewPagerHomeAdapter2 = new ViewPagerHomeAdapter2(getContext(), imagelist2, subView2);
        subView2.setAdapter(viewPagerHomeAdapter2);
        subView2.setCurrentItem(1);
        subView2.setOffscreenPageLimit(3);
        subView2.setClipChildren(false);
        subView2.setClipToPadding(false);
        subView2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        subView2.setPageTransformer(transformer);


        //viewpager-3

        imagelist3.add(new ViewPagerHomeModel3(R.drawable.funky));
        imagelist3.add(new ViewPagerHomeModel3(R.drawable.funky));
        imagelist3.add(new ViewPagerHomeModel3(R.drawable.funky));
        imagelist3.add(new ViewPagerHomeModel3(R.drawable.funky));
        imagelist3.add(new ViewPagerHomeModel3(R.drawable.funky));


        viewPagerHomeAdapter3 = new ViewPagerHomeAdapter3(getContext(), imagelist3, subView3);
        subView3.setAdapter(viewPagerHomeAdapter3);
        subView3.setCurrentItem(1);
        subView3.setOffscreenPageLimit(3);
        subView3.setClipChildren(false);
        subView3.setClipToPadding(false);
        subView3.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        subView3.setPageTransformer(transformer);


//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                // Notify the hosting Activity of the scroll direction
//                boolean isScrollingUp = dy > 0;
//                scrollListener.onRecyclerViewScrolled(isScrollingUp);
////                setBottomNavigationVisibility(!isScrollingUp);
//            }
//        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    boolean isScrollingUp = i1 > i3;
                    scrollListener.onRecyclerViewScrolled(isScrollingUp);

                }
            });
        }
        return view;
    }

    public interface ScrollListener {
        void onRecyclerViewScrolled(boolean isScrollingUp);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ScrollListener) {
            scrollListener = (ScrollListener) context;
        } else {
            throw new RuntimeException(context
                    + " must implement ScrollListener");
        }
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000);
    }
}