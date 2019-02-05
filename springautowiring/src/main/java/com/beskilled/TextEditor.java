package com.beskilled;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    @Autowired
    private SpelChecker spelChecker;

    public void spellCheck(){
        spelChecker.checkSpelling();

    }
}
