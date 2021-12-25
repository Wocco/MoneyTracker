package GUI;

public class ThemeContext {
    private Theme theme;

    public ThemeContext() {
        this.theme = null;
    }

    public void setTheme(Theme theme){
        this.theme = theme;
    }

    public Theme getTheme(){
         return this.theme;
    }
}
