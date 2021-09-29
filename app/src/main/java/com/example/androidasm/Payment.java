package com.example.androidasm;

public class Payment {
    private String name;
    private String description;
    private String money;
    private String DateTime;
    private Category category;

    public Payment() {
    }

    public Payment(String name, String description, String money, String dateTime, Category category) {
        this.name = name;
        this.description = description;
        this.money = money;
        DateTime = dateTime;
        this.category = category;
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

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
