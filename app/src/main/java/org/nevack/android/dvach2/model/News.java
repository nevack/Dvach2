
package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("subject")
    @Expose
    private String subject;

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The num
     */
    public String getNum() {
        return num;
    }

    /**
     * 
     * @param num
     *     The num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * 
     * @return
     *     The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * @param subject
     *     The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
