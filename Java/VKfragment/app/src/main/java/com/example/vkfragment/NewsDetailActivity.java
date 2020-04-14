package com.example.vkfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vkfragment.models.News;

public class NewsDetailActivity extends AppCompatActivity {

    ImageView imageViewIntentResult;
    TextView imageName;
    TextView timeName;
    TextView contentName;
    ImageView contentImage;
    TextView likeNum;
    TextView shareNum;
    TextView viewsNum;
    ImageButton likedBtn;
    ImageButton leftBar;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        imageViewIntentResult = findViewById(R.id.image);
        imageName = findViewById(R.id.image_name);
        timeName = findViewById(R.id.time_name);
        contentName = findViewById(R.id.content_name);
        contentImage = findViewById(R.id.content_image);
        likeNum = findViewById(R.id.like_num);
        shareNum = findViewById(R.id.share_num);
        viewsNum = findViewById(R.id.views_num);
        likedBtn = findViewById(R.id.ic_like_logo);

        mEdit = findViewById(R.id.editComment);
        mEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mEdit.setFocusableInTouchMode(true); //to enable it
            }
        });

        final News news = (News) getIntent().getParcelableExtra("news"); //fetch detail news
        Glide.with(imageViewIntentResult.getContext()).load(news.getImage()).into(imageViewIntentResult);
        Glide.with(contentImage.getContext()).load(news.getContentImage()).into(contentImage);
        imageName.setText(news.getImageName());
        timeName.setText(news.getTimeName());
        contentName.setText(news.getContentName());
        likeNum.setText(String.valueOf(news.getLikeNum()));
        shareNum.setText(String.valueOf(news.getShareNum()));
        viewsNum.setText(String.valueOf(news.getViewsNum()));

        if (news.getLiked()==0)
            Glide.with(likedBtn.getContext()).load(R.drawable.ic_favorite_black).into(likedBtn);
        else
            Glide.with(likedBtn.getContext()).load(R.drawable.ic_like).into(likedBtn);

        leftBar = findViewById(R.id.leftbar);
        leftBar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(NewsDetailActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        likedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = likeNum.getText().toString();
                int i = Integer.parseInt(temp);
                if (news.getLiked()==1) {
                    news.setLiked(0);
                    i=i-1;
                    likeNum.setText(String.valueOf(i));
                    news.setLikeNum(news.getLikeNum()-1);
                    likedBtn.setImageResource(R.drawable.ic_favorite_black);
                    Toast toast = Toast.makeText(v.getContext(),
                            "Like removed!",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                } else {
                    i=i+1;
                    news.setLiked(1);
                    likedBtn.setImageResource(R.drawable.ic_like);
                    likeNum.setText(String.valueOf(i));
                    Toast toast1 = Toast.makeText(v.getContext(),
                            "Like done!",
                            Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.CENTER,0,0);
                    toast1.show();
                }
            }

        });

    }

}
