package us.bakenh.inventar.presentation;

public interface IOBase {

    String input();

    String input(String prompt);

    int inputNumber();

    int inputNumber(String prompt);

    void print(String string);
}
