package guoxuebing.bawei.com.checkboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private CheckBox cb_quanxuan;
    private TextView tx_total_price;

    private List<Goods> list;

    private boolean flag = false;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        cb_quanxuan = (CheckBox) findViewById(R.id.cb_quanxuan);
        tx_total_price = (TextView) findViewById(R.id.tx_total_price);

        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Goods goods = new Goods(10 + i, "商品" + i, false);
            list.add(goods);
        }

        setRecyclerView();
    }

    private void setRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(manager);
        adapter = new MyAdapter(list);
        recycler_view.setAdapter(adapter);

        quanxuanListener();
    }

    private void quanxuanListener() {
        cb_quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cb_quanxuan.setChecked(!flag);

                for (int i = 0; i < list.size(); i++) {
                    if (flag == false){
                        if (! list.get(i).isFlag()){
                            list.get(i).setFlag(true);
                            adapter.setPrice(adapter.getPrice() + list.get(i).getPrice());
                        }
                    }else {
                        list.get(i).setFlag(false);
                        adapter.setPrice(0.0f);
                    }
                }
                flag = !flag;
                adapter.notifyDataSetChanged();
                tx_total_price.setText("总价为："+adapter.getPrice()+" 元");
            }
        });

        itemCbListener();
    }

    private void itemCbListener() {
        adapter.setItemClickListener(new MyAdapter.MOnItemClickListener() {
            @Override
            public void setPrice(float price) {
                tx_total_price.setText("总价为："+price+" 元");

                for (int i = 0; i < list.size(); i++) {
                    if (!list.get(i).isFlag()){
                        cb_quanxuan.setChecked(false);
                        break;
                    }else {
                        cb_quanxuan.setChecked(true);
                    }
                }
            }
        });
    }
}
