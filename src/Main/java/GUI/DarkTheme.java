package GUI;

public class DarkTheme implements Theme{
    public void changeTheme(ThemeContext themeContext){
        themeContext.setTheme(this);
        System.out.println("Dark theme set.");
    }
}
