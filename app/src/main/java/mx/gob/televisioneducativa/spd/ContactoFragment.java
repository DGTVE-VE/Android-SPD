package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContactoFragment extends Fragment {

    public ContactoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contacto, container, false);
        WebView html = (WebView)root.findViewById(R.id.web);
        html.loadUrl("file:///android_asset/contacto.html");

        root.findViewById(R.id.send_mail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", "evaluaciondocente@sep.gob.mx", null)));
            }
        });

        return root;
    }
}
