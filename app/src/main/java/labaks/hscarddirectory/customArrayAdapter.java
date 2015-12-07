package labaks.hscarddirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class customArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] cards;
    private final int[] backs;

    public customArrayAdapter(Context context, String[] cards, int[] backs) {
        super(context, R.layout.first_page_row_layout, cards);
        this.context = context;
        this.cards = cards;
        this.backs = backs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.first_page_row_layout, parent, false);
        TextView label = (TextView)rowView.findViewById(R.id.label);
        label.setText(cards[position]);
        label.setBackgroundDrawable(context.getResources().getDrawable(backs[position]));
        return rowView;
    }
}
