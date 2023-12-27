package org.example;
import java.io.IOException;

class NewException extends IOException
{
    public NewException(String message)
    {
        super(message);
    }
}