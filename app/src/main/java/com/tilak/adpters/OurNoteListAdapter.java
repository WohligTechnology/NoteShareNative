package com.tilak.adpters;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tilak.noteshare.R;

import java.util.ArrayList;
import java.util.HashMap;

public class OurNoteListAdapter extends BaseAdapter {
    public ArrayList<HashMap<String,String>> list;
    Activity activity;

    public OurNoteListAdapter(Activity activity,ArrayList<HashMap<String,String>> list){
        super();
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        //all the fields in layout specified
        TextView txtNoteName,txtNoteDesc,txtNoteDate;
        ImageButton button,btnHidden;
        LinearLayout linearLayout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){
            convertView=inflater.inflate(R.layout.our_note_list,null); //change the name of the layout
            holder=new ViewHolder();

            holder.linearLayout= (LinearLayout) convertView.findViewById(R.id.front);
            holder.txtNoteName= (TextView) convertView.findViewById(R.id.tvNoteName); //find the different Views
            holder.txtNoteDesc = (TextView) convertView.findViewById(R.id.tvNoteDesc);
            holder.txtNoteDate= (TextView) convertView.findViewById(R.id.tvNoteDate);
            holder.btnHidden = (ImageButton) convertView.findViewById(R.id.btnHidden);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        HashMap<String,String> map =list.get(position);
        holder.txtNoteName.setText(map.get("noteName")); //set the hash maps
        holder.txtNoteDesc.setText(map.get("noteDesc"));
        holder.txtNoteDate.setText(map.get("noteDate"));
        holder.btnHidden.setId(Integer.parseInt(map.get("noteId")));
        holder.linearLayout.setBackgroundColor(Color.parseColor(map.get("noteBgColor")));

        return convertView;
    }
}
