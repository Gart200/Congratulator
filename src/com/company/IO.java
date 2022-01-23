package com.company;

import java.io.*;

public class IO {
    public boolean writeObject(BirthdayList birthdays, String filename) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename)){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            for (Birthday Birthday : birthdays.getBirthdays())
                objectOutputStream.writeObject(Birthday);

            objectOutputStream.writeObject(new String());
            return true;
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public BirthdayList readObject(String filename) {
        BirthdayList birthdays = new BirthdayList();
        Object object = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            while ((object = objectInputStream.readObject()) instanceof String == false)
                birthdays.addRecord((Birthday) object);
            return birthdays;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
