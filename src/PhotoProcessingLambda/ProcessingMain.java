package PhotoProcessingLambda;

import java.util.Scanner;

public class ProcessingMain {
    public static void main(String[] args) {
       String pathToFile = "C:\\Users\\30.07.2018\\Desktop\\www\\1.jpg";
       System.out.println("В каком цветовом фильтре сохранить картинку\n"+
                "фильтры:\n" +
                "- монохромный - монохромный (написать)\n" +
                "- только красный компонент пикселей - красный (написать)\n" +
                "- только зеленый компонент пикселей - зеленый (написать)\n" +
                "- только синий компонент пикселей   - синий   (написать)\n" +
                "- сепия - сепия (написать)");

       boolean tryAgain = true; // Устанавливаем Истина для входа в цикл, в конце цикла вызываем статик переменную класса,
                                // использовать объект класса не удобно, нужно дополнительно создавать код для получения нужного результат
                                // статик переменная принадлежит классу и установленное значение внутри класса можно вызвать
       while(tryAgain) {

           Scanner scanner = new Scanner(System.in);
           String filters = scanner.nextLine();
           SetGetFilters.getFilter(filters);
           /*
           создаем объект класса, вызываем метод в него передаем путь к файлу и фильтр пользователя
            */
           ReadAndWrite readAndWrite = new ReadAndWrite();
           readAndWrite.getFile(pathToFile);
           // вызываем статик переменную класса с нужным значением
           tryAgain = SetGetFilters.again;
       }
    }
}
