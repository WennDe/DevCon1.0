import java.io.*;
import java.util.ArrayList;


public class VirtualAssistentSystem {

    private static Communicator personA = new Communicator("A");
    private static Communicator personB = new Communicator("B");
    private static Communicator personC = new Communicator("C");
    private static Communicator universal = new Communicator("");
    private static ArrayList<String> drehBuch = new ArrayList<>();

    public static void main (String[] args) {

        ladeDialog();

        int a=0;
        int b=0;
        int c=0;
        for (int idx=0; idx<drehBuch.size(); ++idx) {

if (drehBuch.get(idx)=="A" && idx%2==0) { System.out.println(idx + ": "  + personA.getDialogENentry(a++)); }
if (drehBuch.get(idx)=="B" && idx%2==0) { System.out.println(idx + ": "  + personB.getDialogENentry(b++)); }
if (drehBuch.get(idx)=="C" && idx%2==0) { System.out.println(idx + ": "  + personC.getDialogENentry(c++)); }

        }
  //      System.out.println(drehBuch);
    }

     public static void ladeDialog() {

            File dialogTextFile = new File("C:/Users/EDWALTER/IdeaProjects/untitled/src/dialog.txt");
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



