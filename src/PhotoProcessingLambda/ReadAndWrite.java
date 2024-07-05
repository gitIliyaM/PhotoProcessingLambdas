package PhotoProcessingLambda;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadAndWrite {
    // ����� �������� ������ � �����, ���� �������� �� ���������� ������
    // ������ - ������ ���� � �����, ��������� ������ ������ (������� � ������������ �������) ��� ����������
    // ������ (��� ����� �����������) �� ������ (��� ����)
    // ���� - ���������� ���������� � �������, ������� ������� � ������� ���������.
    // ������ ������� ���������� �� � ������ (����������), � � ���� ������ (����� �������� ��������� ����)
    void getFile(String path) {
        File file = new File(path); // ���� � �����
        try{
            if(getFormat(file)){ // �������� ������� �����
                BufferedImage bufferedImage = ImageIO.read(file); // ������ ����� �� �����
                StoreAndProcessPixels storeAndProcessPixels = new StoreAndProcessPixels(bufferedImage); // ������� ������ ������ (�����������) � ���� �������� ����������� ����������� � ������ ������������
                bufferedImage = storeAndProcessPixels.bufferedImage; // �������� ���������� ����������� ����� ��������� ��������
                saveImage(bufferedImage);// ��������� ����������� (�������� ��� � �����)
            } else {
                throw new Exception("���� �� ������������� ������� ������� ��� �� �� ����������");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // ����� �������� ������ ���� File � ����� � �����, ������ ����������� � ������, ������� ������ �����,
    // �������� ��������� �� ����� (������) �� ��������� ��������. ��������� � ������ ��������
    // ���������� ������ ��� ����
    boolean getFormat(File file){
        String fullNameFile = file.toString();
        int indexFormat = fullNameFile.lastIndexOf(".")+1;
        String format = fullNameFile.substring(indexFormat);
        switch(format){
            case "png","jpg","jpeg": return true;
        }
        return false;
    }
    // ����� - ��������� ���� � ����� ������, �������� ������ ���� �� ����������
    void saveImage(BufferedImage bufferedImage){
        String file = "C:\\Users\\30.07.2018\\Desktop\\www\\2.jpg";
        File path = new File(file);
        try{
            ImageIO.write(bufferedImage,"jpg", path);
        } catch (IOException e){
            System.out.println("�� ������� �������� ����");
        }
    }
}
