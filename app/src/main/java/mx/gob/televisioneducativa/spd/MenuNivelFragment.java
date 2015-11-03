package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MenuNivelFragment extends Fragment {

    public MenuNivelFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu_nivel, container, false);
        Intent intent = getActivity().getIntent();
        Log.d("INTENT", "intent:" + intent);
        String proceso = "";
        if (intent != null && intent.hasExtra("proceso")){
            proceso = intent.getStringExtra("proceso");
        }

//        Toast.makeText(getActivity(),proceso, Toast.LENGTH_LONG).show();
        if (proceso.equals("Ingreso")){
            ingreso (root);
        }

        if (proceso.equals("Promoción")){
            promocion (root);
        }
        return root;
    }

    private void promocion (View root){
        root.findViewById(R.id.btn_ingreso_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                MenuPromocionBasica.class));
            }
        });
        root.findViewById(R.id.btn_ingreso_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                MenuPromocionMedia.class));
            }
        });
    }

    private void ingreso (View root){
        root.findViewById(R.id.btn_ingreso_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Ingreso Docente").
                                putExtra("infografia", "ingreso_basica_960.jpg").
                                putExtra("funcion", "DOCENTE").
                                putExtra("proceso","ingreso").
                                putExtra("nivel","BASICA"));
            }
        });
        root.findViewById(R.id.btn_ingreso_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Ingreso Docente").
                                putExtra("infografia", "ingreso_media_960.jpg").
                                putExtra("funcion", "DOCENTE").
                                putExtra("proceso","ingreso").
                                putExtra("nivel","MEDIA"));
            }
        });
    }
}
