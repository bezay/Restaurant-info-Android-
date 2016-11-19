package com.example.bezay.easyeat.tabs;

/**
 * Created by BeZaY on 9/17/2016.
 */
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.bezay.easyeat.R;
import com.example.bezay.easyeat.adapter.ListAdapter;
import com.example.bezay.easyeat.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class All extends Fragment {

    private ViewFlipper mViewFlipper;
    private HttpURLConnection urlConnection;
    private ProgressDialog progressDialog;
    private ListAdapter adapter;
    ArrayList<Product> arrayList;
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all, container, false);
        arrayList = new ArrayList<Product>();

        mViewFlipper = (ViewFlipper) rootView.findViewById(R.id.view_flipper);
        lv = (ListView)rootView.findViewById(R.id.listView);
        new ReadJSON().execute("http://localhost/imageSelect.php");

        return rootView;
    }

    public class ReadJSON extends AsyncTask<String,Void,String> {


        @Override
        protected String doInBackground(String... params) {
            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL("http://localhost/imageSelect.php");
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine())!=null) {
                    content.append(line+"\n");

                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = jsonObject.getJSONArray("http://localhost/imageSelect.php");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject productObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Product(
                            productObject.getString("image_url"),
                            productObject.getString("Name"),
                            productObject.getString("Address")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String content) {
            if(content.isEmpty()){
                Toast.makeText(getContext(),"Unable to parse",Toast.LENGTH_LONG);
            }
            else {
                ListAdapter adapter = new ListAdapter(getActivity(),R.layout.list_row,arrayList);
                lv.setAdapter(adapter);
            }
        }
    }
}