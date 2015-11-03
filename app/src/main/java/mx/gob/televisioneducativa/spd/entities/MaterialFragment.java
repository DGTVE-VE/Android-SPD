package mx.gob.televisioneducativa.spd.entities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.gob.televisioneducativa.spd.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaterialFragment extends Fragment {

    public MaterialFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_material, container, false);
    }
}
