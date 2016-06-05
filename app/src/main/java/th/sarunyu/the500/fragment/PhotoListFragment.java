package th.sarunyu.the500.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.sarunyu.the500.R;
import th.sarunyu.the500.adapter.PhotoListAdapter;
import th.sarunyu.the500.dao.CategoryItemDao;
import th.sarunyu.the500.dao.PhotoItemCollectionDao;
import th.sarunyu.the500.dao.photoitem.Photo;
import th.sarunyu.the500.http.The500pxHttpManager;
import th.sarunyu.the500.util.Const;
import th.sarunyu.the500.util.Contextor;
import th.sarunyu.the500.util.PhotoListManager;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PhotoListFragment extends Fragment {

    public interface PhotoListFragmentListener{
        void onPhotoItemClicked(Photo dao);
    }

    private ListView lvPhoto;
    private CategoryItemDao dao;
    private PhotoListAdapter adapter;
    private PhotoListManager manager;

    public PhotoListFragment() {
        super();
    }

    public static PhotoListFragment newInstance(CategoryItemDao dao) {
        PhotoListFragment fragment = new PhotoListFragment();
        Bundle args = new Bundle();
        args.putParcelable("dao",dao);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = getArguments().getParcelable("dao");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photo_list, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        lvPhoto = (ListView)rootView.findViewById(R.id.lvPhoto);
        adapter = new PhotoListAdapter();
        lvPhoto.setAdapter(adapter);
        manager = new PhotoListManager();

        refreshData();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    private void refreshData(){
        Call<PhotoItemCollectionDao> call = The500pxHttpManager.getInstance().getService()
                .loadPhotoByCategory(dao.getCategoryName(), Const.CONSUMER_KEY,"1","created_at","4,2048");
//        Call<PhotoItemCollectionDao> call = The500pxHttpManager.getInstance().getService().loadPhotoDemo();
        call.enqueue(new PhotoListLoadCallback(PhotoListLoadCallback.MODE_RELOAD));
    }

    private class PhotoListLoadCallback implements Callback<PhotoItemCollectionDao>{

        public static final int MODE_RELOAD = 1;
        public static final int MODE_NEXT_PAGE = 1;

        private int mode;

        public PhotoListLoadCallback(int mode){
            this.mode = mode;
        }

        @Override
        public void onResponse(Call<PhotoItemCollectionDao> call, Response<PhotoItemCollectionDao> response) {
            if (response.isSuccessful()) {
                PhotoItemCollectionDao dao = response.body();

                int firstVisiblePosition = lvPhoto.getFirstVisiblePosition();
                View c = lvPhoto.getChildAt(0);

                int top = c==null?0:c.getTop();

                if(mode == MODE_RELOAD){
                    manager.setDao(dao);
                }else {
                    // TODO: add load next page
                }

                adapter.setDao(manager.getDao());
                adapter.notifyDataSetChanged();

                Toast.makeText(Contextor.getInstance().getContext(),
                        "Load Completed",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                // handle if server return not success
                try {
                    Toast.makeText(Contextor.getInstance().getContext(),
                            response.errorBody().string(),
                            Toast.LENGTH_SHORT)
                            .show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Call<PhotoItemCollectionDao> call, Throwable t) {
            Toast.makeText(Contextor.getInstance().getContext(),
                    t.toString(),
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
