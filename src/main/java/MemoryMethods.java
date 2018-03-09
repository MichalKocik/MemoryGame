import java.io.IOException;

import java.util.*;

public class MemoryMethods {


    Scanner sin=new Scanner(System.in);
    Map<Integer,String> MapWithLetters=new HashMap<>();
    String[][] board;


    public String[][] creatingArray() {

        System.out.println("proszę podać poziom trudności" + "\n 1-poziom dla początkujących 1 \n 2-poziom dla początkujących 2 \n 3-poziom średniozaawansowany 1 " +
                "\n 4-poziom średniozaawansowany 2 \n 5- poziom zaawansowany ");
        Scanner sin = new Scanner(System.in);
        int difficultyLevel = sin.nextInt();
        switch (difficultyLevel) {
            case 1:
                board = new String[5][5];
                break;
            case 2:
                board = new String[7][7];
                break;
            case 3:
                board = new String[9][9];
                break;
            case 4:
                board = new String[11][11];
                break;
            case 5:
                board = new String[13][13];
                break;
            default:
                board = new String[5][5];
        }
        return board;
    }
    public int GetBoardLength(){
        return board.length;
    }

    public List<String> filligBoard() {
        Random rnd = new Random();
        List<String> letters=new ArrayList<>();
        int i, j=0;
        for (i=0; i < board.length; i++) {
            for (j = 0; j < board.length; j++) {
                if (j % 2 == 0 && i < board.length - 1 && i > 0) {
                    if (j == 0 || j == board.length - 1) {
                        board[i][j] = "|";
                    } else {
                        board[i][j] = " | ";
                    }
                }

                if ((i % 2 == 0 && j != 0 && j != board.length - 1) || i == 0 || i == board.length - 1) {
                    if (j == board.length - 1 || j == 0) {
                        board[i][j] = "-";
                    } else {
                        board[i][j] = "---";
                    }
                }
                if (j % 2 == 1 && i % 2 == 1) {
                    board[i][j] = " " + String.valueOf((char) (rnd.nextInt(26) + 65)) + " ";
                    letters.add(board[i][j]);
                }
            }

        }

        return letters;
    }

    public String[][] fillingnumbers(String[][] board) {
        String [][] boardWithNumbers=board.clone();
        int counter=0;
        for (int i = 0; i < boardWithNumbers.length; i++) {
            for (int j = 0; j < boardWithNumbers.length; j++) {
                if (j % 2 == 1 && i % 2 == 1) {
                    counter++;
                    MapWithLetters.put((Integer)(counter-1),board[i][j]);
                    if(counter<10){
                        board[i][j] = " " + String.valueOf(counter)+" ";
                    }else{
                        board[i][j] =  String.valueOf(counter)+" ";
                    }

                }
            }
        }
        return board;
    }
    public void emptySpace(){
        for(int i=0; i<10;i++){
            System.out.println();
        }
    }
    public void display (String [][] board){

        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);

            }
        }
    }
    public List<String> sorting(String [][] board) {
        List<String> listOfLetters = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j % 2 == 1 && i % 2 == 1) {
                    listOfLetters.add(board[i][j].trim());
                }

            }
        }
        listOfLetters.sort(Comparator.comparing(String::valueOf));
        return listOfLetters;
    }
    public int guessing(List<String>listOfletters) {
        boolean flag = true;
int stats=0;
        int indeks = -1;
        int tmpWriter;
        int difference;
        int tmpIndeks = 0;
        while (flag) {
            tmpIndeks = indeks;
            System.out.println();
            indeks = listOfletters.lastIndexOf(listOfletters.get(indeks + 1));
            difference = indeks - tmpIndeks;
            System.out.println("podaj liczby pod którymi znajduję się litera " + listOfletters.get(indeks) + ". Wystąpiła " + difference + " razy");
            for (int i = 0; i < difference; i++) {
                System.out.println("podaj " + (i + 1) + " wystąpienie");
                tmpWriter =sin.nextInt();

                if((listOfletters.get(indeks)).equals(MapWithLetters.get(tmpWriter-1).trim())){

                    System.out.println("dobrze");
                    stats++;

                }else{

                    System.out.println("źle");
                }
            }
            if (indeks+1 == listOfletters.size()) {
                flag = false;
                System.out.println("koniec gry");
            }
        }
return stats;
    }
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
