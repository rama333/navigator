package ru.rt.navigator.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ramil on 14.11.2017.
 */

public class ResponseBody {

    @SerializedName("institutions")
    List<IntitutionDto> institutions;

    public ResponseBody(List<IntitutionDto> institutions) {
        this.institutions = institutions;
    }

    public List<IntitutionDto> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<IntitutionDto> institutions) {
        this.institutions = institutions;
    }

    public class IntitutionDto {

        @SerializedName("name")
        String name;
        @SerializedName("id")
        Long id;
        @SerializedName("phone")
        String phone;
        @SerializedName("district")
        String district;
        @SerializedName("address")
        String address;
        @SerializedName("programs")
        List<ProgramDto> programs;
        @SerializedName("events")
        List<EventDto> events;

        public IntitutionDto(String name, Long id, String phone, String district, String address, List<ProgramDto> programs, List<EventDto> events) {
            this.name = name;
            this.id = id;
            this.phone = phone;
            this.district = district;
            this.address = address;
            this.programs = programs;
            this.events = events;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public List<ProgramDto> getPrograms() {
            return programs;
        }

        public void setPrograms(List<ProgramDto> programs) {
            this.programs = programs;
        }

        public List<EventDto> getEvents() {
            return events;
        }

        public void setEvents(List<EventDto> events) {
            this.events = events;
        }
    }

    public class ProgramDto {
        @SerializedName("id")
        Long id;
        @SerializedName("title")
        String title;
        @SerializedName("startDate")
        String startDate;
        @SerializedName("finishDate")
        String finishDate;
        @SerializedName("description")
        String description;
        @SerializedName("minAge")
        int minAge;
        @SerializedName("maxAge")
        int maxAge;
        @SerializedName("paidForm")
        String paidForm;
        @SerializedName("realizationForm")
        String realizationForm;
        @SerializedName("childCategory")
        private List<String> childCategory;

        public ProgramDto(Long id, String title, String startDate, String finishDate, String description, int minAge, int maxAge, String paidForm, String realizationForm, List<String> childCategory) {
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

    public class EventDto {
        @SerializedName("id")
        Long id;
        @SerializedName("title")
        String title;
        @SerializedName("startDate")
        String startDate;
        @SerializedName("finishDate")
        String finishDate;
        @SerializedName("description")
        String description;
        @SerializedName("minAge")
        int minAge;
        @SerializedName("maxAge")
        int maxAge;
        @SerializedName("paidForm")
        String paidForm;
        @SerializedName("realizationForm")
        String realizationForm;
        @SerializedName("file")
        String file;

        public EventDto(Long id, String title, String startDate, String finishDate, String description, int minAge, int maxAge, String paidForm, String realizationForm, String file) {
            this.id = id;
            this.title = title;
            this.startDate = startDate;
            this.finishDate = finishDate;
            this.description = description;
            this.minAge = minAge;
            this.maxAge = maxAge;
            this.paidForm = paidForm;
            this.realizationForm = realizationForm;
            this.file = file;
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

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }
}
