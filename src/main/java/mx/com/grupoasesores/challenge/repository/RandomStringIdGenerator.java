package mx.com.grupoasesores.challenge.repository;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.Random;

public class RandomStringIdGenerator implements IdentifierGenerator {

    private static final int ID_LENGTH = 10;
    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        StringBuilder generatedId = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < ID_LENGTH; i++) {
            int randomIndex = random.nextInt(CHAR_POOL.length());
            generatedId.append(CHAR_POOL.charAt(randomIndex));
        }

        return generatedId.toString();
    }
}
