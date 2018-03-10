package com.example.shreyassk.jsonview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Modle> arrayList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList();

        String jsondata = "{\n" +
                "\t\"AndroidVersion List\": [{\n" +
                "\t\t\"Version Name\": \"Eclair\",\n" +
                "\t\t\"Version No\": \"2.0 - 2.1\",\n" +
                "\t\t\"API Level\": \"5 - 7\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"Froyo\",\n" +
                "\t\t\"Version No\": \"2.2 - 2.2.3\",\n" +
                "\t\t\"API Level\": \"8\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"GingerBread\",\n" +
                "\t\t\"Version No\": \"2.3 - 2.3.7\",\n" +
                "\t\t\"API Level\": \"9 - 10\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"HoneyComb\",\n" +
                "\t\t\"Version No\": \"3.0 - 3.2.6\",\n" +
                "\t\t\"API Level\": \"11 - 13\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"ICS\",\n" +
                "\t\t\"Version No\": \"4.0 - 4.0.4\",\n" +
                "\t\t\"API Level\": \"14 - 15\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"JellyBean\",\n" +
                "\t\t\"Version No\": \"4.1 - 4.3.1\",\n" +
                "\t\t\"API Level\": \"16 - 18\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"KitKat\",\n" +
                "\t\t\"Version No\": \"4.4 - 4.4.4\",\n" +
                "\t\t\"API Level\": \"19\"\n" +
                "\t}, {\n" +
                "\t\t\"Version Name\": \"Lollipop\",\n" +
                "\t\t\"Version No\": \"5.0\",\n" +
                "\t\t\"API Level\": \"21\"\n" +
                "\t}]\n" +
                "}";


        try {
            JSONObject jsonobject = new JSONObject(jsondata);
            JSONArray jsonarray = jsonobject.getJSONArray("AndroidVersion List");
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject object = new JSONObject();
                Modle modle = new Modle();
                modle.versionname = object.getString("Version Name");
                modle.versionno = object.getString("Version No");
                modle.apilevel = object.getString("API Level");
                arrayList.add(modle);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Adapter adapter = new Adaptor(MainActivity.this, 0);
        listView.setAdapter((ListAdapter) adapter);

    }
    class Adaptor extends ArrayAdapter {

        public Adaptor(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflator = LayoutInflater.from(MainActivity.this);
            convertView = inflator.inflate(R.layout.adaptor, null);
            TextView versionName, versionno, apilevel;
            versionName = (TextView) convertView.findViewById(R.id.versionname);
            versionno = (TextView) convertView.findViewById(R.id.versionno);
            apilevel = (TextView) convertView.findViewById(R.id.apilevel);

            versionName.setText(arrayList.get(position).versionname);
            versionno.setText(arrayList.get(position).versionno);
            apilevel.setText(arrayList.get(position).apilevel);

            return convertView;


        }
    }}

class Modle
{
    String versionname,versionno,apilevel;
}