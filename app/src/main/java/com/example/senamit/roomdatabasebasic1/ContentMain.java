package com.example.senamit.roomdatabasebasic1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContentMain extends AppCompatActivity {

    public static final String RESULT_EXTRA = "com.example.senamit.roomdatabasebasic1.REPLY";
    private static final String  LOG_TAG = ContentMain.class.getSimpleName();
    private EditText mEditText;
    private Button mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_main);

        mEditText = findViewById(R.id.edit_text);
        mBtnSave = findViewById(R.id.button_save);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditText.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }else {
                    String word = mEditText.getText().toString();
                    replyIntent.putExtra(RESULT_EXTRA, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();

            }
        });


    }
}
