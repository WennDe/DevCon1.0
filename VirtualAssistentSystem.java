import java.io.*;
import java.util.ArrayList;


public class VirtualAssistentSystem {

    private static Communicator personA = new Communicator("A");
    private static Communicator personB = new Communicator("B");
    private static Communicator personC = new Communicator("C");
    private static Communicator universal = new Communicator("");
    private static ArrayList<String> drehBuch = new ArrayList<>();
    private static String vergleichTXT="";
    private static boolean merke;

    public static void main (String[] args) throws IOException {

        if (args.length>0) ladeDialog(args[0]);
        else ladeDialog("dialog");

        int a=0;
        int b=0;
        int c=0;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);



        for (int idx=0; idx<drehBuch.size(); ++idx) {

if (drehBuch.get(idx)=="A" && idx%2==0) { vergleichTXT = personA.getDialogENentry(a++); }
if (drehBuch.get(idx)=="B" && idx%2==0) { vergleichTXT = personB.getDialogENentry(b++); }
if (drehBuch.get(idx)=="C" && idx%2==0) { vergleichTXT = personC.getDialogENentry(c++); }

if (idx%2==0) {

    while (readInput(bufferedReader)) {


    }
    // System.out.println(merke);
    if (!merke)   idx=drehBuch.size();
}
        }
  //      System.out.println(drehBuch);
    }

    private static boolean readInput(BufferedReader bufferedReader) throws IOException {

        System.out.println( vergleichTXT + " > " );
        String nextLine = bufferedReader.readLine();


        if (nextLine.equals(vergleichTXT.substring(3,vergleichTXT.length()-1)) || nextLine.equals(vergleichTXT.substring(3)) || nextLine.equals(">")) {
            System.out.println("ok"); merke=true; return false;}
        if (nextLine.equals("exit")) { merke=false; return false;}

        return true;
    }

    public static void ladeDialog(String file) {

            File dialogTextFile = new File("C:/Users/EDWALTER/IdeaProjects/untitled/src/" + file + ".txt");
            try (BufferedReader dialogTextReader = new BufferedReader(new InputStreamReader(new FileInputStream(dialogTextFile)))) {
                String line;
                int i = 0;
                while ((line = dialogTextReader.readLine()) != null) {



                    if (line.charAt(0) == 'A') { universal = personA; drehBuch.add("A");}
                    if (line.charAt(0) == 'B') { universal = personB; drehBuch.add("B");}
                    if (line.charAt(0) == 'C') { universal = personC; drehBuch.add("C");}

                    ++i;
                    if ((i % 2) == 0) {
//                        System.out.println(i + " " + line + "##" + line.charAt(0));
                        universal.setDialogDE(line);
                    } else universal.setDialogEN(line);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }




        }

    }



