package com.hopkinsdev.howto;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.hopkinsdev.howto.Objects.Application;
import com.hopkinsdev.howto.Objects.Reciepe;
import com.hopkinsdev.howto.adapters.CategoryAdapter;
import com.nirhart.parallaxscroll.views.ParallaxListView;


public class MainActivity extends ActionBarActivity {

    private ParallaxListView mParralaxScrollView;
    private CategoryAdapter mCatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);

      //  String android_id = Settings.Secure.getString(getContentResolver(),
      //          Settings.Secure.ANDROID_ID);


        AdRequest adRequest = new AdRequest.Builder()
                                     .addTestDevice("10bf660d5a339224")
                                    .build();
        mAdView.loadAd(adRequest);


        mParralaxScrollView = (ParallaxListView) findViewById(R.id.listView);
        mCatAdapter = new CategoryAdapter(this);
        mParralaxScrollView.setAdapter(mCatAdapter);
        mParralaxScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                try {
                    Reciepe rec = Application.getInstance().getReceipe(Application.getInstance().getCategories().get(position).File);//Application.getInstance().getCategories().get(position).Id);

                    if(rec == null){
                        Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.sorry_load), Toast.LENGTH_SHORT).show();
                    }else {
                        Intent i = new Intent(MainActivity.this, IngredientsActivity.class);
                        i.putExtra("Current", rec);

                        View v = view.findViewById(R.id.card_view);
                        View image = view.findViewById(R.id.catImageView);
                        View cutView = view.findViewById(R.id.cutView);
                        Pair participants = new Pair<>(v, ViewCompat.getTransitionName(v));
                        Pair participant = new Pair<>(image, ViewCompat.getTransitionName(image));
                        Pair p = new Pair<>(cutView, ViewCompat.getTransitionName(cutView));
                        ActivityOptionsCompat transitionActivityOptions =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(
                                        MainActivity.this, participants,participant, p);

                         ActivityCompat.startActivity(MainActivity.this,
                                 i, transitionActivityOptions.toBundle());

                        //startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.sorry_load), Toast.LENGTH_SHORT).show();
                }


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


        return super.onOptionsItemSelected(item);
    }
}
