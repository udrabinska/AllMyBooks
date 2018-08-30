package pl.pisze_czytam.allmybooks;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BookcasePagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public BookcasePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        return new BookcaseFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
