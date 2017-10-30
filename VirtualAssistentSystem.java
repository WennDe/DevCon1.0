import java.io.*;

public class VirtualAssistentSystem {

    public static void main (String[] args) {


    Communicator personDE;
        personDE = new Communicator("GerMan");
        Communicator personEN = new Communicator("EnglishMan");


        System.out.println(personDE.getName());
        System.out.println(personEN.getName());


        File dialogTextFile = new File("C:/Users/EDWALTER/IdeaProjects/untitled/src/dialog.txt");
        try (BufferedReader dialogTextReader = new BufferedReader(new InputStreamReader (new FileInputStream(dialogTextFile)))) {
                String line;
            int i = 0;
                while ((line=dialogTextReader.readLine())!=null) {

                    ++i;
                    if ((i % 2)==0 ) {
                        System.out.println(i + " " + line);
                        personDE.setDialog(line);
                    }
                    else personEN.setDialog(line);
                }
            } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        System.out.println(personEN.getDialogPart());
        System.out.println(personDE.getDialogPart());
    }
}
