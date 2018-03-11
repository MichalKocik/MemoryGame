import java.awt.*;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("MENU:");
        System.out.println("1-zagrać w grę\n2-odczytać listę graczy");
        Scanner sin=new Scanner(System.in);
        int a=sin.nextInt();
        switch(a) {
            case 1:
            MemoryMethods pam = new MemoryMethods();
            WritingAndReadingFile write = new WritingAndReadingFile();
            Users uzytkownik = new Users();
            int points;
            String[][] tmp;
            String[][] tmpNumbers;
            tmp = pam.creatingArray();
            List<String> listWithletters = pam.filligBoard();
            pam.display(tmp);
            Thread.sleep(10000);
            List<String> listofLettersSorted = pam.sorting(tmp);
            MemoryMethods.clrscr();
            tmpNumbers = pam.fillingnumbers(tmp);

            pam.emptySpace();
            pam.display(tmp);
            pam.createGetBoardWithNumers(tmpNumbers);
            points = pam.guessing(listofLettersSorted);
            List<Users> users = uzytkownik.creatingUsers(points);
            write.WritingToFile(users);
            case 2:
                WritingAndReadingFile writeD = new WritingAndReadingFile();
                 writeD.displayList();
        }





    }
}
