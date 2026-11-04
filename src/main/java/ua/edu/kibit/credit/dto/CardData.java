package ua.edu.kibit.credit.dto;

public class CardData {

    private String email;

    private Integer amount;

    public CardData() {
    }

    public CardData(String email, Integer amount) {
        this.email = email;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
