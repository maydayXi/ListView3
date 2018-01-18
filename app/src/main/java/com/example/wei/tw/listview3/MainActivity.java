package com.example.wei.tw.listview3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txt_info;
    private ListView list_view;

    private List<HashMap<String, String>> items;
    private SimpleAdapter a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 建立每一個元素為 Map 物件的 List 物件
        items = new ArrayList<>();

        // 建立包裝一個項目資料的 Map 物件
        HashMap<String, String> record = new HashMap<>();
        // 設定項目資料的編號，第一個參數 id 為資料名稱
        record.put("id", "1");
        // 設定項目資料的名稱，第一個參數 name 為資料名稱
        record.put("name", "Strawberry");
        // 設定項目資料的名挫，第一個參數 content 為資料名稱
        record.put("content", "Sweet fleshy red fruit");
        // 加入一個項目資料
        items.add(record);

        // 第二個項目資料
        record = new HashMap<>();
        record.put("id", "2");
        record.put("name", "Carrot");
        record.put("content",
                "Edible root of the cultivated carrot plant");
        items.add(record);

        // 第三個項目資料
        record = new HashMap<>();
        record.put("id", "3");
        record.put("name", "Pumpkin");
        record.put("content",
                "Usually large pulpy deep-yellow round fruit");
        items.add(record);

        // 建立一個資料名稱的字串陣列
        String[] keys = {"id", "name", "content"};
        // 建立一個與資料名稱對應的畫面元件資源編號陣列
        int[] viewIds = {R.id.idTxt, R.id.nameTxt, R.id.contentTxt};

        processViews();

        // 建立 Adapter 物件
        // 第一個參數設定 this，表示這個 Activity 物件
        // 第二個參數設定一個 List 物件，提供項目資料
        // 第三個參數設定自己設計的畫面配置資源
        // 第四個參數設定資料名稱的字串陣列
        // 第五個參數設定畫面元件資源編號陣列
        a = new SimpleAdapter(
                this,
                items,
                R.layout.listview_item,
                keys,
                viewIds
        );

        // 呼叫 setAdapter 方法指定使用的 Adapter 物件
        list_view.setAdapter(a);

        processControllers();
    }

    // 初始所有畫面元件
    private void processViews() {
        txt_info = findViewById(R.id.infoTxt);
        list_view = findViewById(R.id.listView);
    }

    // 註冊所有的監聽事件
    private void processControllers() {
        list_view.setOnItemClickListener(new MyItem());
    }

    // 選擇監聽類別
    private class MyItem implements AdapterView.OnItemClickListener {

        // 第一個參數是使用者操作的 ListView 元件
        // 第二個參數是使用者選擇的項目
        // 第三個參數是使用者選擇的項目編號，第一個是 0
        // 第四個參數在這裡沒用途
        @Override
        public void onItemClick(AdapterView<?> adapterView,
                                View view, int pos, long id) {

            HashMap<String, String> record = items.get(pos);
            txt_info.setText(record.get("name"));
        }
    }
}
