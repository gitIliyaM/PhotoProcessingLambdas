package PhotoProcessingLambda;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StoreAndProcessPixels {
    int width, height;
    BufferedImage bufferedImage;
    int[] pixels;
    StoreAndProcessPixels(BufferedImage imageBuffered) throws Exception {
        this.bufferedImage = imageBuffered;
        this.width = imageBuffered.getWidth();
        this.height = imageBuffered.getHeight();
        pixels = imageBuffered.getRGB(0,0,width,height,null,0,width);
        getPixels(pixels); // метод с циклом для изменения фото
    }
    void getPixels(int[] pixel) throws Exception {
        SetGetFilters setGetFilters = new SetGetFilters();
        for(int i=0; i< pixels.length; i++){
            float[] floatRGB = getFloatRGB(pixel[i]);
            float[] newFloatRGB = getProcessingPixels(rgb -> setGetFilters.changePixels(rgb), floatRGB);
            pixels[i] = gerIntRGB(newFloatRGB);
        }
        bufferedImage.setRGB(0,0,width,height,pixels,0,width); // устанавливаем в новое фото все измененные числа (пиксели)
    }
    // метод получает одно число (пиксель) с фото обрабатывается классом Color для получения компонентов RGB возвращает массив из
    // трех чисел RGB
    float[] getFloatRGB(int pixels){
        Color color = new Color(pixels);
        return color.getRGBColorComponents(null);
    }
    // Метод - с параметров от интерфейса, в интерфейсе метод без тела. Принимает массив из трех чисел RGB, массив передается лямбду.
    // Лямбда, которая передается в другой метод (метод фильтр), и фильтр пользователя, другом методе изменяется фото
    float[] getProcessingPixels(ImageProcessing imageProcessing, float[] floatRGBS){
        return imageProcessing.execute(floatRGBS);
    }
    // Метод принимает массив из чисел RGB, которые преобразует в одно число (пиксель) из цвета, возвращает это число в массив из чисел (пикселей)
    int gerIntRGB(float[] newFloatRGB) throws Exception {
        Color color = null;
        if(newFloatRGB.length == 3){
            color = new Color(newFloatRGB[0], newFloatRGB[1], newFloatRGB[2]);
        } else if(newFloatRGB.length==4){
            color = new Color(newFloatRGB[0], newFloatRGB[1], newFloatRGB[2], newFloatRGB[3]);
        }
        if(color!=null){
            return color.getRGB();
        } throw new Exception("");
    }
}
