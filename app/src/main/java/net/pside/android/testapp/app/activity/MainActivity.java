package net.pside.android.testapp.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.pside.android.testapp.app.R;
import net.pside.android.testapp.app.util.DebugLog;


public class MainActivity extends Activity {

    enum BundleKey {
        SELECTED_ID
    }

    private static final int REQUEST_CODE = 100;

    private Button mButton;
    private TextView mRandomIdTextView, mSelectedTextView;

    private int mRandomId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomId();

        initializeView();
        setupView();
    }

    private void generateRandomId() {
        mRandomId = (int) (Math.random() * 100);
    }

    private void initializeView() {
        mButton = (Button) findViewById(R.id.Main_Button);
        mRandomIdTextView = (TextView) findViewById(R.id.Main_TextView_RandomId);
        mSelectedTextView = (TextView) findViewById(R.id.Main_TextView_Selected);
    }

    private void setupView() {
        mRandomIdTextView.setText(Integer.toString(mRandomId));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt(GroovyActivity.BundleKey.ID.toString(), mRandomId);

                Intent intent = new Intent(MainActivity.this, GroovyActivity.class);
                intent.putExtras(bundle);

                DebugLog.d(bundle.toString());

                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        generateRandomId();

        if (REQUEST_CODE != requestCode) {
            return;
        }

        if (RESULT_OK == resultCode) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    int retVal = bundle.getInt(BundleKey.SELECTED_ID.toString());
                    mSelectedTextView.setText(Integer.toString(retVal));
                }
            }
        }
    }
}
