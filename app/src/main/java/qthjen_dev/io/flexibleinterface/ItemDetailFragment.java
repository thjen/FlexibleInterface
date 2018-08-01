package qthjen_dev.io.flexibleinterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemDetailFragment extends Fragment {

    private View rootView;
    private MyModel item;
    private TextView tvTitle, tvBody;

    public ItemDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = (MyModel) getArguments().getSerializable("myitem");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        tvTitle = rootView.findViewById(R.id.tvTitle);
        tvBody = rootView.findViewById(R.id.tvBody);

        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());

        return rootView;
    }

}
