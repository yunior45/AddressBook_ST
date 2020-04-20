package GUI;

import AddressBookTest.AddressBook;
import AddressBookTest.AddressBookController;
import AddressBookTest.Person;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.mockito.internal.matchers.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import static org.junit.Assert.*;

public class PersonDialogTest {

    AddressBookGUI frame;
    AddressBookGUI frame2;
    AddressBookController controller;
    AddressBook addressBook;
    Person person;
    PersonDialog dialog;
    PersonDialog emptyDialog;
    JTextField inputTest;


    @Before
    public void create() throws AWTException {
        addressBook = new AddressBook();
        frame = new AddressBookGUI(controller, addressBook);
        frame2 = new AddressBookGUI(controller, addressBook);
        dialog = new PersonDialog(frame);
        person = new Person("Yunior", "Rivera", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
        dialog = new PersonDialog(frame, person);
        emptyDialog = new PersonDialog(frame2);
        addressBook.add(person);
    }

    @Test
    public void showDialog() throws InterruptedException {
        assertEquals("CANCEL", PersonDialog.Result.CANCEL.toString());
        assertEquals("OK", PersonDialog.Result.OK.toString());
    }

    @Test
    public void getPerson() {
        assertEquals("Rivera, Yunior", dialog.getPerson().toString());
        assertEquals(null, emptyDialog.getPerson());
    }
}