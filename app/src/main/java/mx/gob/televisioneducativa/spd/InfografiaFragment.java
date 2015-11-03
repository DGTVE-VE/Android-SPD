package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class InfografiaFragment extends Fragment {

    public InfografiaFragment() {
    }

    String proceso = "";
    String funcion = "";
    String nivel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_infografia, container, false);
        WebView webView = (WebView)root.findViewById(R.id.infografia);
        String titulo = "";
        String infografia = "";
        final Intent intent = getActivity().getIntent();

        if (intent != null && intent.hasExtra("titulo")){
            titulo = intent.getStringExtra("titulo");
        }
        if (intent != null && intent.hasExtra("infografia")){
            infografia = intent.getStringExtra("infografia");
        }

        Button boton = (Button) root.findViewById(R.id.boton_perfiles);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                funcion = intent.getStringExtra("funcion");
                proceso = intent.getStringExtra("proceso");
                nivel = intent.getStringExtra("nivel");
                Log.d("NIVEL","nivel:"+nivel);
                startActivity(new Intent(getActivity(), Perfiles_guias.class)
                        .putExtra("funcion",""+funcion+"")
                        .putExtra("proceso",""+proceso+"")
                        .putExtra("nivel",""+nivel+""));

            }
        });

        TextView tituloView = (TextView)root.findViewById(R.id.titulo);
        tituloView.setText(titulo);

        webView.loadDataWithBaseURL("file:///android_asset/", "<img src='"+infografia+"' />",
                                    "text/html", "utf-8", null);
        return root;
    }
}
