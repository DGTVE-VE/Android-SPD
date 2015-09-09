package mx.gob.televisioneducativa.spd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuBar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_estrategias) {
            startActivity(new Intent(this, Estrategias_estudio.class));
        }
        if (id == R.id.menu_simulador){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://simulador.ceneval.edu.mx/")));
        }
        if (id == R.id.menu_faq){
            startActivity(new Intent(this, Faq.class));
        }
        if (id == R.id.menu_contacto){
            startActivity(new Intent(this, Contacto.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
