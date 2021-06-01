package sg.edu.rp.c346.id20004969.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textdbs;
    TextView textocbc;
    TextView textuob;
    boolean fdbs = false;
    boolean focbc = false;
    boolean fuob = false;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textdbs = findViewById(R.id.txtdbs);
        textocbc = findViewById(R.id.txtocbc);
        textuob = findViewById(R.id.txtuob);
        registerForContextMenu(textdbs);
        registerForContextMenu(textuob);
        registerForContextMenu(textocbc);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
        if (view == textdbs) {
            wordClicked = "dbs";
        }
        if (view == textocbc) {
            wordClicked = "ocbc";
        } else if (view == textuob) {
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(wordClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urldbs)));
                startActivity(intent);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + (getString(R.string.dbsnum))));
                startActivity(intentCall);
                return true;
            }else{
                if (!fdbs ){
                    fdbs = true;
                    textdbs.setTextColor(Color.RED);
                    textdbs.setTypeface(null, Typeface.BOLD_ITALIC);
                }else {
                    fdbs = false;
                    textdbs.setTextColor(Color.BLACK);
                    textdbs.setTypeface(null, Typeface.NORMAL);
                }
            }
        }
        else  if(wordClicked.equalsIgnoreCase("OCBC")) {
            if (id == R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlocbc)));
                startActivity(intent);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + (getString(R.string.ocbcnum))));
                startActivity(intentCall);
                return true;
            }else{
                if (!focbc){
                    focbc = true;
                    textocbc.setTextColor(Color.RED);
                    textocbc.setTypeface(null, Typeface.BOLD_ITALIC);
                }else {
                    focbc = false;
                    textocbc.setTextColor(Color.BLACK);
                    textocbc.setTypeface(null, Typeface.NORMAL);
                }
            }
        }
        else   if(wordClicked.equalsIgnoreCase("UOB")) {
            if (id == R.id.WebsiteSelection) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urluob)));
                startActivity(intent);
                return true;
            } else if (id == R.id.ContactSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobnum)));
                startActivity(intentCall);
                return true;
            }else{
                if (!fuob){
                    fuob = true;
                    textuob.setTextColor(Color.RED);
                    textuob.setTypeface(null, Typeface.BOLD_ITALIC);
                }else {
                    fuob = false;
                    textuob.setTextColor(Color.BLACK);
                    textuob.setTypeface(null, Typeface.NORMAL);
                }
            }
        }

        return super.onContextItemSelected(item);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            textdbs.setText(getString(R.string.dbs));
            textocbc.setText(getString(R.string.ocbc));
            textuob.setText(getString(R.string.uob));
        } else if (id == R.id.TamilSelection) {
            textdbs.setText(getString(R.string.tdbs));
            textocbc.setText(getString(R.string.tocbc));
            textuob.setText(getString(R.string.tuob));

        } else {
            textdbs.setText("Error translation");
            textocbc.setText("Error translation");
            textuob.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

}
