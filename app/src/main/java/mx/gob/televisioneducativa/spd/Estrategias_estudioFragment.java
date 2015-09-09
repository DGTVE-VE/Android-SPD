package mx.gob.televisioneducativa.spd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A placeholder fragment containing a simple view.
 */
public class Estrategias_estudioFragment extends Fragment {

    public Estrategias_estudioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_estrategias_estudio, container, false);
        WebView html = (WebView)root.findViewById(R.id.estrategias_html);
        html.loadUrl("file:///android_asset/estrategias.html");

        return root;
    }
}
