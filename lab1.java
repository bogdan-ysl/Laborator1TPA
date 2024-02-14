import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String sentence = "";
        String substringToCheck = "";
        String wordToAdd = "";

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        try {
            System.out.println("Introdu propozitia: ");
            sentence = bis.readLine();
            System.out.println("Introdu subsirul specificat: ");
            substringToCheck = bis.readLine();
            System.out.println("Introdu cuvantul care trebuie adaugat: ");
            wordToAdd = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Text myText = new Text(wordToAdd, sentence, substringToCheck);
        myText.changeSentence();
        System.out.println("Propozitia noua: " + myText.getSentence());
    }
}

class Text {
    private String mySentence;
    private String substringToCheck;
    private String wordToAdd;
    private String newSentence = "";

    public Text(String wordToAdd, String mySentence, String substringToCheck) {
        this.mySentence = mySentence;
        this.wordToAdd = wordToAdd;
        this.substringToCheck = substringToCheck;
    }

    public String getSentence() {
        return newSentence;
    }

    public void changeSentence() {
        String[] words = mySentence.split("\\s+");

        for (String word : words) {
            if (word.endsWith(substringToCheck)) {
                newSentence += word + " " + wordToAdd + " ";
            } else {
                newSentence += word + " ";
            }
        }
    }
}
