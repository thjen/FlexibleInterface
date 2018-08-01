package qthjen_dev.io.flexibleinterface;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<MyModel> list;
    private Context context;
    private OnItemSelected onPress;
    private OnPushItem0 onItem0;

    private int selectedItem = 0;

    public MyAdapter(ArrayList<MyModel> list, Context context, OnItemSelected onPress, OnPushItem0 onItem0) {
        this.list = list;
        this.context = context;
        this.onPress = onPress;
        this.onItem0 = onItem0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item, parent, false);

        onItem0.item0(list.get(0));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final MainActivity mainActivity = (MainActivity) context;
        if (mainActivity.isTwoPane) {
            if (selectedItem == position) {
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.itemselected));
                holder.tvTitle.setTextColor(context.getResources().getColor(R.color.textwhite));
            } else {
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.textwhite));
                holder.tvTitle.setTextColor(context.getResources().getColor(R.color.textblack));
            }
        }
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivity.isTwoPane) {
                    selectedItem = position;
                    notifyDataSetChanged();
                }
                onPress.onPress(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.itemTitle);
            view = itemView;
        }
    }
}
