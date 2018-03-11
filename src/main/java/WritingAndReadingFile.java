import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class WritingAndReadingFile {
private static final Path PATH_USERS;
private static final Path BACKUP_PATH=Paths.get("data", "Users.txt.bak");

    static {
        PATH_USERS = Paths.get("data", "Users.txt");
    }

    public void WritingToFile(List<Users> users) throws IOException {
        Files.copy(PATH_USERS, BACKUP_PATH, StandardCopyOption.REPLACE_EXISTING);
int counter=0;
    try (FileWriter writer = new FileWriter(PATH_USERS.toFile(),false)){
        writer.write("\r\n");
while(counter<users.size()) {
    String line = users.get(counter).getFirstName() + ";" + users.get(counter).getLastName() + ";" + users.get(counter).getStats();
    writer.write(line);
    writer.write("\r\n");
    counter++;
}
    }


}
public void displayList() throws IOException {
    List<Users> users=ReadingFromFile();
    for(Users user:users){
        System.out.println(user);
    }
    }


    public List<Users> ReadingFromFile() throws IOException {
        List<Users>users=new ArrayList<>();
        try (FileReader inFile = new FileReader(PATH_USERS.toFile());
            BufferedReader reader =new BufferedReader(inFile)){
String firstLine=reader.readLine();
         users= reader.lines()
                   .map(l->l.split(";"))
                   .map(str->new Users((str[0].trim()),str[1].trim(),Integer.parseInt(str[2].trim())))
                   .collect(toList());



        }
        return users;
    }
}
