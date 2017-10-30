import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VASShell {

    private static String merkTextDE = "";
    private static String merkTextEN = "";
    private static Integer merke =0;
    private static Integer randomNum=0;
    private static List<String> listDE = new ArrayList<>(7);
    private static List<String> listEN = new ArrayList<>(7);
    private static String enEintrag = "";
    private static String deEintrag = "";


    public static void main(String[] args) throws IOException {

        setListDE();
        setListEN();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (readInput(bufferedReader)){


    }
}

    private static void setListDE() {
        listDE.add("Ich schau nach, ob er zu sprechen ist.");
        listDE.add("Ich verbinde Sie mit Mr. Green.");
        listDE.add("Mit wem spreche ich bitte?");
        listDE.add("Sie sind mit dem Empfang verbunden.");
        listDE.add("Könnten Sie mir bitte Ihren Namen nennen?");
        listDE.add("Könnten Sie mir den Namen Ihrer Firma nennen?");
        listDE.add("Könnten Sie mir den Grund Ihres Anrufs nennen?");
        listDE.add("Was macht Ihre Firma?");
        listDE.add("Ich interessiere mich für Ihre ganz neue Produktlinie.");
        listDE.add("Was kann ich für Sie tun?");
        listDE.add("Wir haben Ihre Anfrage bekommen.");
    }

    private static void setListEN() {
        listEN.add("Let me see if he is available.");
        listEN.add("I will connect you with Mr. Green.");
        listEN.add("May I ask who's calling?");
        listEN.add("You have reached the reception.");
        listEN.add("Could you please give me your name?");
        listEN.add("Could you tell me the name of your company?");
        listEN.add("Could you tell me what your call is about?");
        listEN.add("What does your company do?");
        listEN.add("I was interested in your new product line.");
        listEN.add("What can I do for you?");
        listEN.add("We have received your enquiry.");
    }

    private static boolean readInput(BufferedReader bufferedReader) throws IOException {



        if (merke==0) {
            randomNum = getrandomNum();
 //           System.out.println(enEintrag);
            if (!enEintrag.equals("")) {
           //     System.out.println(listEN.add(enEintrag));
                listEN.add(enEintrag);
                enEintrag="";
            }
             if (!deEintrag.equals("")){
                listDE.add(deEintrag);
                deEintrag="";
             }


        }
        else randomNum = merke;

        enEintrag = holeArrayEintragEN(randomNum);
        deEintrag = holeArrayEintragDE(randomNum);

//        System.out.println( deEintrag + " > " + randomNum + "--" + merke + "##" + listDE.size());
        System.out.println( deEintrag + " > " );
        String nextLine = bufferedReader.readLine();

        getAnalysis(nextLine);


        if (nextLine.equals("exit")) return false;

        if (nextLine.equals(enEintrag)) {

            merkTextEN = enEintrag;
            merkTextDE = deEintrag;

            listDE.remove((int) randomNum);
            listEN.remove((int) randomNum);
 //           System.out.println("##" + listDE   );
            merke=0;
            return true;
        }
        System.out.println(enEintrag);
        merke=randomNum;
        return true;
    }

    private static String getAnalysis(String nextLine) {

    String outTXT="";
        try {
            for (int i=0; i<enEintrag.length(); i++ ) {
                if (enEintrag.charAt(i)==nextLine.charAt(i)) {
           //         outTXT+=" ";
                    System.out.print(" ");
                }
                else {
                    System.out.print("^");
               //     outTXT+="^";
                }
            }
            System.out.println("");
 //           if (outTXT.indexOf("^")>-1) System.out.println("#" + outTXT + "#" + outTXT.indexOf("^"));
//            System.out.println("" + i + "--" + enEintrag.length());
    }
    catch (StringIndexOutOfBoundsException e) {
      System.out.println("");
        }
        return null;
    }

    private static Integer getrandomNum() {
        Integer minimum=0;
        Integer maximum=listDE.size();
        return minimum + (int) (Math.random() * maximum);
    }

    private static String holeArrayEintragDE(Integer index) {
        return listDE.get(index);
    }

    private static String holeArrayEintragEN(Integer index) {
        return listEN.get(index);
    }
}
