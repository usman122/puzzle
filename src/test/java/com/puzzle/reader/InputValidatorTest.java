package com.puzzle.reader;

import com.puzzle.reader.InputValidator;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class InputValidatorTest {
    public static final String NEW_LINE = "\n";

    @Test
    public void returnTrueWhenInputIsValid(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 2 N")
                .append(NEW_LINE)
                .append("LM");
        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isTrue();
    }

    @Test
    public void returnFalseWhenPlateauDoesNotContainTwoDigits(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5")
                .append(NEW_LINE)
                .append("1 2 N")
                .append(NEW_LINE)
                .append("LM");

        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenPlateauIsNotADigit(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 A")
                .append(NEW_LINE)
                .append("1 2 N")
                .append(NEW_LINE)
                .append("LM");

        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenRobotHasLessThanThreeValues(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 2")
                .append(NEW_LINE)
                .append("LM");

        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenRobotFirstValueIsNotADigit(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("A 2 N")
                .append(NEW_LINE)
                .append("LM");

        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenRobotSecondValueIsNotADigit(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 B N")
                .append(NEW_LINE)
                .append("LM");

        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenRobotThirdValueIsNotValid(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 2 B")
                .append(NEW_LINE)
                .append("LM");

        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenRobotCommandIsBlank(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 2 N")
                .append(NEW_LINE)
                .append("");
        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

    @Test
    public void returnFalseWhenRobotCommandContainsAnyCharOtherThanLRM(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("5 5")
                .append(NEW_LINE)
                .append("1 2 N")
                .append(NEW_LINE)
                .append("LMA");
        InputValidator inputValidator = new InputValidator();
        boolean isValid = inputValidator.validate(stringBuilder.toString());

        assertThat(isValid).isFalse();
    }

}
