package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView videoIntro = (ImageView)root.findViewById(R.id.video_intro);
        videoIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5C2FFZCF97M")));
            }
        });

        root.findViewById(R.id.btn_ingreso).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                MenuNivel.class).
                                putExtra("proceso", "Ingreso"));
            }
        });
        root.findViewById(R.id.btn_promocion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(getActivity(),
                                MenuNivel.class).
                                putExtra("proceso", "Promoción"));
            }
        });
        return root;
    }
}
