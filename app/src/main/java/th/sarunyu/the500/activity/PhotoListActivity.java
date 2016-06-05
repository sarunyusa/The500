package th.sarunyu.the500.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import th.sarunyu.the500.R;
import th.sarunyu.the500.dao.CategoryItemDao;
import th.sarunyu.the500.dao.photoitem.Photo;
import th.sarunyu.the500.fragment.PhotoListFragment;

public class PhotoListActivity extends AppCompatActivity
        implements PhotoListFragment.PhotoListFragmentListener{

    private Toolbar toolbar;
    private CategoryItemDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photo_list);

        dao = getIntent().getParcelableExtra("dao");

        initInstances();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, PhotoListFragment.newInstance(dao))
                    .commit();
        }
    }


    private void initInstances(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(dao.getCategoryLabel());
        setSupportActionBar(toolbar);
    }

    @Override
    public void onPhotoItemClicked(Photo dao) {
        Intent intent = new Intent(PhotoListActivity.this, PhotoViewerActivity.class);
        intent.putExtra("dao",dao);
        startActivity(intent);
    }
}
