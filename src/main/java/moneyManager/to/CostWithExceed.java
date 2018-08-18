package moneyManager.to;

import java.time.LocalDateTime;

/**
 * Created by Vladimir on 26.07.2018.
 */
public class CostWithExceed {
    private final Integer id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int price;

    private final boolean exceed;

    public CostWithExceed(Integer id, LocalDateTime dateTime, String description, int price, boolean exceed) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.price = price;
        this.exceed = exceed;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public boolean isExceed() {
        return exceed;
    }

    @Override
    public String toString() {
        return "CostWithExceed{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", exceed=" + exceed +
                '}';
    }
}