package qthjen_dev.io.flexibleinterface;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItemDetailActivity extends AppCompatActivity {

    ItemDetailFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // get data from ItemListFragment onpress
        MyModel item = (MyModel) getIntent().getSerializableExtra("item");
        // push data to ItemDetailFragment
        Bundle bundle = new Bundle();
        bundle.putSerializable("myitem", item);
        fragment = new ItemDetailFragment();
        fragment.setArguments(bundle);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragment);
            ft.commit();
        }
    }
}
