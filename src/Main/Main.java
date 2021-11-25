package Main;

import GUI.GUI;

public class Main
{

    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main() {
    }

    public void run()
    {
        GUI gui = new GUI();
        gui.app();

    }
}
