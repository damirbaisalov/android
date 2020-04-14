package com.example.vkfragment;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.vkfragment.models.News;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;
    @Nullable private ItemClickListener listener;

    public NewsAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
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


        holder.likeNum.setText(String.valueOf(news.getLikeNum()));
        holder.commentNum.setText(String.valueOf(news.getCommentNum()));
        holder.shareNum.setText(String.valueOf(news.getShareNum()));

        if (news.getLiked()==1) {
            Glide.with(holder.likeBtn.getContext()).load(R.drawable.ic_like).into(holder.likeBtn);
        } else{
            Glide.with(holder.likeBtn.getContext()).load(R.drawable.ic_favorite_black).into(holder.likeBtn);
        }

        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (listener!= null) {
                    if (news.getLiked() == 1) {
                             FavoritesFragment.favoriteNews.remove(news); //remove news from favorite
                        news.setLiked(0);
                        news.setLikeNum(news.getLikeNum() - 1);
                        holder.likeBtn.setImageResource(R.drawable.ic_favorite_black);
                        holder.likeNum.setText(Integer.toString(news.getLikeNum()));
                        Toast toast = Toast.makeText(v.getContext(),
                                "Like removed!",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                    } else {
                        news.setLiked(1);
                        news.setLikeNum(news.getLikeNum() + 1);
                        holder.likeBtn.setImageResource(R.drawable.ic_like);
                        holder.likeNum.setText(Integer.toString(news.getLikeNum()));
                            FavoritesFragment.favoriteNews.add(news); //add news to favorite list
                        Toast toast1 = Toast.makeText(v.getContext(),
                                "Like done!",
                                Toast.LENGTH_LONG);
                        toast1.setGravity(Gravity.CENTER, 0, 0);
                        toast1.show();
                    }
                }
            }

        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, news);
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
        TextView likeNum;
        TextView commentNum;
        TextView shareNum;
        ImageButton likeBtn;

        public ViewHolder(View itemView){
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            timeName = itemView.findViewById(R.id.time_name);
            contentName = itemView.findViewById(R.id.content_name);
            contentImage = itemView.findViewById(R.id.content_image);
            likeBtn = itemView.findViewById(R.id.ic_like_logo);
            likeNum = itemView.findViewById(R.id.like_num);
            commentNum = itemView.findViewById(R.id.comment_num);
            shareNum = itemView.findViewById(R.id.share_num);
        }
    }
    interface ItemClickListener {
        void itemClick(int position, News item);

    }
}
