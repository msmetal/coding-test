package cote.beamin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptogramTest {

    @Test
    public void testEncrypt() {
        Cryptogram cryptogram = new Cryptogram();

        String result = cryptogram.encrypt("browoanoommnaon");
        assertThat(result).isEqualTo("brown");
    }
}