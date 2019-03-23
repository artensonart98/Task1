package com.example.aditi.task1;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
   Button b1,b2,b3,b4,b5;
   EditText ed1,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        first check the video I sent you via WhatsApp, some functions are not working

//        no need for type casting views. Thanks to Java Generics, this is done automatically
//        t1 = (TextView) findViewById(R.id.textView); type casting is not necessary, the following line will work
        t1 = findViewById(R.id.textView);  //the text of this textview will never change, so there's no need to capture it in java code, we only capture a view if we want to modify it using code
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i =  new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
//                the above code can also be written in the following way, simple one line:
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        t2 = findViewById(R.id.textView2); //similar to t1, this text will also remain constant, so no need for capturing it here
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast toast = Toast.makeText(MainActivity.this,"This is a toast mesaage",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                //no need for creating a toast object and setting margins & all, just display a default toast using the following line:
                Toast.makeText(MainActivity.this, "This ia a toast", Toast.LENGTH_SHORT).show();
            }
        });

        ed1= findViewById(R.id.editText2); //this line is ambiguous , bcoz xml id is editText2, and object name is ed1, try to be consistent while naming, either name the object as ed2 or change xml id to editText1. Getting my point?
        //by the way, this should be a TextView instead of EditText, and when the button is clicked, the text of this textview should change to something else
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = ed1.getText().toString();
            }
        });

        ed2 = findViewById(R.id.editText10);
        ed3 = findViewById(R.id.editText11);
        ed4 = findViewById(R.id.editText12); //this should be a textview, and when b4 is clicked, the value of both edittext should be displayed in this textview after being added. Example if I enter 2 in one editText and 5 in other edittext and click Add button, the text should change to 7
        final int mnum1 = ed2.getInputType(); //no need to get the inputType of edittext. And you should not fetch the value of editText here, it should be fetched inside the onClickListener of the button
        final int mnum2 = ed3.getInputType();
        b4 = findViewById(R.id.button3); //this should be button4, not 3, check the IDs
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //values of editText should be fetched here, like this:
                String value = ed2.getText().toString(); //first we get the value of editText, but remember its a String,not an integer value

                //now after getting the value of the editText, we check whether its an empty string or it has something. If its empty, we just give user a warning by a toast or something else and just simply return from the function, bcoz we can't do anything if the user has not entered anything in the editText
                if (value.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                //now if the value is not empty, we need to get the integer from that string, for that we use the parseInt method, it parses int from a string
                int num1 = Integer.parseInt(value);

                //in the same way we get the other number
                value = ed3.getText().toString();
                if (value.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num2 = Integer.parseInt(value);

                //now that we've got both the integers, we'll add & display them in a textview using the setText method

                int res = mnum1+mnum2;

                ed4.setText(Integer.toString(res));

            }
        });
        b5 = findViewById(R.id.button3); //this should be button5 not 3, check the IDs properly
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
                System.exit(0); //this is not required, only finish() will do the job.
                //Actually there's a difference between finish and System.exit
                //finish() just terminated the current activity or the activity from which it is called
                //but System.exit method terminates the whole JVM, that means all the activities will be closed and restarted except the one from where System.exit() is called
                //Summary: Don't use System.exit() in android, just use finish() to terminate the activity
            }
        });

    }

    //Some Suggestions and advices:

    //1.
    //notice the difference between the braces of the following two methods
    void method1()
    {
        //this is C/C++ way
    }

    void method2() {
        //this is Java's way
    }

    //it however doesn't matter which style of braces you choose, but if we are working with Java
    //we should stick to its coding conventions.
    //This thing create problems when we work in teams, coding standards does not match. If one
    //person uses C++ style coding standards, one is using Java, other is using some other style, it
    //creates problem in code readability. So try to stick to a code convention and follow it.

    //2. If you don't have good knowledge of Constraint layout, just use simple linearlayouts or relativelayout

    /*3. Pay attention to the naming of variables, in small project it doesn't really matter, but it does matter a lot
    in big projects
    Example, the edittext variables for the two numbers can be named as follows:
    etNum1, etNum2.
    Similarly, buttons can be named as;
    btnStartActivity
    btnAdd
    btnExit*/



}
