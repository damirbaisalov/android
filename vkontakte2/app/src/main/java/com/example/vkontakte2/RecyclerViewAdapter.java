package com.example.vkontakte2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<News> newsList;
    private ItemClickListener listener;



    public RecyclerViewAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public RecyclerViewAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem, null, false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final News news = newsList.get(position);

        holder.imageName.setText(news.getImageName());
        holder.timeName.setText(news.getTimeName());
        holder.contentName.setText(news.getContentName());

        Glide.with(holder.image.getContext()).load(news.getImage()).into(holder.image);
        Glide.with(holder.contentImage.getContext()).load(news.getContentImage()).into(holder.contentImage);

//        Picasso.with(holder.image.getContext()).load(news.getImage()).into(holder.image);
//        Picasso.with(holder.contentImage.getContext()).load(news.getContentImage()).into(holder.contentImage);

        holder.likeNum.setText(String.valueOf(news.getLikeNum()));
        holder.commentNum.setText(String.valueOf(news.getCommentNum()));
        holder.shareNum.setText(String.valueOf(news.getShareNum()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, news);
                }
            }
        });

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    if (news.getLiked()==1) {
                        news.setLiked(0);
                        news.setLikeNum(news.getLikeNum()-1);
                        holder.like.setImageResource(R.drawable.ic_favorite_black);
                        holder.likeNum.setText(Integer.toString(news.getLikeNum()));
                        Toast toast = Toast.makeText(v.getContext(),
                                "Like removed!",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    } else {
                        news.setLiked(1);
                        news.setLikeNum(news.getLikeNum()+1);
                        holder.like.setImageResource(R.drawable.ic_like);
                        holder.likeNum.setText(Integer.toString(news.getLikeNum()));

                        Toast toast1 = Toast.makeText(v.getContext(),
                                "Like done!",
                                Toast.LENGTH_LONG);
                        toast1.setGravity(Gravity.CENTER,0,0);
                        toast1.show();
                    }
                }
            }
        });



    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        TextView timeName;
        TextView contentName;
        ImageView contentImage;
//        LinearLayout toolTrio;
        ImageButton icLike;
//        ImageButton icComment;
//        ImageButton icShare;
//        RelativeLayout parentLayout;
        TextView likeNum;
        TextView commentNum;
        TextView shareNum;
        ImageButton like;

        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            timeName = itemView.findViewById(R.id.time_name);
            contentName = itemView.findViewById(R.id.content_name);
            contentImage = itemView.findViewById(R.id.content_image);
//            toolTrio = itemView.findViewById(R.id.like_bar);
//            icLike = itemView.findViewById(R.id.ic_favorite);
//            icComment = itemView.findViewById(R.id.ic_comment);
//            icShare = itemView.findViewById(R.id.ic_share);
//            parentLayout = itemView.findViewById(R.id.parent_layout);
            like = itemView.findViewById(R.id.ic_favorite);
            likeNum = itemView.findViewById(R.id.like_num);
            commentNum = itemView.findViewById(R.id.comment_num);
            shareNum = itemView.findViewById(R.id.share_num);
        }
    }
    interface ItemClickListener {
        void itemClick(int position, News item);
    }
}
