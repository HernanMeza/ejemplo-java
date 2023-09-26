package com.ntt.app.helper;

import org.springframework.stereotype.Component;

/**
 * The Class LogHelper.
 */
@Component
public class LogHelper {

    /**
     * Neutralize.
     *
     * @param input the input
     * @return the string
     */
    public String neutralize(String input) {
        String clean = input.replace( '\n', '_' ).replace( '\r', '_' ).replace( '\t', '_' );
        return clean;
    }

}
