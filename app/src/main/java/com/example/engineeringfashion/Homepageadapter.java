package com.example.engineeringfashion;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Homepageadapter extends RecyclerView.Adapter {
    private List<Homepagemodel> homepagemodelList;

    public Homepageadapter(List<Homepagemodel> homepagemodelList) {
        this.homepagemodelList = homepagemodelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homepagemodelList.get(position).getType()) {
            case 0:
                return Homepagemodel.Banner_slider;
            case 1:
                return Homepagemodel.stripad;
            case 2:
                return Homepagemodel.dealoftheday;
            case 3:
                return Homepagemodel.gridlayout;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case Homepagemodel.Banner_slider:
                View bannersliderview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bannerslider, viewGroup, false);
                return new BannersliderViewHolder(bannersliderview);
            case Homepagemodel.stripad:
                View stripadview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adbanner, viewGroup, false);
                return new StripadViewHolder(stripadview);
            case Homepagemodel.dealoftheday:
                View dealofthedayview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.deal_of_the_day, viewGroup, false);
                return new DealofthedayViewholder(dealofthedayview);
            case Homepagemodel.gridlayout:
                View gridviewlayoutview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gridlayout_tranding, viewGroup, false);
                return new GridViewLayoutViewHolder(gridviewlayoutview);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (homepagemodelList.get(i).getType()) {
            case Homepagemodel.Banner_slider:
                List<Slider_moder> slider_moderList = homepagemodelList.get(i).getSlider_moderList();
                ((BannersliderViewHolder) viewHolder).setBannersliderviewpager(slider_moderList);
                break;
            case Homepagemodel.stripad:
                int resource = homepagemodelList.get(i).getResource();
                String color = homepagemodelList.get(i).getBackgroundcolor();
                ((StripadViewHolder) viewHolder).setstripad(resource, color);
                break;
            case Homepagemodel.dealoftheday:
               String title=homepagemodelList.get(i).getTitle();
               List<Dealoftheday_model> dealoftheday_modelList=homepagemodelList.get(i).getDealoftheday_modelList();
                ((DealofthedayViewholder) viewHolder).setDealoftheday(dealoftheday_modelList,title);
                break;
            case Homepagemodel.gridlayout:
                String titles=homepagemodelList.get(i).getTitle();
                List<Dealoftheday_model> gridlayoutmodellist=homepagemodelList.get(i).getDealoftheday_modelList();
                ((GridViewLayoutViewHolder) viewHolder).setGridlayout(gridlayoutmodellist,titles);
                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return homepagemodelList.size();
    }

    public class BannersliderViewHolder extends RecyclerView.ViewHolder {
        ViewPager bannersliderviewpager;

        private int curretpage = 2;
        Timer timer;
        Runnable update;
        final private long delaytime = 3000;
        final private long periodtime = 3000;

        public BannersliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannersliderviewpager = itemView.findViewById(R.id.banner_view_pager);


        }

        private void setBannersliderviewpager(final List<Slider_moder> slider_moderList) {
            Slider_adapter slider_adapter = new Slider_adapter(slider_moderList);
            bannersliderviewpager.setAdapter(slider_adapter);
            bannersliderviewpager.setPageMargin(20);
            bannersliderviewpager.setClipToPadding(false);
            bannersliderviewpager.setCurrentItem(curretpage);

            ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    curretpage = i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                    if (i == ViewPager.SCROLL_STATE_IDLE) ;
                    pagelooper(slider_moderList);
                }
            };
            bannersliderviewpager.addOnPageChangeListener(pageChangeListener);
            startbannerSlideShow(slider_moderList);
            bannersliderviewpager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pagelooper(slider_moderList);
                    stopbannerslideshow(slider_moderList);
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startbannerSlideShow(slider_moderList);
                    }

                    return false;
                }
            });

        }

        private void pagelooper(List<Slider_moder> slider_moderList) {
            if (curretpage == slider_moderList.size() - 2) {
                curretpage = 2;
                bannersliderviewpager.setCurrentItem(curretpage, false);

            }
            if (curretpage == 1) {
                curretpage = slider_moderList.size() - 3;
                bannersliderviewpager.setCurrentItem(curretpage, false);
            }
        }

        private void startbannerSlideShow(final List<Slider_moder> slider_moderList) {
            final Handler handler = new Handler();
            update = new Runnable() {
                @Override
                public void run() {
                    bannersliderviewpager.setCurrentItem(curretpage++);
                    if (curretpage >= slider_moderList.size()) {
                        curretpage = 1;
                    }
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            }, delaytime, periodtime);
        }

        private void stopbannerslideshow(List<Slider_moder> slider_moderList) {
            timer.cancel();
        }
    }

    public class StripadViewHolder extends RecyclerView.ViewHolder {
        private ImageView adbanner;
        private ConstraintLayout adwalastrip;

        public StripadViewHolder(@NonNull View itemView) {
            super(itemView);
            adbanner = itemView.findViewById(R.id.stripadimage);
            adwalastrip = itemView.findViewById(R.id.adwalastrip);
        }

        private void setstripad(int resource, String color) {
            adbanner.setImageResource(resource);
            adwalastrip.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class DealofthedayViewholder extends RecyclerView.ViewHolder {
        private Button viewall;
        private TextView titleofdotd;
        private RecyclerView dealoftheday_recycleview;

        public DealofthedayViewholder(@NonNull View itemView) {
            super(itemView);
            dealoftheday_recycleview = itemView.findViewById(R.id.dealoftheday_recycleview);
            viewall = itemView.findViewById(R.id.daeloftheday_viewmore);
            titleofdotd = itemView.findViewById(R.id.daeloftheday_title);
        }

        private void setDealoftheday(List<Dealoftheday_model> dealoftheday_modelList, String title) {
            viewall.setText(title);
            if (dealoftheday_modelList.size() > 8) {
                viewall.setVisibility(View.VISIBLE);
            }
            else{
                viewall.setVisibility(View.INVISIBLE);
            }

            Dealoftheday_adapter dealofadyadaptetr = new Dealoftheday_adapter(dealoftheday_modelList);
            LinearLayoutManager dealofthedaylayoutManager = new LinearLayoutManager(itemView.getContext());
            ((LinearLayoutManager) dealofthedaylayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
            dealoftheday_recycleview.setLayoutManager(dealofthedaylayoutManager);
            dealoftheday_recycleview.setAdapter(dealofadyadaptetr);
            dealofadyadaptetr.notifyDataSetChanged();
        }
    }
    public class GridViewLayoutViewHolder extends RecyclerView.ViewHolder{
        TextView gridlayout_title;
        Button gridlayout_viewall;
        GridView gridView;
        public GridViewLayoutViewHolder(@NonNull View itemView) {
            super(itemView);
             gridlayout_title = itemView.findViewById(R.id.gridlayout_title);
             gridlayout_viewall = itemView.findViewById(R.id.gridlayout_viewall);
             gridView = itemView.findViewById(R.id.gridlayout_gridview);
        }
        private  void setGridlayout(List<Dealoftheday_model> gridviewlayoutlist,String title){
            gridlayout_title.setText(title);
            gridView.setAdapter(new gridlayout_adapter(gridviewlayoutlist));
        }
    }
}
