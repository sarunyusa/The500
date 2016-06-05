package th.sarunyu.the500.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import th.sarunyu.the500.R;
import th.sarunyu.the500.dao.photoitem.Image;
import th.sarunyu.the500.dao.photoitem.Photo;

public class PhotoViewFragment extends Fragment {

    private TextView tvName, tvDescription;
    private ImageView ivImg;
    private Photo dao;

    public PhotoViewFragment() {
        super();
    }

    public static PhotoViewFragment newInstance(Photo dao) {
        PhotoViewFragment fragment = new PhotoViewFragment();
        Bundle args = new Bundle();
        args.putParcelable("dao", dao);
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
        View rootView = inflater.inflate(R.layout.fragment_photo_view, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        tvName = (TextView) rootView.findViewById(R.id.tvName);
        tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        ivImg = (ImageView) rootView.findViewById(R.id.ivImg);

        tvName.setText(dao.getName());
        tvDescription.setText("by " + dao.getUser().getUserName());

        String fullSizeUrl = dao.getImageUrl();
        for (Image img: dao.getImages()) {
            if(img.getSize() == 2048){
                fullSizeUrl = img.getUrl();
            }
        }

        Glide.with(getContext())
                .load(fullSizeUrl)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(ivImg);

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


}
