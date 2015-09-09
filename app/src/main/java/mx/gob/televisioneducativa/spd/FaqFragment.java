package mx.gob.televisioneducativa.spd;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A placeholder fragment containing a simple view.
 */
public class FaqFragment extends Fragment {

    public FaqFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_faq, container, false);
        WebView html = (WebView)root.findViewById(R.id.web);
        html.loadUrl("file:///android_asset/faq.html");

        return root;
    }
}
