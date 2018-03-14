package ru.rt.navigator.view.dto;

import java.util.List;

/**
 * Created by ramil on 20.11.2017.
 */

public class ProgramDto {
    private String nameIntitution;
    private Long idIntitution;
    private String districtIntitution;
    private String addressIntitution;
    private String phone;

    private Long id;
    private String title;
    private String startDate;
    private String finishDate;
    private String description;
    private int minAge;
    private int maxAge;
    private String paidForm;
    private String realizationForm;
    private List<String> childCategory;

    public ProgramDto(String nameIntitution, Long idIntitution, String districtIntitution, String addressIntitution, String phone, Long id, String title, String startDate, String finishDate, String description, int minAge, int maxAge, String paidForm, String realizationForm, List<String> childCategory) {
        this.nameIntitution = nameIntitution;
        this.idIntitution = idIntitution;
        this.districtIntitution = districtIntitution;
        this.addressIntitution = addressIntitution;
        this.phone = phone;
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.paidForm = paidForm;
        this.realizationForm = realizationForm;
        this.childCategory = childCategory;
    }

    public String getNameIntitution() {
        return nameIntitution;
    }

    public void setNameIntitution(String nameIntitution) {
        this.nameIntitution = nameIntitution;
    }

    public Long getIdIntitution() {
        return idIntitution;
    }

    public void setIdIntitution(Long idIntitution) {
        this.idIntitution = idIntitution;
    }

    public String getDistrictIntitution() {
        return districtIntitution;
    }

    public void setDistrictIntitution(String districtIntitution) {
        this.districtIntitution = districtIntitution;
    }

    public String getAddressIntitution() {
        return addressIntitution;
    }

    public void setAddressIntitution(String addressIntitution) {
        this.addressIntitution = addressIntitution;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPaidForm() {
        return paidForm;
    }

    public void setPaidForm(String paidForm) {
        this.paidForm = paidForm;
    }

    public String getRealizationForm() {
        return realizationForm;
    }

    public void setRealizationForm(String realizationForm) {
        this.realizationForm = realizationForm;
    }

    public List<String> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(List<String> childCategory) {
        this.childCategory = childCategory;
    }
}
