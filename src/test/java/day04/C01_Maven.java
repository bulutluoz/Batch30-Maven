package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        // class'in basinda implicitlywait komutu yazilirsa
        // bu test boyunca her locator icin driver maximum yazilan zaman kadar bekler

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim


        //WebElement sonucYazisiElementi=driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        // By.className ile locate ettigimiz webelementinde class attribute'nun degerinde
        // bosluk varsa locator saglikli calismayabilir
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());
        //5- Ilk urunu tiklayalim
        //WebElement ilkUrunElementi=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        //ilkUrunElementi.click();
        // sadece bir click yapacaksak webelemnt olusturmaya ve assign etmeye gerek yok
        // direk locate edip sonra click yapabiliriz
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        Thread.sleep(3000);
        //6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

        List<WebElement> urunlerListesi= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each:urunlerListesi
             ) {
            System.out.println(each.getText());
        }

    }

}
