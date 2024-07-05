package PhotoProcessingLambda;

import java.util.Scanner;

public class ProcessingMain {
    public static void main(String[] args) {
       String pathToFile = "C:\\Users\\30.07.2018\\Desktop\\www\\1.jpg";
       System.out.println("� ����� �������� ������� ��������� ��������\n"+
                "�������:\n" +
                "- ����������� - ����������� (��������)\n" +
                "- ������ ������� ��������� �������� - ������� (��������)\n" +
                "- ������ ������� ��������� �������� - ������� (��������)\n" +
                "- ������ ����� ��������� ��������   - �����   (��������)\n" +
                "- ����� - ����� (��������)");

       boolean tryAgain = true; // ������������� ������ ��� ����� � ����, � ����� ����� �������� ������ ���������� ������,
                                // ������������ ������ ������ �� ������, ����� ������������� ��������� ��� ��� ��������� ������� ���������
                                // ������ ���������� ����������� ������ � ������������� �������� ������ ������ ����� �������
       while(tryAgain) {

           Scanner scanner = new Scanner(System.in);
           String filters = scanner.nextLine();
           SetGetFilters.getFilter(filters);
           /*
           ������� ������ ������, �������� ����� � ���� �������� ���� � ����� � ������ ������������
            */
           ReadAndWrite readAndWrite = new ReadAndWrite();
           readAndWrite.getFile(pathToFile);
           // �������� ������ ���������� ������ � ������ ���������
           tryAgain = SetGetFilters.again;
       }
    }
}
