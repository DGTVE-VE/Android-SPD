package mx.gob.televisioneducativa.spd.entities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import mx.gob.televisioneducativa.spd.R;

/**
 * Created by JITOLEDO on 26/10/2015.
 */
public class GuiaAdapter extends ArrayAdapter<Guia>{
    //declaring our ArrayList of guias
    private ArrayList<Guia> guias;

    /*here we must override the constructor for ArrayAdapter
    * the only variable we care about now is ArrayList<Guia> guias,
    * because it is the list of guias that we want to display*/
    public GuiaAdapter(Context context, int textViewResourceId, ArrayList<Guia> guias){
        super(context, textViewResourceId, guias);
        this.guias = guias;

    }

    /*
	 * we are overriding the getView method here - this is what defines how each
	 * list item will look.
	 */
    public View getView(int position, View convertView, ViewGroup parent){
        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item_perfiles,null);
        }

        /*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */

        final Guia guia = guias.get(position);
        if(guia != null){
            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView nombreGuia = (TextView) v.findViewById(R.id.list_item_perfiles_textview);
            final Button pdf1 = (Button) v.findViewById(R.id.btn_pdf1);
            final Button pdf2 = (Button) v.findViewById(R.id.btn_pdf2);
            final Button material = (Button) v.findViewById(R.id.btn_material);

            pdf1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CLICK", "boton guia" + pdf1.getTag());
                    //String urlSpd = "http://189.206.254.89/spd/Guias-SPD/";
                    String urlSpd = "http://evaluaciondocente.sep.gob.mx/";
                    String urlPdf = String.valueOf(pdf1.getTag());
                    String urlPdfPerfil = urlSpd + urlPdf;
                    Log.d("URL", "URL:" + urlPdfPerfil);
                    String googleDocsUrl = "https://docs.google.com/gview?embedded=true&url=";
                    Log.d("URLcompleta", "URL:" + googleDocsUrl + urlPdfPerfil);
                    //intent
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPdfPerfil));
                    getContext().startActivity(browserIntent);
                }
            });

            pdf2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CLICK","boton perfil" + pdf2.getTag());
                    //String urlSpd = "http://189.206.254.89/spd/Guias-SPD/";
                    String urlSpd = "http://evaluaciondocente.sep.gob.mx/";
                    String urlPdf = String.valueOf(pdf2.getTag());
                    String urlPdfPerfil = urlSpd + urlPdf;
                    Log.d("URL", "URL:" + urlPdfPerfil);
                    String googleDocsUrl = "https://docs.google.com/gview?embedded=true&url=";
                    Log.d("URLcompleta", "URL:" + googleDocsUrl + urlPdfPerfil);
                    //intent
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlPdfPerfil));
                    getContext().startActivity(browserIntent);
                }
            });

            material.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CLICK","boton material" + material.getTag());
                    Intent intent = new Intent(getContext(),Material.class);
                    Activity activity = (Activity)getContext();
                    String nivel = activity.getIntent().getStringExtra("nivel");
                    intent.putExtra("nivel",nivel);
                    intent.putExtra("guia", guia.getGuiaEstudio());
                    getContext().startActivity(intent);
                }
            });



            // check to see if each individual textview is null.
            if (nombreGuia != null){
                nombreGuia.setText(guia.getGuiaEstudio());
            }
            if (pdf1 != null){
                pdf1.setTag(guia.getPdfGuia());
            }
            if(pdf2 != null){
                pdf2.setTag(guia.getPdfPerfil());
            }
        }

        return v;


    }

}
