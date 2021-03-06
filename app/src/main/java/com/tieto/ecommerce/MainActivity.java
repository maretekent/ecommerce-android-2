package com.tieto.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tieto.ecommerce.fragments.CustomersFragment;
import com.tieto.ecommerce.fragments.OrdersFragment;
import com.tieto.ecommerce.fragments.ProductsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        TabLayout tabLayout = createTabLayout();
        initTabIcons(tabLayout);
    }

    private TabLayout createTabLayout() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(createViewPager());
        return tabLayout;
    }

    private ViewPager createViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProductsFragment(), getString(R.string.products));
        adapter.addFragment(new CustomersFragment(), getString(R.string.customers));
        adapter.addFragment(new OrdersFragment(), getString(R.string.orders));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        return viewPager;
    }

    private void initTabIcons(TabLayout tabLayout) {
        tabLayout.getTabAt(0).setIcon(R.drawable.products);
        tabLayout.getTabAt(1).setIcon(R.drawable.customers);
        tabLayout.getTabAt(2).setIcon(R.drawable.orders);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
