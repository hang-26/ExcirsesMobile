package com.example.login_and_signup.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class AdapterViewPager extends FragmentStateAdapter {
    private List<Fragment> list;

    public AdapterViewPager(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Fragment> listfr) {
        super(fragmentManager, lifecycle);
        this.list = listfr;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Fragment> getFragmentList(){
        return list;
    }
}
