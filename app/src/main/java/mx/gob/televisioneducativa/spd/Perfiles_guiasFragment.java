package mx.gob.televisioneducativa.spd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class Perfiles_guiasFragment extends Fragment {

    ArrayAdapter<String> arrayAdapter;
    public Perfiles_guiasFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        updateList ();
    }

    private void updateList (){
        arrayAdapter.clear();
        arrayAdapter.add("Sonia");
        arrayAdapter.add("Rober");
        arrayAdapter.add("Luis");
        arrayAdapter.add("Nancy");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfiles_guias, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_perfiles,
                R.id.list_item_perfiles_textview,
                new ArrayList<String>());
        ListView listView = (ListView) root.findViewById(R.id.listView_perfiles);


        return root;
    }
}
