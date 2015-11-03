package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MenuPromocionMediaFragment extends Fragment {

    public MenuPromocionMediaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu_promocion_media, container, false);
        root.findViewById(R.id.direccion_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Dirección Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "DIRECTOR").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        root.findViewById(R.id.subdirector_administrativo_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Subdirector Administrativo Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "SUBDIRECTOR ADMINISTRATIVO").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        root.findViewById(R.id.subdirector_academico_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Subdirector Académico Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "SUBDIRECTOR ACADÉMICO").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        root.findViewById(R.id.jefe_academico_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Jefe de Departamento Académico Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "JEFE DE DEPARTAMENTO ACADÉMICO").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        root.findViewById(R.id.jefe_administrativo_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Jefe de Departamento Administrativo Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "JEFE DE DEPARTAMENTO ADMINISTRATIVO").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        root.findViewById(R.id.supervision_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Supervisión Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "SUPERVISOR").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        root.findViewById(R.id.atp_media).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                Infografia.class).
                                putExtra("titulo","Promoción Asesoría Técnica Pedagógica Educación Media Superior").
                                putExtra("infografia", "promocion-direccion-ems-web.png").
                                putExtra("funcion", "ATP").
                                putExtra("proceso","PROMOCIÓN").
                                putExtra("nivel","MEDIA"));
            }
        });
        return root;
    }
}
