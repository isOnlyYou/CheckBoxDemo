package guoxuebing.bawei.com.checkboxdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by acer on 2017/4/10.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Goods> list;

    private MOnItemClickListener itemClickListener;

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public MyAdapter(List<Goods> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.item_cb.setChecked(list.get(position).isFlag());
        holder.item_name.setText(list.get(position).getName());
        holder.item_price.setText("价格为：" + list.get(position).getPrice());

        holder.item_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setFlag(!list.get(position).isFlag());
                if (list.get(position).isFlag()) {
                    price += list.get(position).getPrice();
                }else {
                    price -= list.get(position).getPrice();
                }

                itemClickListener.setPrice(price);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox item_cb;
        TextView item_name;
        TextView item_price;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_cb = (CheckBox) itemView.findViewById(R.id.item_cb);
            item_name = (TextView) itemView.findViewById(R.id.item_name);
            item_price = (TextView) itemView.findViewById(R.id.item_price);
        }
    }

    public interface MOnItemClickListener {
        void setPrice(float price);
    }

    public void setItemClickListener(MOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
