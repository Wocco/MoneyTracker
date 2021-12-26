package GUI;

import javax.swing.*;

/**
 * @function change to light theme
 */
public class LightTheme implements Theme{
    public void changeTheme(ThemeContext themeContext){
        themeContext.setTheme(this);
        System.out.println("Light theme set.");
        try {
            UIManager.setLookAndFeel(UIManager. getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
