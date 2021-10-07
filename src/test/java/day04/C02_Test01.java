package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualTitle=driver.getTitle();
        String arananKelime="Save";

        if (actualTitle.contains(arananKelime)){
            System.out.println("title " + arananKelime + " kelimesini iceriyor, test PASS");
        } else {
            System.out.println("title " + arananKelime + " kelimesini icermiyor, test FAILED");
        }

        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitle="Walmart.com | Save Money.Live Better";

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Sayfa title'i beklenen ile ayni, test PASS");
        } else{
            System.out.println("title beklenen ile ayni degil");
            System.out.println("actual title : " + actualTitle);
        }

        //7- URL in walmart.com icerdigini control edin
        String actualURL= driver.getCurrentUrl();
        String urlArananKelime="walmart.com";


        if (actualURL.contains(urlArananKelime)){
            System.out.println("URL "+ urlArananKelime + " kelimesini iceriyor test PASS");
        }else {
            System.out.println("URL "+ urlArananKelime + " kelimesini icermiyor test FAILED");
        }
        //8-”Nutella” icin arama yapiniz

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazisiElementi.getText());
        //10-Sayfayi kapatin
        driver.close();
    }
}
