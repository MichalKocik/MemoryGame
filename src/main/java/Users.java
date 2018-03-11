import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {

        private String firstName;
        private String lastName;
        private int  stats;
        private Users userPlayer;
      //  List<Users> usersList=new ArrayList<>();

    public int getStats() {
        return stats;
    }

    public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Users (){}

        public Users(String firstName, String lastName, int stats){
            this.firstName=firstName;
            this.lastName=lastName;
            this.stats=stats;
        }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public List<Users> creatingUsers(int stats) throws IOException {
        WritingAndReadingFile writer=new WritingAndReadingFile();
        List<Users> usersList=writer.ReadingFromFile();
            Scanner sin = new Scanner(System.in);
            MemoryMethods mem=new MemoryMethods();
            System.out.println("prosze o podanie imienia");
            String tmpFirstName = sin.next();
            System.out.println("prosze o podanie nazwiska");
            String tmpLastName = sin.next();
         int tmpStats = stats;

            int compare = compare(tmpFirstName, tmpLastName,usersList);
            if (compare<0) {
                usersList.add(new Users(tmpFirstName, tmpLastName, tmpStats));
                System.out.println("udało się stworzyć Twój profil, w tej grze "+usersList.get(usersList.size()-1).firstName+"zdobyłaś/eś "+ stats);
            }else{
                System.out.println("jest już taki użytkownik");
                int tmppoints=usersList.get(compare).stats;
              usersList.get(compare).setStats(tmppoints+stats);
                System.out.println("Do konta użytkownika "+usersList.get(compare).firstName+"dopisano "+ stats +"punktów");
            }

            return usersList;
        }

    @Override
    public String toString() {
        return "Imię: " + firstName+ " Nazwisko: "+ lastName + " ilość zdobytych punktów: " + stats;
    }

    public int compare(String firstName, String lastName, List<Users>usersListcomp){
            int tmpCompare=-1;
            for(int i=0; i<usersListcomp.size();i++) {
                if (firstName.equals(usersListcomp.get(i).getFirstName())&&lastName.equals(usersListcomp.get(i).getLastName())){
                    tmpCompare=i;
                }
            }
            return tmpCompare;
        }


    }

