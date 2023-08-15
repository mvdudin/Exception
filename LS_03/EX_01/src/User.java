import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private int errorCode = -1;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private String phone;
    private String gender;

    public User(String str) throws IllegalArgumentException {
        if (!str.isEmpty()) {
            String[] item = str.split(" ");
            if (item.length == 6) {
                setSurname(item[0]);
                setName(item[1]);
                setPatronymic(item[2]);
                setBirthday(item[3]);
                setPhone(item[4]);
                setGender(item[5]);
            } else
                errorCode = item.length;
        }
        else
            errorCode = 0;
    }


    public int getECode () {
      return errorCode;
    }

    public void setSurname (String surname){
        if (!surname.matches("[a-zA-Zа-яА-Я]+")){
            throw new IllegalArgumentException("Invalid surname");
        }
      this.surname = surname;
    }

    public void setName(String name) {
        if (!name.matches("[a-zA-Zа-яА-Я]+")){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        if (!patronymic.matches("[a-zA-Zа-яА-Я]+")){
            throw new IllegalArgumentException("Invalid patronymic");
        }
        this.patronymic = patronymic;
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid dateOfBirth");
        }
    }

    public void setPhone(String phone) {
        try {
            Double.parseDouble(phone);
            this.phone = phone;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid gender.");
        }
    }

    @Override
    public String toString() {
        return surname.concat(" ").concat(name).concat(" ").concat(patronymic).concat(" ").concat(birthday.toString()).concat(" ").concat((String)phone).concat(" ").concat(gender);
    }

    public void saveToFile() {
        try (FileWriter file = new FileWriter(surname + ".txt", true)) {
            file.write(toString() + "\n");
            System.out.println("User has been added to the file.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}