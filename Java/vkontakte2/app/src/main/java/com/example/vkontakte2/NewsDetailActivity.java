package com.example.vkontakte2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NewsDetailActivity extends AppCompatActivity {

    private ImageView imageViewIntentResult;
    TextView imageName;
    TextView timeName;
    TextView contentName;
    ImageView contentImage;
    LinearLayout toolTrio;
    ImageButton icLike;
    ImageButton icComment;
    ImageButton icShare;
    RelativeLayout parentLayout;
    TextView likeNum;
    TextView commentNum;
    TextView shareNum;
    TextView viewsNum;
    boolean isLiked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        imageViewIntentResult = findViewById(R.id.image);
        imageName = findViewById(R.id.image_name);
        timeName = findViewById(R.id.time_name);
        contentName = findViewById(R.id.content_name);
        contentImage = findViewById(R.id.content_image);
//        toolTrio = findViewById(R.id.like_bar);
//        icLike = findViewById(R.id.ic_like);
//        icComment = findViewById(R.id.ic_comment);
//        icShare = findViewById(R.id.ic_share);
        likeNum = findViewById(R.id.like_num);
        shareNum = findViewById(R.id.share_num);
        viewsNum = findViewById(R.id.views_num);


        final News news = (News) getIntent().getParcelableExtra("news");
        Glide.with(imageViewIntentResult.getContext()).load(news.getImage()).into(imageViewIntentResult);
        Glide.with(contentImage.getContext()).load(news.getContentImage()).into(contentImage);
        imageName.setText(news.getImageName());
        timeName.setText(news.getTimeName());
        contentName.setText(news.getContentName());
        likeNum.setText(String.valueOf(news.getLikeNum()));
        shareNum.setText(String.valueOf(news.getShareNum()));
        viewsNum.setText(String.valueOf(news.getViewsNum()));


        ImageButton leftBar = findViewById(R.id.leftbar);

        leftBar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(NewsDetailActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        final ImageButton  like = findViewById(R.id.ic_favorite);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = likeNum.getText().toString();
                int i = Integer.parseInt(temp);
                    if (isLiked==true) {
                        isLiked=false;
                        i=i-1;
                        likeNum.setText(String.valueOf(i));
                        like.setImageResource(R.drawable.ic_favorite_black);
                        Toast toast = Toast.makeText(v.getContext(),
                                "Like removed!",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    } else {
                        i=i+1;
//                        news.setLiked(1);
//                        news.setLikeNum(news.getLikeNum()+1);
                       like.setImageResource(R.drawable.ic_like);
                        likeNum.setText(String.valueOf(i));

                        Toast toast1 = Toast.makeText(v.getContext(),
                                "Like done!",
                                Toast.LENGTH_LONG);
                        toast1.setGravity(Gravity.CENTER,0,0);
                        toast1.show();
                        isLiked=true;
                    }
                }

        });

    }
}