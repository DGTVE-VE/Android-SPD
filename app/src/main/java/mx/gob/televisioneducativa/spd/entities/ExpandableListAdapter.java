package mx.gob.televisioneducativa.spd.entities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import mx.gob.televisioneducativa.spd.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<MaterialObject>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<MaterialObject>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }


    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final MaterialObject childText = (MaterialObject) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandible_list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.expandable_item);

        txtListChild.setTextSize(14);
        txtListChild.setText(childText.getBibliografia());
        if(childText.getUrlMaterial() != null){
            if ( ! childText.getUrlMaterial().trim().isEmpty()) {
                txtListChild.setTextColor(Color.BLUE);
                txtListChild.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(_context, childText.getUrlMaterial().toString(), Toast.LENGTH_LONG).show();
                        Log.d("CLICKPDF", "->" + childText.getUrlMaterial().toString());
                        String urlSpd = "http://evaluaciondocente.sep.gob.mx/";
                        String urlPdf = childText.getUrlMaterial().toString();
                        String urPdfComp = urlSpd + urlPdf;
                        String urlConv = String.valueOf(Uri.parse(urPdfComp));
                        Log.d("COMPLETA", "->" + urPdfComp);
                        Log.d("URLPARSE", "->" + urlConv);
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urPdfComp));
                        _context.startActivity(browserIntent);
                    }
                });
            }
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandible_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.material_group);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setTextSize(20);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
