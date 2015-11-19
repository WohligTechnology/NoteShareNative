package com.tilak.noteshare;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.tilak.db.Note;
import com.tilak.db.NoteElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraImage extends Activity {

    Bitmap bitmap;
    ImageView image;
    String noteid;
    int a;
    NoteMainActivity noteMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_image);

        // Retrieving image Uri from Bundle
        Bundle b = getIntent().getExtras();
        noteid = b.getString("noteid");
        a = b.getInt("a");
        int check = getIntent().getIntExtra("check", 0);
        image = (ImageView)findViewById(R.id.camera_image);

        /*for(int i = 0 ; i < 20 ; i ++)
            Log.e("Inside noteId null",noteMainActivity.noteIdForDetails );*/

        if (check == 0) {
            try {
                Uri mediaUri = Uri.parse(b.getString("image"));
                setImage(mediaUri);
            } catch (Exception e) {}
        } else if (check == 1) {
            try {
                //setImage(imagePath);
                Uri imagePath = Uri.parse(b.getString("select_image"));
                setImage(imagePath);
            } catch (Exception e) {}
        }


    }

    public void done(View v) {
        finish();

        try {
            // Saving Image file
            String timestamp = String.valueOf(System.currentTimeMillis());
            File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "/NoteShare/NoteShare Images/" + "IMG-" + timestamp + ".jpg");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(mediaStorageDir));

            // Refreshing Gallery to view Image in Gallery
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DATA, mediaStorageDir.getAbsolutePath());
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

            // Saving to database
            if (a == 0) { makeNote(); }

            if (a == 1) {
                NoteElement noteElement = new NoteElement(Long.parseLong(noteid), 1, "yes", "image", "IMG-" + timestamp + ".jpg","","");
                noteElement.save();
                modifyNoteTime();
            }

        } catch (FileNotFoundException e) {}
    }

    public void makeNote() {
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateStr = formatter.format(new Date());
        Note note = new Note("NOTE", "","#FFFFFF", "", "", "", "#FFFFFF", currentDateStr, currentDateStr, "", "1", 0);
        note.save();
        noteMainActivity.noteIdForDetails = note.getId().toString();
        noteid = noteMainActivity.noteIdForDetails;
        a = 1;
    }

    public void modifyNoteTime() {
        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateStr = formatter.format(new Date());
        Note n = Note.findById(Note.class, Long.parseLong(noteid));
        n.setModifytime(currentDateStr);
        n.save();
    }



    public void cancel(View v){
        finish();
        Toast.makeText(getApplication(), "Photo Discarded", Toast.LENGTH_LONG).show();
    }

    public void setImage(Uri mediaUri) throws IOException {
        // Converting Uri to Bitmap
        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), mediaUri);
        int deviceWidth = getWindowManager().getDefaultDisplay().getWidth();
        int deviceHeight = getWindowManager().getDefaultDisplay().getHeight();
        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();
        Bitmap scale = bitmap.createScaledBitmap(bitmap, deviceWidth, deviceHeight, false);
        if(imageWidth > imageHeight) // landscape
            scale = bitmap.createScaledBitmap(bitmap, deviceHeight, deviceWidth, false);
        else if (imageWidth < imageHeight) // portrait
            scale = bitmap.createScaledBitmap(bitmap, deviceWidth, deviceHeight, false);
        image.setImageBitmap(scale);

        // Setting bitmap to ImageView
    }

}
