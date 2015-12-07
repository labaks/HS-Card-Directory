package labaks.hscarddirectory;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static String[] listCards;
    public static int[] backs;
    protected final int NUMBER_OF_CARDS = 3;
    private ListView listView;
    private EditText searchField;
    private customArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCards = getResources().getStringArray(R.array.listCards);
        loadBackgrounds();

        listView = (ListView)findViewById(R.id.list_view);
        searchField = (EditText)findViewById(R.id.searchField);

        adapter = new customArrayAdapter(this, listCards, backs);
        listView.setAdapter(adapter);

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void loadBackgrounds() {
        backs = new int[NUMBER_OF_CARDS];
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            backs[i] = getBaseContext().getResources().getIdentifier("back_" + Integer.toString(i + 1), "drawable", getBaseContext().getPackageName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
