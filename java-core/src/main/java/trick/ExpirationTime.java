package trick;

import lombok.Data;

import java.time.Instant;

@Data
public class ExpirationTime {

    private long expirationTime;

    public boolean expiredTime() { // expiredTime
        return Instant.now().toEpochMilli() > expirationTime;
    }

}
