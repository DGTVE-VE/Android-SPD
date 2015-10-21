package mx.gob.televisioneducativa.spd;

import android.app.ProgressDialog;
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

/**
 * A placeholder fragment containing a simple view.
 */
public class Perfiles_guiasFragment extends Fragment {


    //ArrayAdapter<Guia> guidesAdapter;
    ArrayAdapter<String> guidesAdapter;

    public Perfiles_guiasFragment() {
    }

    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "http://189.206.254.89/spd/Guias-SPD/api/guias.php?proceso=ingreso&funcion=DOCENTE&nivel=BASICA";

    // JSON Node names
    private static final String TAG_GUIAS = "Guias";
    private static final String TAG_GUIAESTUDIO = "gUIADEESTUDIO";
    private static final String TAG_URLGUIA = "uRLGUIA";
    private static final String TAG_URLPERFIL = "uRLPERFIL";

    // contacts JSONArray
    JSONArray guides = null;

    // Hashmap for ListView
    ArrayList<Guia> guidesList;
    ArrayList<String> guiasLista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        guiasLista = new ArrayList<>();
        guidesList = new ArrayList<>();
        guidesAdapter = new ArrayAdapter<String>(
                getActivity(), // the current context (this activity)
                R.layout.list_item_perfiles, // the name of layout ID
                R.id.list_item_perfiles_textview,
                guiasLista);
        View rootView = inflater.inflate(R.layout.fragment_perfiles_guias, container, false);
        ListView listaGuias = (ListView)rootView.findViewById(R.id.listView_perfiles);
        listaGuias.setAdapter(guidesAdapter);
        //ListView listView = (ListView) rootView.findViewById(R.id.listView_perfiles);
        new GetGuides().execute();
        return rootView;
        //return null;
/* este bloque funciona para un arreglo estatico(Lista de nombres 'data')
        //create the dato for the listView
        String[] data = {
                "Luis",
                "Sonia",
                "Rober",
                "Nancy",
                "Isra",
                "Bio"
        };
        List<String> nombres = new ArrayList<>(Arrays.asList(data));
        namesAdapter = new ArrayAdapter<String>(
                getActivity(), // the current context (this activity)
                R.layout.list_item_perfiles, // the name of layout ID
                R.id.list_item_perfiles_textview,
                nombres);
        View rootView = inflater.inflate(R.layout.fragment_perfiles_guias,container,false);
        //get a reference to the listview, and attach this adapter to it.
        ListView listView = (ListView)rootView.findViewById(R.id.listView_perfiles);
        listView.setAdapter(namesAdapter);

        return rootView;*/

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
            //Creating service handler class instance
            serviceHandler sh = new serviceHandler();

            //Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, serviceHandler.GET);
            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    guides = new JSONArray(jsonStr);
                    Log.d("JSONObject","->" + guides);

                    //getting JSON Array node
//                    guides = jsonObj.getJSONArray(TAG_GUIAS);

                    //looping through All guides
                    for (int i = 0; i < guides.length(); i++) {
                        JSONObject g = guides.getJSONObject(i);
                        Guia guia = new Guia(g.getString(TAG_GUIAESTUDIO),
                                             g.getString(TAG_URLGUIA),
                                             g.getString(TAG_URLPERFIL)
                                );
                        guidesList.add(guia);
                        //Log.d(TAG, "Guia -> " + guia.getGuiaEstudio());

                        String nombreGuia = new String(g.getString(TAG_GUIAESTUDIO));
                        guiasLista.add(nombreGuia);


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

            /*guidesAdapter = new ArrayAdapter<Guia>(
                    getActivity(),
                    R.layout.list_item_perfiles,
                    R.id.list_item_perfiles_textview,
                    guidesList);
            guidesAdapter.notifyDataSetChanged();*/

            for (int j=0; j<guiasLista.size(); j++){
                Log.d(" ","guiasLista["+j+"]=" + guiasLista.get(j));
            }

//            List<String> guias = new ArrayList<>(Arrays.asList(guiasLista));
//            guidesAdapter.addAll(guiasLista);
            guidesAdapter.notifyDataSetChanged();


        }
    }
}
