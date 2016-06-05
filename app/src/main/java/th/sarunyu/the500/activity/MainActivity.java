package th.sarunyu.the500.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import th.sarunyu.the500.R;
import th.sarunyu.the500.dao.CategoryItemDao;
import th.sarunyu.the500.fragment.CategoryFragment;

public class MainActivity extends AppCompatActivity
        implements CategoryFragment.CategoryFragmentListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initInstances();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, CategoryFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onCategoryItemClicked(CategoryItemDao dao) {
        Intent intent = new Intent(MainActivity.this, PhotoListActivity.class);
        intent.putExtra("dao",dao);
        startActivity(intent);
    }
}
