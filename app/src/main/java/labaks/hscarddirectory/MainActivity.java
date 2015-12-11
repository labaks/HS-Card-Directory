package labaks.hscarddirectory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static String[] listCards;
    public static int[] backs;
    protected final int NUMBER_OF_CARDS = 3;
    private ListView listView;
    //    private EditText searchField;
    private CustomArrayAdapter adapter;



    private Card cards[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = loadCards();

        listCards = loadListOfCards();
//        loadBackgrounds();

        listView = (ListView) findViewById(R.id.list_view);
//        searchField = (EditText)findViewById(R.id.searchField);

        adapter = new CustomArrayAdapter(this, listCards/*, backs*/);
        listView.setAdapter(adapter);

//        searchField.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                MainActivity.this.adapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }

    private void loadBackgrounds() {
        backs = new int[NUMBER_OF_CARDS];
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            backs[i] = getBaseContext().getResources().getIdentifier("back_" + Integer.toString(i + 1), "drawable", getBaseContext().getPackageName());
        }
    }

    private Card[] loadCards() {
        String name[] = {getString(R.string.wolfrider), getString(R.string.raid_leader), getString(R.string.novice_engineer)};
        String setName[] = {getString(R.string.basic), getString(R.string.basic), getString(R.string.basic)};
        String race[] = {getString(R.string.none_race), getString(R.string.none_race), getString(R.string.none_race)};
        String className[] = {getString(R.string.none_class), getString(R.string.none_class), getString(R.string.none_class)};
        int price[] = {3, 3, 2};
        int attack[] = {3, 2, 1};
        int health[] = {1, 2, 1};
        String type[] = {getString(R.string.minion), getString(R.string.minion), getString(R.string.minion)};
        String rarity[] = {getString(R.string.free), getString(R.string.free), getString(R.string.free)};
        String mechanics[] = {getString(R.string.charge), getString(R.string.passive), getString(R.string.battlecry)};
        for (int i = 0; i > NUMBER_OF_CARDS; i++) {
            Card newCard = new Card(i + 1, name[i], setName[i], race[i], className[i], price[i], attack[i], health[i], type[i], rarity[i], mechanics[i]);
            cards[i] = newCard;
        }
        return cards;
    }

    private String[] loadListOfCards() {
        String[] listCards = new String[NUMBER_OF_CARDS];
        for(int i = 0;i < NUMBER_OF_CARDS;i++) {
            listCards[i] = cards[i].name;
        }
        return listCards;
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
