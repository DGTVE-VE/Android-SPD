package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MenuPromocionBasicaFragment extends Fragment {

    public MenuPromocionBasicaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu_promocion_basica, container, false);
        root.findViewById(R.id.direccion_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Dirección Educación Básica").
                                putExtra("infografia", "promocion-direccion-eb-web.png"));
            }
        });

        root.findViewById(R.id.subdireccion_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción Subdirección Educación Básica").
                                putExtra("infografia", "promocion-direccion-eb-web.png"));
            }
        });

        root.findViewById(R.id.coordinador_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción Coordinador de actividades Educación Básica").
                                putExtra("infografia", "promocion-direccion-eb-web.png"));
            }
        });

        root.findViewById(R.id.supervision_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción Supervisión Educación Básica").
                                putExtra("infografia", "promocion-supervision-eb-web.png"));
            }
        });

        root.findViewById(R.id.jefe_sector_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción Jefe de Sector Educación Básica").
                                putExtra("infografia", "promocion-supervision-eb-web.png"));
            }
        });

        root.findViewById(R.id.jefe_ensenanza_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción Jefe de Enseñanza Educación Básica").
                                putExtra("infografia", "promocion-supervision-eb-web.png"));
            }
        });

        root.findViewById(R.id.inspector_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción Inspector General Educación Básica").
                                putExtra("infografia", "promocion-supervision-eb-web.png"));
            }
        });

        root.findViewById(R.id.atp_basica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo", "Promoción ATP Educación Básica").
                                putExtra("infografia", "promocion-atp-eb-web.png"));
            }
        });
        return root;
    }
}
