package com.ita.edu.teachua.data.challenges;

import com.ita.edu.teachua.utils.TestValueProvider;

import java.util.Random;

public class ChallengeRepository {

    Challenge challenge = new Challenge();
    TestValueProvider testValueProvider = new TestValueProvider();
    Random random = new Random();

    private String validSequenceNumber = Integer.toString(random.nextInt(3000));
    private String validChallengeName = "ваууууу";
    private String validDescription = "qwertyuiopasdghjklzxcvbnmgqwerсtghyujkiol";
    private String toShortChallengeDescription = "dfgdfg";
    private String toLongChallengeDescription = printNumberOfSymbols(25001);
    private String validTitle = "dksfkdjfskldf";
    private String emptyNameField = "";
    private String toLongChallengeName = "qwertyuiopasdghjklzxcvbnmgqwerс";
    private String negativeSequenceNumber = "-15";
    private String floatSequenceNumber = "0.4";

    public String printNumberOfSymbols(int number) {
        String word = "";
        for (int i = 0; i < number; i++) {
            word = word + "a";
        }
        return word;
    }

    public Challenge challengeWithValidData() {
        challenge.setSequenceNumber(validSequenceNumber);
        challenge.setName(validChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(validDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithInvalidFloatSequenceNumber() {
        challenge.setSequenceNumber(floatSequenceNumber);
        challenge.setName(validChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(validDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithInvalidNegativeSequenceNumber() {
        challenge.setSequenceNumber(negativeSequenceNumber);
        challenge.setName(validChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(validDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithEmptyName() {
        challenge.setSequenceNumber(validSequenceNumber);
        challenge.setName(emptyNameField);
        challenge.setTitle(validTitle);
        challenge.setDescription(validDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithToLongName() {
        challenge.setSequenceNumber(validSequenceNumber);
        challenge.setName(toLongChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(validDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithToLongDescription() {
        challenge.setSequenceNumber(validSequenceNumber);
        challenge.setName(validChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(toLongChallengeDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithToShortDescription() {
        challenge.setSequenceNumber(validSequenceNumber);
        challenge.setName(validChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(toShortChallengeDescription);
        challenge.setPhoto(testValueProvider.getImage());
        return challenge;
    }

    public Challenge challengeWithoutPhoto() {
        challenge.setSequenceNumber(validSequenceNumber);
        challenge.setName(validChallengeName);
        challenge.setTitle(validTitle);
        challenge.setDescription(validDescription);
        return challenge;
    }

}
