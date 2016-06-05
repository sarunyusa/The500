package th.sarunyu.the500.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import th.sarunyu.the500.R;
import th.sarunyu.the500.adapter.CategoryListAdapter;
import th.sarunyu.the500.dao.CategoryItemDao;
import th.sarunyu.the500.util.CategoryListManager;

/**
 * Created by Sarunyu on 4/6/2016.
 */
public class CategoryFragment extends Fragment {

    public interface CategoryFragmentListener{
        void OnCategoryItemClickListener(CategoryItemDao dao);
    }


    private ListView lvCategory;
    private CategoryListAdapter adapter;

    public CategoryFragment() {
        super();
    }

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        lvCategory = (ListView)rootView.findViewById(R.id.lvCategory);
        adapter = new CategoryListAdapter();
        lvCategory.setAdapter(adapter);
        adapter.setDao(CategoryListManager.getInstance().getList());
        adapter.notifyDataSetChanged();
        lvCategory.setOnItemClickListener(categoryItemClickListener);
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

    final AdapterView.OnItemClickListener categoryItemClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CategoryFragmentListener listener =  (CategoryFragmentListener)getActivity();
            listener.OnCategoryItemClickListener(
                    CategoryListManager.getInstance().getList().get(position));
        }
    };

}
