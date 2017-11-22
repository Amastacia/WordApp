package edu.bistu.cs.se.wordapp;

import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.bistu.cs.se.wordapp.word.Words;

public class YouDaoActivity extends AppCompatActivity {
    private TextView word;
    private TextView translation;
    private TextView web;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_dao);

        Intent intent = getIntent();
        final Words.YouDaoWord youDaoWord = (Words.YouDaoWord)intent.getSerializableExtra("youdaoWord");

//将值设置到TextView中显示


        word = (TextView)findViewById(R.id.youdaoword);
        translation = (TextView)findViewById(R.id.youdaowordmeaning);
        web = (TextView)findViewById(R.id.youdaowordweb);
        update = (Button)findViewById(R.id.btn_update);

        word.setText(youDaoWord.query);
        translation.setText(youDaoWord.translation);
        web.setText(youDaoWord.web.toString());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WordsDB wordsDB=WordsDB.getWordsDB();
                Words.WordDescription item = wordsDB.getSingleWordByYouDao(youDaoWord.query);
                if (item != null) {
                    wordsDB.Update(item.id, item.word, youDaoWord.translation, youDaoWord.web.toString());
                    Toast.makeText(YouDaoActivity.this, "更新单词本成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
