package th.sarunyu.the500.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import th.sarunyu.the500.R;
import th.sarunyu.the500.dao.PhotoItemDao;
import th.sarunyu.the500.fragment.PhotoListFragment;

public class PhotoListActivity extends AppCompatActivity
        implements PhotoListFragment.PhotoListFragmentListener{

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photo_list);

        initInstances();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, PhotoListFragment.newInstance())
                    .commit();
        }
    }


    private void initInstances(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void OnPhotoItemClickListener(PhotoItemDao dao) {
        Intent intent = new Intent(PhotoListActivity.this, ViewPhotoActivity.class);
        startActivity(intent);
    }
}
