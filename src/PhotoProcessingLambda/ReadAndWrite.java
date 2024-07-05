package PhotoProcessingLambda;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndWrite {
    // Метод получает строку к файлу, идет проверка на правильный формат
    // Истина - Читаем путь к файлу, создается объект класса (хранить и обрабатывать пиксели) ему передается
    // ссылка (тип Буфер изображения) на объект (тип Файл)
    // Ложь - вызывается исключение с текстом, которое ловится с выводом сообщения.
    // Сделал проброс исключения не в методе (встроенные), а в теле метода (решил изменить структуру кода)
    void getFile(String path) {
        File file = new File(path); // путь к файлу
        try{
            if(getFormat(file)){ // проверка формата файла
                BufferedImage bufferedImage = ImageIO.read(file); // чтение файла из папки
                StoreAndProcessPixels storeAndProcessPixels = new StoreAndProcessPixels(bufferedImage); // создаем объект класса (конструктор) в него передаем прочитанное изображение и фильтр пользователя
                bufferedImage = storeAndProcessPixels.bufferedImage; // получаем измененное изображение после обработки фильтром
                saveImage(bufferedImage);// сохраняем изображение (передаем его в метод)
            } else {
                throw new Exception("Файл не соответствует нужному формату или он не существует");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // Метод получает объект типа File с путем к файлу, внутри преобразуем к строке, находим индекс точки,
    // получаем подстроку от файла (строки) со строковым форматом. Проверяем с нужным форматом
    // возвращает Истина или Ложь
    boolean getFormat(File file){
        String fullNameFile = file.toString();
        int indexFormat = fullNameFile.lastIndexOf(".")+1;
        String format = fullNameFile.substring(indexFormat);
        switch(format){
            case "png","jpg","jpeg": return true;
        }
        return false;
    }
    // Метод - сохраняем фото с новым именем, оставляя старое фото не измененное
    void saveImage(BufferedImage bufferedImage){
        String file = "C:\\Users\\30.07.2018\\Desktop\\www\\2.jpg";
        File path = new File(file);
        try{
            ImageIO.write(bufferedImage,"jpg", path);
        } catch (IOException e){
            System.out.println("Не удалось записать файл");
        }
    }
}
