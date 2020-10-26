package com.example.moviestreamingtcn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.moviestreamingtcn.adapter.BannerMoviesPagerAdapter;
import com.example.moviestreamingtcn.adapter.MainRecyclerAdapter;
import com.example.moviestreamingtcn.model.AllCategory;
import com.example.moviestreamingtcn.model.BannerMovies;
import com.example.moviestreamingtcn.model.CategoryItem;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab, categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;
    Timer sliderTimer;
    Toolbar toolbar;

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);
        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);




        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"Sausage Party","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/sphe-1261640__UHD-Full-Image_GalleryCover-de-DE-1558138308729._UR1920,1080_RI_SX329_.jpg",""));
        homeBannerList.add(new BannerMovies(2,"Bad Neighbors","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/832e123c29253ea66fea0fea48264b19e7d2f2574158bd922109da9acd65a424._UR1920,1080_RI_SX329_.jpg",""));
        homeBannerList.add(new BannerMovies(3,"Family Guy","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/fox-FAMILYGUY_1-Full-Image_GalleryCover-de-DE-1486765392332._UR1920,1080_RI_SX329_.jpg",""));
        homeBannerList.add(new BannerMovies(4,"Angry Birds","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/45d96bbf0acd865675d4da01d6d438a5858b51901c0dcb69dac33d02055f0e0e._UY500_UX667_RI_V_TTW_SX329_.jpg",""));
        homeBannerList.add(new BannerMovies(5,"Men In Black 3","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/sphe-MenInBlack3-Full-Image_GalleryCover-de-DE-1496071724399._UY500_UX667_RI_V58e87f1beafed7933bfdd36613aecea4_TTW_SX329_.jpg",""));

        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"Grey's Anatomy","https://m.media-amazon.com/images/I/71BkG5D745L._AC_UY218_.jpg",""));
        tvShowBannerList.add(new BannerMovies(2,"How I Met Your Mother","https://m.media-amazon.com/images/I/514mAYZ7MPL._AC_UY218_.jpg",""));
        tvShowBannerList.add(new BannerMovies(3,"Supernatural","https://m.media-amazon.com/images/I/91-QmTLQzbL._AC_UY218_.jpg",""));
        tvShowBannerList.add(new BannerMovies(4,"Prodigal Son","https://m.media-amazon.com/images/I/812LW5SAYKL._AC_UY218_.jpg",""));
        tvShowBannerList.add(new BannerMovies(5,"Raised by Wolves","https://m.media-amazon.com/images/I/81JiXYA6aUL._AC_UY218_.jpg",""));

        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"A Beautiful Day","",""));
        movieBannerList.add(new BannerMovies(2,"Somic the HedgeHog","https://s3-dub-2.cf.videorolls.row.aiv-cdn.net/e019/412b/bfbb/41db-b7db-6e0dd768281a/00ca8427-5279-47cb-97fa-c07679060765_video_336p_450kbps_audio_aaclc_128kbps.mp4",""));
        movieBannerList.add(new BannerMovies(3,"Fast And Furious","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/0bcb20ca2a68c4ea6a1c2555218dc1575eaab2c71b0b35efa7ce168a68527da9._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        movieBannerList.add(new BannerMovies(4,"Aquaman","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/wb-2045078_6000112291-Full-Image_GalleryCover-de-DE-1553902089006._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        movieBannerList.add(new BannerMovies(5,"Birds of Prey","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/wb-2074898_6000120928-Full-Image_GalleryCover-de-DE-1591782729717._UR1920,1080_RI_SX356_FMwebp_.jpg",""));

        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"Harry Poter","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/3fa7f6f85c32c23d52f1c5966c77ec794bdb5b5b2469bce576135e1101ccd3e7._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(2,"Freeze","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/Disney-182966_Bonus-Full-Image_GalleryCover-de-DE-1584549002171._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(3,"Vaiana","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/disney-750000038032-Full-Image_GalleryCover-de-DE-1490992438600._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(4,"Sponge Bob","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/viacom-TV_1197-Full-Image_GalleryCover-de-DE-1483993488391._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        kidsBannerList.add(new BannerMovies(5,"Onward","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/disney-229039-Full-Image_GalleryCover-de-DE-1590691430887._UR1920,1080_RI_SX356_FMwebp_.jpg",""));

        //this is default tab selected
        setBannerMoviesPagerAdapter(homeBannerList);
        //on tab change selected data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                       setScrollDefaultState();
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //first we will add catitem data

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Deutschland","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/fdf8fbf62634cc36bfaa4ad4be30a33c33af1b68eb3e28c6c62a7697a903cffe._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(2,"The Expanse","https://images-eu.ssl-images-amazon.com/images/S/pv-target-images/329cef680e9fc19b2ff89426c4503578698de355f0b76da9e98c7ab573a69e3e._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(3,"South Park","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/viacom-TV_1180-Full-Image_GalleryCover-de-DE-1493422230875._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(4,"The Walking Dead","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/fic-1914437141_S6-Full-Image_GalleryCover-de-DE-1486136240925._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        homeCatListItem1.add(new CategoryItem(5,"Prison Break","https://images-eu.ssl-images-amazon.com/images/S/sgp-catalog-images/region_DE/fox-PRISONBREAK_4-Full-Image_GalleryCover-de-DE-1527715948670._UR1920,1080_RI_SX356_FMwebp_.jpg",""));
        //similary we will add category as much as we want
        //i have some category lets coy and paste

        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Made In Heaven","https://m.media-amazon.com/images/I/810W0pDE2DL._AC_UY218_.jpg",""));
        homeCatListItem2.add(new CategoryItem(2,"Mirzapur","https://m.media-amazon.com/images/I/81bX4exiFOL._AC_UY218_.jpg",""));
        homeCatListItem2.add(new CategoryItem(3,"Four More Shots Please!-Season 1","https://m.media-amazon.com/images/I/71NYxOMKWuL._AC_UY218_.jpg",""));
        homeCatListItem2.add(new CategoryItem(4,"Fauji-German","https://m.media-amazon.com/images/I/71Zji8SnB-L._AC_UY218_.jpg",""));
        homeCatListItem2.add(new CategoryItem(5,"The Remix","https://m.media-amazon.com/images/I/91MTurOxVZL._AC_UY218_.jpg",""));

        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"The Quest","https://m.media-amazon.com/images/I/91iF60tCTnL._AC_UY218_.jpg",""));
        homeCatListItem3.add(new CategoryItem(2,"Lucifer","https://m.media-amazon.com/images/I/81lgVor3wOL._AC_UY218_.jpg",""));
        homeCatListItem3.add(new CategoryItem(3,"The Expanse","https://m.media-amazon.com/images/I/81UhEuKJiSL._AC_UY218_.jpg",""));
        homeCatListItem3.add(new CategoryItem(4,"Man In The High Castle","https://m.media-amazon.com/images/I/81DV-AzcG4L._AC_UY218_.jpg",""));
        homeCatListItem3.add(new CategoryItem(5,"The Handmaid's Tale","https://m.media-amazon.com/images/I/A1jKOSgacaL._AC_UY218_.jpg",""));

        List<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"Bibi & Tina - Die Serie","https://m.media-amazon.com/images/I/91HSFe6pleL._AC_UY218_.jpg",""));
        homeCatListItem4.add(new CategoryItem(2,"SpongeBob Schwammkopf","https://m.media-amazon.com/images/I/81YdakujZXL._AC_UY218_.jpg",""));
        homeCatListItem4.add(new CategoryItem(3,"Scooby-Doo","https://m.media-amazon.com/images/I/81cYOOD8k-L._AC_UY218_.jpg",""));
        homeCatListItem4.add(new CategoryItem(4,"Scooby-Doo: Mystery Incorporated","https://m.media-amazon.com/images/I/51vBw2Cf50L._AC_UY218_.jpg",""));
        homeCatListItem4.add(new CategoryItem(5,"Monster Town","https://m.media-amazon.com/images/I/71N1KjWY2hL._AC_UY218_.jpg",""));

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next TV and Movies", homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Movies in hindi",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Amazon Original Series",homeCatListItem3));
        allCategoryList.add(new AllCategory(4,"Kids and Family Movies",homeCatListItem4));


        //here we pass array to recycler setup method
        setMainRecycler(allCategoryList);
        //lets run
    }
    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){

        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager,true);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1) {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);

                    } else {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void setMainRecycler(List<AllCategory> allCategoryList){
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

    private void setScrollDefaultState() {

        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }
}