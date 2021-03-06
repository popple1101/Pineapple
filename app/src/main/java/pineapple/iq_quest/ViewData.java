/**
 * 2016-12-20
 * view data activity in the application
 * @author JuKyYoon
 * @version 1.0
 */

package pineapple.iq_quest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pineapple.for_future.R;

public class ViewData extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lanking);
        MySQLiteOpenHelper dbHelper = MainMenuActivity.helper; //make a SQLiteopenhelper

        TextView result_text = (TextView)findViewById(R.id.result);
        result_text.setText(dbHelper.getResult());

    }

    /**
     * On click.
     * if backtomain is clicked, this activity is finished
     * if delete button is clicked, all database is deleted
     * @param view the view
     * @return void
     */
    public void onClick(View view){
        switch (view.getId()){
            case R.id.backtomain:
                finish();
                break;
            case R.id.delete:
                MySQLiteOpenHelper dbHelper = MainMenuActivity.helper;
                dbHelper.deleteAll();
                TextView result_text = (TextView)findViewById(R.id.result);
                result_text.setText(dbHelper.getResult());
                break;
        }
    }

}
