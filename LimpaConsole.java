import java.io.IOException;
import java.util.Scanner;

public class LimpaConsole
{
    public static void limpaTela() throws IOException, InterruptedException {
        
        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

	public static void clearScreen() 
	{  
		System.out.print("\033[H\033[2J");
		System.out.flush();  
	}
}