package GUI;

public class LightTheme implements Theme{
    public void changeTheme(ThemeContext themeContext){
        themeContext.setTheme(this);
        System.out.println("Light theme set.");
    }
}
