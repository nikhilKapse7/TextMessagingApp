package com.example.textmessageapp;

import android.util.Log;

import static com.example.textmessageapp.MainActivity.currentState;
import static com.example.textmessageapp.MainActivity.stateView;
import static com.example.textmessageapp.MainActivity.substateView;

public class FiniteStateMachine {

    public String respondByState(String message) {
        String response = "hi";
        switch (currentState) {
            case 1:
                response = greetingState(message);
                stateView.setText("Greeting State");
                currentState++;
                break;
            case 2:
                response = settingUpState(message);
                stateView.setText("Setting Up State");
                currentState++;
                break;
            case 3:
                response = askingOutState(message);
                stateView.setText("Asking Out State");
                currentState++;
                break;
            case 4:
                response = answerState(message);
                stateView.setText("Answer State");
                currentState++;
                break;
            case 5:
                response = tryAgainState(message);
                stateView.setText("Try Again State");
                currentState++;
                break;
        }
        Log.d("TAGG", "State = " + currentState + ", response:" + response);
        return response;
    }

    public String greetingState(String message) {
        Log.d("TAGGG", "greetingstate entered " + currentState);
        String greetingResponse = "";
        Log.d("TAGGG", message);
        if(message.toLowerCase().contains("hi") ||
                message.toLowerCase().contains("hello") ||
                message.toLowerCase().contains("hey") ||
                message.toLowerCase().contains("yo")) {
            greetingResponse = "Hey! You looked really nice yesterday:)";

            Log.d("TAGG", currentState + " ");
        }
        else {
            greetingResponse = "I don't understand what you mean?";
            substateView.setText("Unrecognized response - confusion conveyed");
        }
        return greetingResponse;
    }
    public String settingUpState(String message) {
        Log.d("TAGGG", "settingstate entered " + currentState);
        String settingUpResponse = "";
        if(message.toLowerCase().contains("haha") ||
                message.toLowerCase().contains("thank") ||
                message.toLowerCase().contains("thx") ||
                message.toLowerCase().contains(":)")) {
            settingUpResponse= "Anyway, I wanted to ask you something";

        }
        else {
            settingUpResponse = "I don't understand what you mean?";
            substateView.setText("Unrecognized response - confusion conveyed");
        }

        return settingUpResponse;
    }
    public String askingOutState(String message) {
        Log.d("TAGGG", "askingout entered " + currentState);
        String askingOutResponse = "";
        if(message.toLowerCase().contains("ask") ||
                message.toLowerCase().contains("what") ||
                message.toLowerCase().contains("ok") ||
                message.toLowerCase().contains("go")) {
            askingOutResponse = "Do you want to go out with me?";
        }
        else {
            askingOutResponse = "I don't understand what you mean?";
            substateView.setText("Unrecognized response - confusion conveyed");
        }

        return askingOutResponse;
    }
    public String answerState(String message) {
        Log.d("TAGGG", "answerstate entered " + currentState);
        String answerResponse = "";
        if(message.toLowerCase().contains("sure") ||
                message.toLowerCase().contains("yeah") ||
                message.toLowerCase().contains("ok") ||
                message.toLowerCase().contains("yes")) { // affirmative response
            answerResponse = "Perfect:)";
        }
        else if(message.toLowerCase().contains("no")) { // negative response
            answerResponse = "Ok...how about now?";
            Log.d("TAGG", "else if in answerstate entered");
        }
        else {
            answerResponse = "I don't understand what you mean?";
            substateView.setText("Unrecognized response - confusion conveyed");
        }
        Log.d("TAGG", "message in answerstate: " + answerResponse);

        return answerResponse;
    }
    public String tryAgainState(String message) {
        Log.d("TAGGG", "tryagain entered " + currentState);
        String tryAgainResponse = "";
        if(message.toLowerCase().contains("sure") ||
                message.toLowerCase().contains("yeah") ||
                message.toLowerCase().contains("ok") ||
                message.toLowerCase().contains("yes")) { // affirmative response
            tryAgainResponse = "Perfect:)";
        }
        else if(message.toLowerCase().contains("no")) { // negative response
            tryAgainResponse = "I hope you never find love.";
        }
        else {
            tryAgainResponse = "I don't understand what you mean?";
            substateView.setText("Unrecognized response - confusion conveyed");
        }

        return tryAgainResponse;
    }
    public String finalAnswerState(String message) {
        Log.d("TAGGG", "finalanswer entered " + currentState);
        String finalAnswerResponse = "";
        if(message.toLowerCase().contains("yes") ||
                message.toLowerCase().contains("yeah") ||
                message.toLowerCase().contains("ok") ||
                message.toLowerCase().contains("sure")) { // affirmative response
            finalAnswerResponse = "Perfect:)";
        }
        else if(message.toLowerCase().contains("no")) { // negative response
            finalAnswerResponse = "I hope you never find love";
        }
        else {
            finalAnswerResponse = "I don't understand what you mean?";
            substateView.setText("Unrecognized response - confusion conveyed");
        }

        return finalAnswerResponse;
    }
}
