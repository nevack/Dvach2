package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BoardSettings {
    @SerializedName("enabled")
    @Expose
    private Integer enabled;
    @SerializedName("result")
    @Expose
    private Integer result;
    @SerializedName("types")
    @Expose
    private List<CaptchaType> types = null;

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<CaptchaType> getTypes() {
        return types;
    }

    public void setTypes(List<CaptchaType> types) {
        this.types = types;
    }
}
