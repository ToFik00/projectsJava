package ru.itis.inf304.lab27;

public enum DiscountCategory {
    STANDARD(100),
    PENSIONER(80);
    final int percent;

    DiscountCategory(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
