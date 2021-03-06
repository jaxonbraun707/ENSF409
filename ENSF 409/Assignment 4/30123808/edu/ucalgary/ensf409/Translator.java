package edu.ucalgary.ensf409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* getTranslation()
   * getter method returning a stored TranslationText object.
  */

  /* translate()
   * Accepts a month number (e.g., 1 for January), a day number (e.g., 31 for
   * the 31st), and a year. Note that years may be any previous year in the common era 
   * (CE) from 0 to the previous year, or they may be before the common era (BCE),
   * represented by negative numbers. Thus 2021, 800, and -1600 are all valid years.
   * Method throws an IllegalArgumentException if monthNum or dayNum is not
   * valid. Returns the formatted sentence as a String. Notice that the String
   * containing formatting uses numbered arguments - this is because some languages
   * will put the words in the sentence in a different order, but the translate()
   * method must be able to work without knowledge of the language structure.
   * Note: You do not have to check if a day is valid for a particular month/year;
   * February 31 or February 29, 2021 can both be accepted, but out of range values
   * e.g., month 15 day 0, are not valid and should be handled with an 
   * IllegalArgumentException. 
  */

  /* Constructor
   * Accepts a String of a two-letter language code (lowercase), dash, and two-letter 
   * region (caps) code, e.g., te-IN and throws an IllegalArgumentException if the language 
   * and region code are not in the correct format. Language codes are ISO 639-1 and
   * region codes are ISO 3166, but this method only checks the format of the String, 
   * not if the region and language codes are valid according to the ISO specifications.
   * It calls importTranslation().
  */

  /* importTranslation()
   * Calls deserialize() if the appropriate file exists, otherwise calls importFromText().
   * No arguments. Returns void.
  */

  /* importFromText()
   * Reads in from a the two-letter language code, dash, two-letter region code text 
   * file, in the form of ab-XY.txt, and instantiates a TranslationText object with
   * the data. It can throw I/O exceptions. Throw a custom ArgFileNotFoundException
   * when the file isn't found. 
   * We expect the .txt file to be in a valid format. The file is expected to be in the same 
   * directory. The files en-US.txt and el-GR.txt are examples of a valid .txt files. They will 
   * always consist of the month names, one per line, followed by the day names, one per line, 
   * followed by the sentence containing formatting strings. This is the last line in the file. You
   * cannot make any assumptions about what will appear on each line, only that each line
   * will contain only one data element, and that it will not contain an empty line.
   * No arguments. Returns void.
  */

  /* serialize()
  * Creates a serialized object file of the TranslationText object, with the
  * name format la-CO.ser, where la is the two-letter language code and CO is
  * the two-letter region code. An example of a serialized object file can be
  * found in the exercise directory as es-BO.ser
  * I/O exceptions can be thrown.
  * No arguments. Returns void.
  */

  /* deserialize()
   * Creates a TranslationText object from a .ser file. The files are named
   * xx-YY.ser, where xx is the two-letter language code and YY is the two-
   * letter region code. es-BO.ser is an example. It can throw I/O exceptions.
   * No arguments. Returns void.
  */

  public class Translator {
    private TranslationText transText;
    private final String LANGCODEREGEX = "^[a-z]{2}-[A-Z]{2}$";
    private String langCode;

    public Translator(String langCode) throws IllegalArgumentException, ArgFileNotFoundException{
      this.langCode = langCode;
      if (!this.langCode.matches(LANGCODEREGEX)){
        throw new IllegalArgumentException("Error: Language code is not in proper format. " 
        + "It must be in the following example format: en-US");
      }
      importTranslation();
    }

    public void importTranslation() throws ArgFileNotFoundException{
      File file = new File(langCode + ".ser");
      File file1 = new File(langCode + ".txt");
      if (file.exists()){
        deserialize();
      }
      else if (file1.exists()){
        importFromText();
      }
      else{
        throw new ArgFileNotFoundException();
      }
    }

    public void deserialize() {
      try {
        File file = new File(langCode + ".ser");
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        transText = (TranslationText) in.readObject();
        in.close();
        fileIn.close();
      } catch(IOException e) {
        System.out.println("Error: Serialized translationtext file not found.");
        System.exit(1);
      } catch(ClassNotFoundException e) {
        System.out.println("Error: Serialized translationtext file does not contain a TranslationText object.");
        System.exit(1);
      }
    }

    public void serialize() {
      try {
        FileOutputStream fileOut = new FileOutputStream(new File(langCode + ".ser"));
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(transText);
        out.close();
        fileOut.close();
      } catch (IOException e) {
        System.out.println("Error: TranslationText Serialized file cannot be created.");
        System.exit(1);
      }
    }

    public void importFromText() throws ArgFileNotFoundException {
      String[] months = new String[12];
      String[] days = new String[31];
      File file = new File(langCode + ".txt");
      try {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        for (int i = 0; i < 12; i++){
          months[i] = reader.readLine();
        }
        for (int i = 0; i < 31; i++) {
          days[i] = reader.readLine();
        }
        String sentence = reader.readLine();
        reader.close();
        fileReader.close();
        transText = new TranslationText(months, days, sentence);
      } catch (IOException e) {
        System.out.println("Error: Input Text File cannot be found.");
        e.printStackTrace();
        System.exit(1);
      }
    }

    public String translate(int month, int day, int year) {
      if (month < 1 || month > 12 || day < 1 || day > 31) {
        throw new IllegalArgumentException("Error: The day or month to be translated is not a valid number representing a day or month.");
      }
      String dayOut = transText.getDays()[day-1];
      String monthOut = transText.getMonths()[month-1];
      String sentence = transText.getSentence();
      String output = String.format(sentence, dayOut, monthOut, year);
      return output;
    }

    public TranslationText getTranslation() {
        return transText;
    }
  }