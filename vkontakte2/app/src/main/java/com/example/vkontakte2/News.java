package com.example.vkontakte2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class News implements Parcelable {
    private String imageName;
    private String timeName;
    private String contentName;
    private int image;
    private int contentImage;
    private int likeNum;
    private int commentNum;
    private int shareNum;
    private int viewsNum;

    private int liked;

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getShareNum() {
        return shareNum;
    }

    public void setShareNum(int shareNum) {
        this.shareNum = shareNum;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getLiked() {
        return liked;
    }

    public void setViewsNum(int viewsNum){
        this.viewsNum = viewsNum;
    }

    public int getViewsNum(){
        return viewsNum;
    }

    public News(
            String imageName,
            String timeName,
            String contentName,
            int image,
            int contentImage,
            int likeNum,
            int commentNum,
            int shareNum,
            int liked,
            int viewsNum) {
        this.imageName = imageName;
        this.timeName = timeName;
        this.contentName = contentName;
        this.image = image;
        this.contentImage = contentImage;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.shareNum = shareNum;
        this.liked = liked;
        this.viewsNum = viewsNum;
    }

    public String getImageName() {
        return imageName;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getContentImage() {
        return contentImage;
    }

    public void setContentImage(int contentImage) {
        this.contentImage = contentImage;
    }

    public String getTimeName() {
        return timeName;
    }

    public String getContentName() {
        return contentName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("News{");
        sb.append("imageName='").append(imageName).append('\'');
        sb.append(", timeName='").append(timeName).append('\'');
        sb.append(", contentName='").append(contentName).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", contentImage='").append(contentImage).append('\'');
        sb.append(", likeNum=' ").append(likeNum).append('\'');
        sb.append(", commentNum=' ").append(commentNum).append('\'');
        sb.append(", shareNum=' ").append(shareNum).append('\'');
        sb.append(", liked=' ").append(liked).append('\'');
        sb.append(", viewsNum=' ").append(viewsNum).append('\'');
        sb.append('}');
        return sb.toString();

    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageName);
        dest.writeString(this.timeName);
        dest.writeString(this.contentName);
        dest.writeInt(this.image);
        dest.writeInt(this.contentImage);
        dest.writeInt(this.likeNum);
        dest.writeInt(this.commentNum);
        dest.writeInt(this.shareNum);
        dest.writeInt(this.liked);
        dest.writeInt(this.viewsNum);

    }

    protected News(Parcel in) {
        this.imageName = in.readString();
        this.timeName = in.readString();
        this.contentName = in.readString();
        this.image = in.readInt();
        this.contentImage = in.readInt();
        this.likeNum = in.readInt();
        this.commentNum = in.readInt();
        this.shareNum = in.readInt();
        this.liked = in.readInt();
        this.viewsNum = in.readInt();
    }



    public static final Creator<News> CREATOR = new Creator<News>(){

        public News createFromParcel(Parcel source){
            return new News(source);
    }

        public News[] newArray(int size){
            return new News[size];
       }
    };

}