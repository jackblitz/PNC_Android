package com.hopkinsdev.howto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.adapters.CategoryAdapter;
import com.nirhart.parallaxscroll.views.ParallaxListView;


public class MainActivity extends ActionBarActivity {

    private ParallaxListView mParralaxScrollView;
    private CategoryAdapter mCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mParralaxScrollView = (ParallaxListView) findViewById(R.id.listView);
        mCatAdapter = new CategoryAdapter(this);
        mParralaxScrollView.setAdapter(mCatAdapter);
        mParralaxScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Application.getInstance().setReceipe(Application.getInstance().getCategories().get(position).Id);

                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
