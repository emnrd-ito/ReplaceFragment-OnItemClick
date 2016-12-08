package example.com.replacefragments_onitemclick.adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.TextView;

import example.com.replacefragments_onitemclick.R;

public class RowItemView extends GridLayout {

    private TextView row0;
    private TextView row1;
    private TextView row2;
    private TextView row3;

    public RowItemView(Context context) {
        super(context);
    }

    public RowItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RowItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        row0 = (TextView) findViewById(R.id.row0);
        row1 = (TextView) findViewById(R.id.row1);
        row2 = (TextView) findViewById(R.id.row2);
        row3 = (TextView) findViewById(R.id.row3);
    }

    @Override
    public String toString() {
        return row0.getText() + "," + row1.getText() + row2.getText() + "," + row3.getText();
    }

}
