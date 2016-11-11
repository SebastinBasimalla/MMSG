package model;

import java.io.Serializable;

/**
 * Created by Sebastin on 6/5/2016.
 */
public class PeopleInfoData implements Serializable{

    private String peopleName;
    private Integer peopleUrl;

    public Integer getPeopleLargeURL() {
        return peopleLargeURL;
    }

    public void setPeopleLargeURL(Integer peopleLargeURL) {
        this.peopleLargeURL = peopleLargeURL;
    }

    private Integer peopleLargeURL;

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Integer getPeopleUrl() {
        return peopleUrl;
    }

    public void setPeopleUrl(Integer peopleUrl) {
        this.peopleUrl = peopleUrl;
    }
}