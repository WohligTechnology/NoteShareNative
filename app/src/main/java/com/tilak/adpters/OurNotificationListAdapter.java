package com.tilak.adpters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.tilak.noteshare.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jay on 16-12-2015.
 */
public class OurNotificationListAdapter extends BaseAdapter {
    public ArrayList<HashMap<String,String>> list;
    Activity activity;

    public OurNotificationListAdapter(Activity activity,ArrayList<HashMap<String,String>> list){
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
        TextView tvNotiHeader,tvDesc;
        ImageButton ibAccept;
        ImageView userPic;
        Button btReject, btAccept;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){
            convertView=inflater.inflate(R.layout.our_notification_list,null); //change the name of the layout
            holder=new ViewHolder();


            holder.tvNotiHeader= (TextView) convertView.findViewById(R.id.tvNotiHeader); //find the different Views
            holder.tvDesc= (TextView) convertView.findViewById(R.id.tvDesc);

            holder.btReject = (Button) convertView.findViewById(R.id.btReject);
            holder.btAccept = (Button) convertView.findViewById(R.id.btAccept);

            holder.userPic = (ImageView) convertView.findViewById(R.id.ivUserPic);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        HashMap<String,String> map = list.get(position);
        String note = map.get("note");

        String notename = map.get("notename");
        String username = map.get("username");
        holder.tvNotiHeader.setText(notename);
        holder.tvDesc.setText((Html.fromHtml("<b>" + username + "</b> has shared <b>" + notename + "</b> note with you."))); //set the hash maps
        holder.btAccept.setTag(note);
        holder.btReject.setTag(note);

        //String name = "profile.jpg";
        //File f = new File(Environment.getExternalStorageDirectory() + "/NoteShare/.NoteShare/" + name);
        //Bitmap b = BitmapFactory.decodeFile(String.valueOf(f));

        //Bitmap b = BitmapFactory.decodeResource(get, R.drawable.large_icon);


        //holder.userPic.setImageBitmap(getRoundedCornerImage(getSquareImage(b)));

        return convertView;
    }


    public static Bitmap getSquareImage(Bitmap bitmap) {
        Bitmap tempBitmap;
        if (bitmap.getWidth() >= bitmap.getHeight()){
            tempBitmap = Bitmap.createBitmap(
                    bitmap,
                    bitmap.getWidth()/2 - bitmap.getHeight()/2,
                    0,
                    bitmap.getHeight(),
                    bitmap.getHeight()
            );

        } else{
            tempBitmap = Bitmap.createBitmap(
                    bitmap,
                    0,
                    bitmap.getHeight()/2 - bitmap.getWidth()/2,
                    bitmap.getWidth(),
                    bitmap.getWidth()
            );
        }
        return tempBitmap;
    }

    public static Bitmap getRoundedCornerImage(Bitmap bitmap){
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 500;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}
