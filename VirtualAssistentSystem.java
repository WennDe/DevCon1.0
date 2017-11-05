import java.io.*;
import java.util.*;


public class VirtualAssistentSystem {

    private static ArrayList<String> drehBuch = new ArrayList<>();
    private static Map<String, Integer> objectMap = new HashMap<String, Integer>();
    private static String vergleichTxtEn="";
    private static String vergleichTxtDe="";
    private static String iam="G";
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

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        while (auswahlPerson(bufferedReader)) { }



 //      System.out.println(iam);

        for (int idx=0; idx<drehBuch.size(); ++idx) {


if (idx%2==0) {
//    System.out.println(merke);

        int m = objectMap.get(drehBuch.get(idx));
        if (personenListe.get(m).getDialogENsize()>0) {
        vergleichTxtEn = personenListe.get(m).getDialogENentry(0);
        vergleichTxtDe = personenListe.get(m).getDialogDEentry(0);

        while (readInput(bufferedReader)) { }

        if (!merke)   idx=drehBuch.size();
        personenListe.get(m).delDialogENentry(0);
        personenListe.get(m).delDialogDEentry(0);
    }


}


        }
        System.out.println(personenListe.get(0).getDialogENsize());

              System.out.println(drehBuch);
              System.out.println(objectMap);
        System.out.println(personenListe);
        System.out.println(iam);
    }

    private static boolean auswahlPerson(BufferedReader bufferedReader) throws IOException {
        System.out.println("Wer willst Du sein? Enter a number: " + objectMap);





 //       System.out.println(nextLine.indexOf(0));
 //       System.out.println(Integer.parseInt(nextLine));
        String nextLine = bufferedReader.readLine();

        char character = nextLine.charAt(0);
        int c = (int) character;

        System.out.println(c);

 //       if (c > 49 && c < 58) { return false; }
        if (c>57) {return true;}
        if (c<49) {return true;}
     //   else { return true; }

        if (nextLine.isEmpty()) return true;

        if (objectMap.containsValue(Integer.parseInt(nextLine))) {
iam = personenListe.get(Integer.parseInt((nextLine))).getName();
            System.out.println("Ok, you are: " + iam);
            return false; }
        else { return true; }


    }

    private static boolean readInput(BufferedReader bufferedReader) throws IOException {

        String[] parts = vergleichTxtEn.split(":");
       if (!iam.equals(parts[0])) { System.out.println(vergleichTxtEn);

 merke=true; return false; }

        String nextLine = bufferedReader.readLine();

            if (nextLine.equals(parts[1].trim().substring(0,parts[1].trim().length()-1)) || nextLine.equals(parts[1].trim())) {
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

                    String[] parts = line.split(":");

                    if (!drehBuch.contains(parts[0])) {

                        personenListe.add(new Communicator(parts[0]));
                        objectMap.put(parts[0], xx++);
                    }

                    drehBuch.add(parts[0]);



                    ++i;
                    int tmp = objectMap.get(parts[0]);
                    if ((i % 2) == 0) {

                        personenListe.get(tmp).setDialogDE(line);

                    } else {
                      personenListe.get(tmp).setDialogEN(line);

                    }
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }




        }

    }



