package com.ita.edu.teachua.testdata;


import io.qameta.allure.Step;
import lombok.Data;

import java.util.Random;

@Data
public class ChallengeData {

    Random random = new Random();

    private String validSequenceNumber = Integer.toString(random.nextInt(3000));
    private String validChallengeName = "ваууууу";
    private String validDescription = "qwertyuiopasdghjklzxcvbnmgqwerсtghyujkiol";
    private String toShortChallengeDescription ="dfgdfg";
    private String toLongChallengeDescription = printNumberOfSymbols(25001);
    private String validTitle = "dksfkdjfskldf";
    private String emptyNameField = "";
    private String toLongChallengeName = "qwertyuiopasdghjklzxcvbnmgqwerс";
    private String negativeSequenceNumber = "-15";
    private String floatSequenceNumber = "0.4";


    @Step("Print numbers of symbols")
    public String printNumberOfSymbols(int number){
        String word = "";
        for (int i = 0 ; i < number ; i++){
            word = word + "a";
        }
        return word;
    }

}
