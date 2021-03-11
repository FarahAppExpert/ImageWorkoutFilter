package com.example.imageworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.zomato.photofilters.geometry.Point;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ColorOverlaySubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.ToneCurveSubFilter;
import com.zomato.photofilters.imageprocessors.subfilters.VignetteSubFilter;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    static
    {
        System.loadLibrary("NativeImageProcessor");
    }

    ImageView Image;
    Button UploadPhoto;
    final static int PickImage = 100;
    Uri ImageUri;
    ImageView Image1;
    ImageView Image2;
    ImageView Image3;
    ImageView Image4;
    ImageView Image5;
    ImageView Image6;
    ImageView Image7;
    ImageView Image8;
    ImageView Image9;
    ImageView Image10;
    ImageView Image11;
    ImageView Image12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Image = (ImageView) findViewById(R.id.image);
        UploadPhoto = (Button) findViewById(R.id.uploadphoto);
        Image1 = (ImageView) findViewById(R.id.image1);
        Image2 = (ImageView) findViewById(R.id.image2);
        Image3 = (ImageView) findViewById(R.id.image3);
        Image4 = (ImageView) findViewById(R.id.image4);
        Image5 = (ImageView) findViewById(R.id.image5);
        Image6 = (ImageView) findViewById(R.id.image6);
        Image7 = (ImageView) findViewById(R.id.image7);
        Image8 = (ImageView) findViewById(R.id.image8);
        Image9 = (ImageView) findViewById(R.id.image9);
        Image10 = (ImageView) findViewById(R.id.image10);
        Image11 = (ImageView) findViewById(R.id.image11);
        Image12 = (ImageView) findViewById(R.id.image12);

        UploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               getUploadImage();
            }
        });

      Image1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              TranslateAnimation trans;
              trans = new TranslateAnimation(1, 200, 2, 200);
              trans.setDuration(500);
              Image.startAnimation(trans);


          }
      });

      Image2.setOnClickListener(new View.OnClickListener()
      {
          @Override
          public void onClick(View v)
          {
              TranslateAnimation trans;
              trans = new TranslateAnimation(200, 1, 200, 2);
              trans.setDuration(500);
              Image.startAnimation(trans);
          }
      });

      Image3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              ScaleAnimation scale;
              scale = new ScaleAnimation(2, 200, 2, 200);
              scale.setDuration(500);
              Image.startAnimation(scale);
          }
      });


      Image4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              ScaleAnimation scale;
              scale = new ScaleAnimation(200, 2, 200, 2);
              scale.setDuration(500);
              Image.startAnimation(scale);
          }
      });

      Image5.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              RotateAnimation rotate;
              rotate = new RotateAnimation(0, 360);
              rotate.setDuration(1000);
              Image.startAnimation(rotate);
          }
      });

      Image6.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              RotateAnimation rotate;
              rotate = new RotateAnimation(360, 0);
              rotate.setDuration(1000);
              Image.startAnimation(rotate);

          }
      });

        Image7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlphaAnimation alpha;
                alpha = new AlphaAnimation(0, 500);
                alpha.setDuration(1000);
                Image.startAnimation(alpha);
            }
        });

        Image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new ColorOverlaySubFilter(100, .2f, .2f, .0f));
                BitmapDrawable drawable = (BitmapDrawable) Image.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Bitmap bitmapimage = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage = myFilter.processFilter(bitmapimage);
                Image.setImageBitmap(outputImage);
            }
        });

        Image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new ContrastSubFilter(1.2f));
                BitmapDrawable drawable = (BitmapDrawable) Image.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Bitmap bitmapimage = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage = myFilter.processFilter(bitmapimage);
                Image.setImageBitmap(outputImage);
            }
        });

        Image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Filter myFilter = new Filter();
                Point[] rgbKnots;
                rgbKnots = new Point[3];
                rgbKnots[0] = new Point(0, 0);
                rgbKnots[1] = new Point(175, 139);
                rgbKnots[2] = new Point(255, 255);

                myFilter.addSubFilter(new ToneCurveSubFilter(rgbKnots, null, null, null));
                BitmapDrawable drawable = (BitmapDrawable) Image.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Bitmap bitmapimage = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage = myFilter.processFilter(bitmapimage);
                Image.setImageBitmap(outputImage);
            }
        });
        Image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new BrightnessSubFilter(30));
                myFilter.addSubFilter(new ContrastSubFilter(1.1f));
                BitmapDrawable drawable = (BitmapDrawable) Image.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Bitmap bitmapimage = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage = myFilter.processFilter(bitmapimage);
                Image.setImageBitmap(outputImage);

            }
        });

        Image12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Filter myFilter = new Filter();
                myFilter.addSubFilter(new BrightnessSubFilter(-30));
                BitmapDrawable drawable = (BitmapDrawable) Image.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                Bitmap bitmapimage = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Bitmap outputImage = myFilter.processFilter(bitmapimage);
                Image.setImageBitmap(outputImage);
            }
        });

    }

    public void getUploadImage ()
    {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PickImage);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
           super.onActivityResult(requestCode, resultCode, data);
           if(resultCode == RESULT_OK && requestCode == PickImage)
           {
               ImageUri = data.getData();
               Image.setImageURI(ImageUri);
               Image1.setImageURI(ImageUri);
               Image2.setImageURI(ImageUri);
               Image3.setImageURI(ImageUri);
               Image4.setImageURI(ImageUri);
               Image5.setImageURI(ImageUri);
               Image6.setImageURI(ImageUri);
               Image7.setImageURI(ImageUri);
               Image8.setImageURI(ImageUri);
               Image9.setImageURI(ImageUri);
               Image10.setImageURI(ImageUri);
               Image11.setImageURI(ImageUri);
               Image12.setImageURI(ImageUri);
           }
    }

    }
