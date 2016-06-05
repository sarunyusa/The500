
package th.sarunyu.the500.dao.photoitem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable {

    @SerializedName("id") private int id;
    @SerializedName("user_id") private int userId;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("image_url") private String imageUrl;
    @SerializedName("user") private User user;
    @SerializedName("images") private ArrayList<Image> images;

    protected Photo(Parcel in) {
        id = in.readInt();
        userId = in.readInt();
        name = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        images = in.createTypedArrayList(Image.CREATOR);
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(userId);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeParcelable(user, flags);
        dest.writeTypedList(images);
    }
}
