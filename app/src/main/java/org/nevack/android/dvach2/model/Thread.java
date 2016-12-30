
package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Thread {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    /**
     *
     * @return
     * The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     * The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
