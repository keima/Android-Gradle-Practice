package net.pside.android.testapp.app

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import groovy.transform.CompileStatic

@CompileStatic
class GroovyActivity extends Activity {

    Button mButton;

    List range = 0..100

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mButton = findViewById(R.id.button) as Button
        mButton.setText("Go back ancient Java...")
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            void onClick(View v) {
                finish()
            }
        })

        log(range.size().toString())

    }

    private static void log(String msg) {
        Log.d('GroovyActivity', msg)
    }

}
