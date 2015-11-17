package mx.gob.televisioneducativa.spd.entities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mx.gob.televisioneducativa.spd.R;
import mx.gob.televisioneducativa.spd.serviceHandler;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaterialFragment extends Fragment {


    public MaterialFragment() {
    }

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String,List<MaterialObject>> listDataChild;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_material, container,false);

        //get the listview
        expListView = (ExpandableListView)rootView.findViewById(R.id.expandable_list);

        //return inflater.inflate(R.layout.fragment_material, container, false);
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<MaterialObject>>();

        //Adding header data
        listDataHeader.add("Dimension 1");
        listDataHeader.add("Dimension 2");
        listDataHeader.add("Dimension 3");
        listDataHeader.add("Dimension 4");
        listDataHeader.add("Dimension 5");


        new GetBibliografias().execute();
        listAdapter = new ExpandableListAdapter(getActivity(),listDataHeader,listDataChild);
        expListView.setAdapter(listAdapter);
        return rootView;
    }


        private ProgressDialog pDialog;
        private JSONArray bibliografias;


        private static final String TAG_GUIAESTUDIO = "gUIADEESTUDIO";
        private static final String TAG_DIMENSION = "dIMENSION";
        private static final String TAG_BIBLIOGRAFIA = "bIBLIOGRAFIA";
        private static final String TAG_URLMATERIAL = "uRLMATERIAL";

        String nivel;
        String guia;
        String guia1;


    private class GetBibliografias extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            //showing progress dialog
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0){

            listDataChild.put(listDataHeader.get(0),llenaDimension("1"));
            listDataChild.put(listDataHeader.get(1),llenaDimension("2"));
            listDataChild.put(listDataHeader.get(2),llenaDimension("3"));
            listDataChild.put(listDataHeader.get(3),llenaDimension("4"));
            listDataChild.put(listDataHeader.get(4),llenaDimension("5"));

            return null;
        }

        private List<MaterialObject> llenaDimension (String dimension){
            Log.d("DIMENSION","->"+dimension);
            Intent intent1 = getActivity().getIntent();
            nivel = intent1.getStringExtra("nivel");
            guia = intent1.getStringExtra("guia");
            Log.d("NIVEL","->"+nivel);
            Log.d("GUIA","->"+guia);
            //String url = "http://172.16.200.12/spd/Guias-SPD/api/material.php?guia=Educaci%C3%B3n%20Preescolar.%20Subdirector&dimension="+dimension+"&nivel=BASICA";
            try {
                guia1 = URLEncoder.encode(guia,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Log.d("PARSEGUIA","->"+guia1);
            String url = "http://172.16.200.12/spd/Guias-SPD/api/material.php?guia="+guia1+"&dimension="+dimension+"&nivel="+nivel+"";

            Log.d("URL","->"+url);
            List<MaterialObject> nombres = new ArrayList<>();
            //creating service handler class instance
            serviceHandler sh = new serviceHandler();

            //making a request to url and getting response

            String jsonStr = sh.makeServiceCall(url, serviceHandler.GET);

            if(jsonStr != null){
                try {

                    bibliografias = new JSONArray(jsonStr);

                    //looping through all bibliografias
                    for (int i=0; i<bibliografias.length();i++){
                        JSONObject m = bibliografias.getJSONObject(i);
                        MaterialObject material = new MaterialObject(m.getString(TAG_GUIAESTUDIO),
                                m.getString(TAG_DIMENSION),
                                m.getString(TAG_BIBLIOGRAFIA),
                                m.getString(TAG_URLMATERIAL));
                        nombres.add(material);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                Log.e("Service Handler", "Couldn't get any data from the url");
            }
            return nombres;
        }

        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            //dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }
}
