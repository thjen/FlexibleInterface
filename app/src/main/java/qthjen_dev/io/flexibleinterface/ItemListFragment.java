package qthjen_dev.io.flexibleinterface;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemListFragment extends Fragment implements OnItemSelected, OnPushItem0 {

    private View rootView;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    //private boolean isTwoPane;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<MyModel> item = new ArrayList<>();
        item.add(new MyModel("Item 1", "This is the first item"));
        item.add(new MyModel("Item 2", "This is the second item"));
        item.add(new MyModel("Item 3", "This is the third item"));

        adapter = new MyAdapter(item, getActivity(), this, this);
        //determinePaneLayout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onPress(MyModel item) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity.isTwoPane) {
            // push data
            Bundle bundle = new Bundle();
            bundle.putSerializable("myitem", item);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(bundle);

            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragment);
            ft.commit();
        } else {
            Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
            intent.putExtra("item", (Serializable) item);
            startActivity(intent);
        }
    }

    @Override
    public void item0(MyModel item) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity.isTwoPane) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("myitem", item);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(bundle);

            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragment);
            ft.commit();
        }
    }
}
