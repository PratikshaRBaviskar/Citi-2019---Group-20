package Sanction.screen;
import Upload.ProcessofFile;
import screening.Screen;

public class App 
{
    public static void main( String[] args )
    {
    	ProcessofFile pf=new ProcessofFile();
		pf.readFile();
        pf.output();
        Screen s=new Screen();
        s.screening();
        pf.checkscreen(s.names);
    }
}