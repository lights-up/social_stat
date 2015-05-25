package by.lightsup.socialstat.entity;

import org.json.simple.JSONObject;

/**
 * Created by note on 25.05.2015.
 */
public class MediaContent {
    private String url;
    private int width;
    private int height;

    private MediaContent() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaContent that = (MediaContent) o;

        if (width != that.width) return false;
        if (height != that.height) return false;
        return !(url != null ? !url.equals(that.url) : that.url != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "MediaContent{" +
                "height=" + height +
                ", url='" + url + '\'' +
                ", width=" + width +
                '}';
    }

    public static MediaContent newInstance(JSONObject mediaObject) {
        MediaContent mediaContent = new MediaContent();
        JSONObject imageObject = (JSONObject) mediaObject.get("standard_resolution");
        mediaContent.setUrl(imageObject.get("url").toString());
        mediaContent.setWidth(Integer.parseInt(imageObject.get("width").toString()));
        mediaContent.setHeight(Integer.parseInt(imageObject.get("height").toString()));
        return mediaContent;
    }
}
