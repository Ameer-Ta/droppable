package com.droppable;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class droppable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thasleem\\Downloads\\chromedriverwin\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.way2automation.com/demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//*[text()='Registration'])[1]")).click();
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> i1=wh.iterator();
		String mainwindow=driver.getWindowHandle();
		System.out.print(mainwindow);
		System.out.print(wh);

		while(i1.hasNext())
		{
			String childwindow=i1.next(); 
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				driver.switchTo().window(childwindow);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@id='load_box']//a[@class='fancybox'][normalize-space()='ENTER TO THE TESTING WEBSITE']")).click();
				driver.findElement(By.xpath("//*[@id='wrapper']/div/div/div[1]/ul/li[2]/a/figure")).click();

				Set<String> wh1=driver.getWindowHandles();
				Iterator<String> i2=wh1.iterator();
				while(i2.hasNext())
				{
					String childwindow1=i2.next(); 
					if(!mainwindow.equalsIgnoreCase(childwindow1) && !childwindow.equalsIgnoreCase(childwindow1))
					{
						driver.switchTo().window(childwindow1);
						Thread.sleep(3000);
						driver.switchTo().frame(0);
						WebElement e=driver.findElement(By.xpath("//*[@id='draggable']"));
						WebElement e1=driver.findElement(By.xpath("//*[@id='droppable']"));
						Actions a=new Actions(driver);
						a.dragAndDrop(e, e1).build().perform();

						a.release(e).build().perform();
						driver.switchTo().defaultContent();
					}
				}
				driver.findElement(By.xpath("//a[normalize-space()='Accept']")).click();
				driver.switchTo().frame(1);
				WebElement e2=driver.findElement(By.xpath("//div[@id='draggable']"));
				WebElement e3=driver.findElement(By.xpath("//div[@id='droppable']"));
				Actions b=new Actions(driver);
				b.dragAndDrop(e2, e3).build().perform();

				b.release(e2).build().perform();
				driver.switchTo().defaultContent();
			}
		}
				driver.findElement(By.xpath("//a[normalize-space()='Prevent propagation']")).click();
				driver.switchTo().frame(2);
				WebElement e4=driver.findElement(By.xpath("//div[@id='draggable']"));
				WebElement e5=driver.findElement(By.xpath("//div[@id='droppable2-inner']"));
				Actions c=new Actions(driver);
				c.dragAndDrop(e4, e5).build().perform();

				c.release(e4).build().perform();
				driver.switchTo().defaultContent();
	

WebElement e6=driver.findElement(By.xpath("//div[@id='draggable']"));
WebElement e7=driver.findElement(By.xpath("//div[@id='droppable']"));
Actions d=new Actions(driver);
d.dragAndDrop(e6, e7).build().perform();

d.release(e6).build().perform();
driver.switchTo().defaultContent();
				
			}

		}

