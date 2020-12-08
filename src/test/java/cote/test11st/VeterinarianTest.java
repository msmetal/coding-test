package cote.test11st;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VeterinarianTest {

    @Test
    public void test() {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        assertThat(veterinarian.heal()).isEqualTo("Barkley");
        assertThat(veterinarian.heal()).isEqualTo("Mittens");
        assertThat(veterinarian.heal()).isNull();
    }
}