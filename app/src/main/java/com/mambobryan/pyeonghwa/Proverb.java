package com.mambobryan.pyeonghwa;

/**
 * Created by Mr. Waziwazi on 4/10/2019.
 * This creates the korean proverb as objects
 */

public class Proverb {

    //This is the korean proverb
    private String mKoreanProverb;

    //This is the english translation of the korean proverb
    private String mEnglishTranslation;

    //This is the extra information about the proverb
    private String mTitBit;

    /**
     * This is the class initializer and initializes the private variables
     */
    public Proverb(String koreanProverb, String englishTranslation, String titBit){
        mKoreanProverb = koreanProverb;
        mEnglishTranslation = englishTranslation;
        mTitBit = titBit;
    }

    /**
     * This method returns the korean proverb
     */
    public String getKoreanProverb(){
        return mKoreanProverb;
    }

    /**
     * This method returns the English translation of the korean proverb
     */
    public String getEnglishTranslation(){
        return mEnglishTranslation;
    }

    /**
     * This method return extra information about the korean proverb
     */
    public String getTitBit(){
        return mTitBit;
    }
}
