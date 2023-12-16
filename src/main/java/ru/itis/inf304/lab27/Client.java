package ru.itis.inf304.lab27;

public class Client extends Human {
    Gender gender;
    DiscountCategory discountCategory;

    public Client(Gender gender, DiscountCategory discountCategory) {
        this.gender = gender;
        this.discountCategory = discountCategory;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DiscountCategory getDiscountCategory() {
        return discountCategory;
    }

    public void setDiscountCategory(DiscountCategory discountCategory) {
        this.discountCategory = discountCategory;
    }
}
