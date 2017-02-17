package kekiru.toandoan.com.test;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import kekiru.toandoan.com.test.databinding.ActivityViewpagerBinding;

public class ViewpagerActivity extends AppCompatActivity {
    public ObservableField<FragmentPagerAdapter> adapter = new ObservableField<>();
    private ActivityViewpagerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewpager);
        mBinding.setActivity(this);
        adapter.set(new FragmentPagerAdapter(getSupportFragmentManager()));
    }

    @BindingAdapter({"bind:adapter"})
    public static void bindViewPagerAdapter(ViewPager view,
                                            FragmentPagerAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter({"bind:pager"})
    public static void bindViewPagerTabs(TabLayout view, ViewPager pagerView) {
        view.setupWithViewPager(pagerView, true);
    }

    public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
        public FragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MainFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return " " + position;
        }
    }
}
