package day05;

import org.junit.Test;

public class C01_Notasyon {

    // Javadaki gibi selenium'da da belirli islevleri yapan method'lar olusturabiliriz
    // ancak bu method'lar cagrilmdikca CALISMAZLAR
    public void ilkTestMethodu(){
        System.out.println("Ilk test methodumuz");
    }


    // JUnit ile notasyon kullanarak siradan method'lari test method'una donusturebiliriz
    // Bir Test method'u bagimsiz olarak calisabilen test yapmamiza imkan verir
    // @Test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    @Test
    public void notasyonluIlkTestMethodu(){
        System.out.println("notasyonlu ilk test methodumuz");
    }

}
