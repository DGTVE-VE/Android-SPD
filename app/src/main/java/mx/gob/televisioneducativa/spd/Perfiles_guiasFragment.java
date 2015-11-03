package mx.gob.televisioneducativa.spd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mx.gob.televisioneducativa.spd.entities.Guia;
import mx.gob.televisioneducativa.spd.entities.GuiaAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class Perfiles_guiasFragment extends Fragment {


    ArrayAdapter<Guia> g_adapter;

    Intent intent;




    public Perfiles_guiasFragment() {
    }

    private ProgressDialog pDialog;

    // URL to get contacts JSON
    //private static String url = "http://189.206.254.89/spd/Guias-SPD/api/guias.php?proceso=ingreso&funcion=DOCENTE&nivel=BASICA";

    //private static String url = "http://189.206.254.89/spd/Guias-SPD/api/guias.php?proceso="proceso"&funcion"funcion"=&nivel="nivel"";


    // JSON Node names
    private static final String TAG_GUIAS = "Guias";
    private static final String TAG_GUIAESTUDIO = "gUIADEESTUDIO";
    private static final String TAG_URLGUIA = "uRLGUIA";
    private static final String TAG_URLPERFIL = "uRLPERFIL";

    // contacts JSONArray
    JSONArray guides = null;

    // Hashmap for ListView
    ArrayList<Guia> guidesList ;

    String proceso = "";
    String funcion = "";
    String nivel = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        guidesList = new ArrayList<>();
        View rootView = inflater.inflate(R.layout.fragment_perfiles_guias, container, false);



        Intent intent = getActivity().getIntent();

        funcion = intent.getStringExtra("funcion");
        proceso = intent.getStringExtra("proceso");
        nivel = intent.getStringExtra("nivel");

        ListView listaGuias = (ListView)rootView.findViewById(R.id.listView_perfiles);


        //instantiate our GuiaAdapter class
        g_adapter = new GuiaAdapter(getActivity(),R.layout.list_item_perfiles,guidesList);
        //setListAdapter(g_adapter);
        listaGuias.setAdapter(g_adapter);
        new GetGuides().execute();
        return rootView;

    }



    private class GetGuides extends AsyncTask<Void, Void, Void> {

        String TAG = "GetGuides";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //showing progress dialog
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            String url = "http://189.206.254.89/spd/Guias-SPD/api/guias.php?proceso="+proceso+"&funcion="+funcion+"&nivel="+nivel+"";

            Log.d("URL","url:"+url);

            //Creating service handler class instance
            serviceHandler sh = new serviceHandler();

            //Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, serviceHandler.GET);
            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    guides = new JSONArray(jsonStr);
                    Log.d("JSONObject","->" + guides);


                    //looping through All guides
                    for (int i = 0; i < guides.length(); i++) {
                        JSONObject g = guides.getJSONObject(i);
                        Guia guia = new Guia(g.getString(TAG_GUIAESTUDIO),
                                             g.getString(TAG_URLGUIA),
                                             g.getString(TAG_URLPERFIL)
                                );
                        guidesList.add(guia);

                       /* String nombreGuia = new String(g.getString(TAG_GUIAESTUDIO));
                        guiasLista.add(nombreGuia);*/

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                Log.e("Service Handler","Couldn't get any data from the url");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            //dismiss the progress dialog
            if(pDialog.isShowing())
                pDialog.dismiss();



            g_adapter.notifyDataSetChanged();


        }
    }

}
