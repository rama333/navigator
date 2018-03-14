package ru.rt.navigator.view;

import java.util.List;

/**
 * Created by ramil on 15.11.2017.
 */

public class RequestBody {

    private long districtId;
    private String realizationForm;
    private String paidForm;
    private List<String> childCategory;
    private int minAge;
    private int maxAge;
    private boolean isTech;
    private boolean isArtisticallyAesthetic;
    private boolean isNatural;
    private boolean isSport;
    private boolean isCivilPatriotic;
    private boolean isSocio;
    private boolean isTouristic;

    public RequestBody(long districtId, String realizationForm, String paidForm, List<String> childCategory, int minAge, int maxAge, boolean isTech, boolean isArtisticallyAesthetic, boolean isNatural, boolean isSport, boolean isCivilPatriotic, boolean isSocio, boolean isTouristic) {
        this.districtId = districtId;
        this.realizationForm = realizationForm;
        this.paidForm = paidForm;
        this.childCategory = childCategory;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.isTech = isTech;
        this.isArtisticallyAesthetic = isArtisticallyAesthetic;
        this.isNatural = isNatural;
        this.isSport = isSport;
        this.isCivilPatriotic = isCivilPatriotic;
        this.isSocio = isSocio;
        this.isTouristic = isTouristic;
    }

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    public String getRealizationForm() {
        return realizationForm;
    }

    public void setRealizationForm(String realizationForm) {
        this.realizationForm = realizationForm;
    }

    public String getPaidForm() {
        return paidForm;
    }

    public void setPaidForm(String paidForm) {
        this.paidForm = paidForm;
    }

    public List<String> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(List<String> childCategory) {
        this.childCategory = childCategory;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public boolean isTech() {
        return isTech;
    }

    public void setTech(boolean tech) {
        isTech = tech;
    }

    public boolean isArtisticallyAesthetic() {
        return isArtisticallyAesthetic;
    }

    public void setArtisticallyAesthetic(boolean artisticallyAesthetic) {
        isArtisticallyAesthetic = artisticallyAesthetic;
    }

    public boolean isNatural() {
        return isNatural;
    }

    public void setNatural(boolean natural) {
        isNatural = natural;
    }

    public boolean isSport() {
        return isSport;
    }

    public void setSport(boolean sport) {
        isSport = sport;
    }

    public boolean isCivilPatriotic() {
        return isCivilPatriotic;
    }

    public void setCivilPatriotic(boolean civilPatriotic) {
        isCivilPatriotic = civilPatriotic;
    }

    public boolean isSocio() {
        return isSocio;
    }

    public void setSocio(boolean socio) {
        isSocio = socio;
    }

    public boolean isTouristic() {
        return isTouristic;
    }

    public void setTouristic(boolean touristic) {
        isTouristic = touristic;
    }
}