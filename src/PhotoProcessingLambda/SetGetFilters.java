package PhotoProcessingLambda;

public class SetGetFilters {
    static boolean again;
    static String filters;
    float[] changePixels(float[] pixels){
        switch (filters){
            case "монохромный" : pixels = monochrome(pixels); again = getFalse(); break;
            case "красный"     : pixels = red(pixels);        again = getFalse(); break;
            case "зеленый"     : pixels = green(pixels);      again = getFalse(); break;
            case "синий"       : pixels = blue(pixels);       again = getFalse(); break;
            case "сепи€"       : pixels = sepia(pixels);      again = getFalse(); break;
            default            : System.out.println("Ќе правильно выбрали фильтр повторите еще раз");
            again = getTrue();  break;
        }
        return pixels;

    }
    float[] monochrome(float[] pixels){
        float monochrome = (float)((0.2125 * pixels[0]) + (0.7154 * pixels[1]) + (0.0721 * pixels[2]));
        pixels[0] = monochrome;
        pixels[1] = monochrome;
        pixels[2] = monochrome;
        return pixels;
    }
    float[] red(float[] pixels){
        pixels[1]=0;
        pixels[2]=0;
        return pixels;
    }
    float[] green(float[] pixels){
        pixels[0]=0;
        pixels[2]=0;
        return pixels;
    }
    float[] blue(float[] pixels){
        pixels[0]=0;
        pixels[1]=0;
        return pixels;
    }
    float[] sepia(float[] pixels){
        float sepia = (float)((0.2126 * pixels[0]) + (0.7152 * pixels[1]) + (0.0722 * pixels[2]));
        pixels[0] = sepia;
        pixels[1] = sepia;
        pixels[2] = sepia;
        return pixels;
    }
    boolean getFalse(){
        return false;
    }
    boolean getTrue(){
        return true;
    }
    static String getFilter(String filter){
        return filters=filter;
    }
}
