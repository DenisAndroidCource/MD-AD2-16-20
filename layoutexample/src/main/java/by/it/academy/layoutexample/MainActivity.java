package by.it.academy.layoutexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<DataItem> ITEMS = new ArrayList<DataItem>() {{
        add(new DataItem(R.drawable.ic_baseline_4k_24, "TITLE 1"));
        add(new DataItem(R.drawable.ic_baseline_clean_hands_24, "TITLE 2"));
        add(new DataItem(R.drawable.ic_baseline_drive_eta_24, "TITLE 3"));
        add(new DataItem(R.drawable.ic_baseline_elevator_24, "TITLE 4"));
        add(new DataItem(R.drawable.ic_baseline_groups_24, "TITLE 5"));
        add(new DataItem(R.drawable.ic_baseline_4k_24, "TITLE 1"));
        add(new DataItem(R.drawable.ic_baseline_clean_hands_24, "TITLE 2"));
        add(new DataItem(R.drawable.ic_baseline_drive_eta_24, "TITLE 3"));
        add(new DataItem(R.drawable.ic_baseline_elevator_24, "TITLE 4"));
        add(new DataItem(R.drawable.ic_baseline_groups_24, "TITLE 5"));
        add(new DataItem(R.drawable.ic_baseline_4k_24, "TITLE 1"));
        add(new DataItem(R.drawable.ic_baseline_clean_hands_24, "TITLE 2"));
        add(new DataItem(R.drawable.ic_baseline_drive_eta_24, "TITLE 3"));
        add(new DataItem(R.drawable.ic_baseline_elevator_24, "TITLE 4"));
        add(new DataItem(R.drawable.ic_baseline_groups_24, "TITLE 5"));
        add(new DataItem(R.drawable.ic_baseline_4k_24, "TITLE 1"));
        add(new DataItem(R.drawable.ic_baseline_clean_hands_24, "TITLE 2"));
        add(new DataItem(R.drawable.ic_baseline_drive_eta_24, "TITLE 3"));
        add(new DataItem(R.drawable.ic_baseline_elevator_24, "TITLE 4"));
        add(new DataItem(R.drawable.ic_baseline_groups_24, "TITLE 5"));
        add(new DataItem(R.drawable.ic_baseline_4k_24, "TITLE 1"));
        add(new DataItem(R.drawable.ic_baseline_clean_hands_24, "TITLE 2"));
        add(new DataItem(R.drawable.ic_baseline_drive_eta_24, "TITLE 3"));
        add(new DataItem(R.drawable.ic_baseline_elevator_24, "TITLE 4"));
        add(new DataItem(R.drawable.ic_baseline_groups_24, "TITLE 5"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new DataItemAdapter(ITEMS));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private static class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.DataItemViewHolder> {

        private final List<DataItem> dataItemList;

        public DataItemAdapter(List<DataItem> dataItemList) {
            this.dataItemList = dataItemList;
        }

        @NonNull
        @Override
        public DataItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_image_info, parent, false);
            return new DataItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DataItemViewHolder holder, int position) {
            holder.bind(dataItemList.get(position), position);
        }

        @Override
        public int getItemCount() {
            return dataItemList != null ? dataItemList.size() : 0;
        }

        public void addItem(DataItem dataItem){
            if (dataItemList != null) {
                dataItemList.add(dataItem);
//                notifyItemChanged(5);
                notifyDataSetChanged();
            }
        }

        static class DataItemViewHolder extends RecyclerView.ViewHolder {

            private TextView textView;
            private Button button;
            private ImageView imageView;

            public DataItemViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.viewTextTitle);
                imageView = itemView.findViewById(R.id.imagePreview);
                button = itemView.findViewById(R.id.viewButtonDo);

            }

            void bind(DataItem dataItem, int position) {
                imageView.setImageResource(dataItem.getImageId());
                textView.setText(dataItem.getTitle());
                if (position == 4) {
                    View.OnClickListener listener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id = v.getId();
                            switch (id) {
                                case R.id.viewButtonDo:
                                    Toast.makeText(v.getContext(), "BUTTON", Toast.LENGTH_LONG).show();
                                    break;
                                case R.id.itemViewRoot:
                                    Toast.makeText(v.getContext(), "ROOT", Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }
                    };

                    button.setOnClickListener(listener);
                    itemView.setOnClickListener(listener);
                } else {
                    button.setOnClickListener(null);
                }
            }
        }
    }
}