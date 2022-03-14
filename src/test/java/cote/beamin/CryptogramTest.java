package cote.beamin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CryptogramTest {

    @Test
    public void testEncrypt() {
        Cryptogram cryptogram = new Cryptogram();

        String result = cryptogram.encrypt("browoanoommnaon");
        assertThat(result).isEqualTo("brown");
    }
}