import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VirtualAssistentSystem {

    private static Communicator personA = new Communicator("A");
    private static Communicator personB = new Communicator("B");
    private static Communicator personC = new Communicator("C");
    private static Communicator universal = new Communicator("");
    private static ArrayList<String> drehBuch = new ArrayList<>();

    private static Map<String, Integer> objectMap = new HashMap<String, Integer>();


    private static String vergleichTxtEn="";
    private static String vergleichTxtDe="";
    private static String iam="A";
    private static boolean merke=true;
    private static List<Communicator> personenListe = new ArrayList<Communicator>();

    public static void main (String[] args) throws IOException {

        if (args.length>0) {
            ladeDialog(args[0]);
           try {
               iam = (args[1] != null) ? (String)args[1] : "A";
           }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e + " Fehler beim Paramter einlesen");
            }
        }
        else {
            ladeDialog("dialog");
             }
        int a=0;
        int b=0;
        int c=0;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

 //      System.out.println(iam);

        for (int idx=0; idx<drehBuch.size(); ++idx) {

if (drehBuch.get(idx).equals("A") && idx%2==0) { vergleichTxtEn = personA.getDialogENentry(a); vergleichTxtDe = personA.getDialogDEentry(a++);if (iam.equals("A")) {while (readInput(bufferedReader)) { }} else System.out.println( vergleichTxtEn);}
if (drehBuch.get(idx).equals("B") && idx%2==0) { vergleichTxtEn = personB.getDialogENentry(b); vergleichTxtDe = personB.getDialogDEentry(b++);if (iam.equals("B")) {while (readInput(bufferedReader)) { }} else System.out.println( vergleichTxtEn);}
if (drehBuch.get(idx).equals("C") && idx%2==0) { vergleichTxtEn = personC.getDialogENentry(c); vergleichTxtDe = personC.getDialogDEentry(c++);if (iam.equals("C")) {while (readInput(bufferedReader)) { }} else System.out.println( vergleichTxtEn);}



if (idx%2==0) {
//    System.out.println(merke);
    if (!merke)   idx=drehBuch.size();
    System.out.println(drehBuch.get(idx));
  //  System.out.println(personenListe.get(objectMap.get(drehBuch.get(idx))).getDialogENentry(idx));

}


        }
        System.out.println(personenListe.get(1).listDialogEN.size());

              System.out.println(drehBuch);
//        System.out.println(personenListe);
        //       System.out.println(personenListe.get(0).getDialogENentry(0));
//        System.out.println(personenListe.get(1).getDialogENentry(0));
        //       System.out.println(personenListe.get(0).getDialogENentry(1));
        System.out.println(personenListe.get(0).listDialogEN);
        System.out.println(personenListe.get(1).listDialogEN);

              System.out.println(objectMap);
    }

    private static boolean readInput(BufferedReader bufferedReader) throws IOException {


        String nextLine = bufferedReader.readLine();

 //       if (nextLine.equals(vergleichTxtEn.substring(3,vergleichTxtEn.length()-1)) || nextLine.equals(vergleichTxtEn.substring(3)) || nextLine.equals(">")) {

            if (nextLine.equals(vergleichTxtEn.substring(3,vergleichTxtEn.length()-1)) || nextLine.equals(vergleichTxtEn.substring(3))) {
            // System.out.println("ok");
            merke=true; return false;}
        if (nextLine.equals("exit")) { merke=false; return false;}
        if (nextLine.equals(">")) {
            System.out.println(vergleichTxtEn); merke=true; return false;
        }
        if (nextLine.equals("hd")) { System.out.println(vergleichTxtDe + " > "); } // Anzeige Hilfe Deutsch
        if (nextLine.equals("he")) { System.out.println(vergleichTxtEn + " > "); } // Anzeige Hilfe English


        return true;
    }

    public static void ladeDialog(String file) {

            File dialogTextFile = new File("C:/Users/EDWALTER/IdeaProjects/untitled/src/" + file + ".txt");
            try (BufferedReader dialogTextReader = new BufferedReader(new InputStreamReader(new FileInputStream(dialogTextFile)))) {
                String line;
                int i = 0;
                int xx =0;
                while ((line = dialogTextReader.readLine()) != null) {

                    if (line.substring(0,1).equals("A")) { universal = personA; }
                    if (line.substring(0,1).equals("B")) { universal = personB; }
                    if (line.substring(0,1).equals("C")) { universal = personC; }



                    if (!drehBuch.contains(line.substring(0,1))) {

             //           Communicator x = ;
                        personenListe.add(new Communicator(line.substring(0,1)));
  //                      objectMap.put(line.substring(0,1), x.toString());
                        objectMap.put(line.substring(0,1), xx++);
                    }


                    drehBuch.add(line.substring(0,1));




                    ++i;
                    int tmp = objectMap.get(line.substring(0,1));
   //                 System.out.println(tmp);
                    if ((i % 2) == 0) {
//                        System.out.println(i + " " + line + "##" + line.charAt(0));
                        universal.setDialogDE(line);

            //            System.out.println(personenListe.get(personenListe.size() - 1));

                        personenListe.get(tmp).setDialogDE(line);

                    } else { universal.setDialogEN(line);
                      personenListe.get(tmp).setDialogEN(line);

                    }
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }




        }

    }



