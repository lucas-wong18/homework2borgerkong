package com.example.homework2borgerkong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Click extends AppCompatActivity {

    public TextView name;
    public TextView blurb;
    public TextView cost;
    public ImageView image;
    public Button add;
    public EditText amount;
    public Button increase;
    public Button decrease;
    public TextView showValue;

    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        getSupportActionBar().hide();

        name = findViewById(R.id.name);
        blurb = findViewById(R.id.blurb);
        cost = findViewById(R.id.cost);
        image = findViewById(R.id.image);




        int itemPosition = getIntent().getIntExtra("foodID", -1);
        final MenuItem currentItem = Database.getMenuItemById(itemPosition);


        name.setText(currentItem.getName());
        blurb.setText(currentItem.getBlurb());
        cost.setText(String.format("$" + "%,.2f", currentItem.getCost()));
        image.setImageResource(currentItem.getImageID());


        add = findViewById(R.id.add);
        amount = findViewById(R.id.editText);

        showValue = findViewById(R.id.editText);


        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (amount.getText().toString().equals("0")){
                    Toast.makeText(Click.this, "Please enter quantity", Toast.LENGTH_SHORT).show();
                } else {
                    int quantity = Integer.parseInt(amount.getText().toString());

                    for (int i = 0; i < quantity; i++) {
                        String text = currentItem.getName();
                        Toast.makeText(Click.this, quantity + " " + text + "(s)" + " added to order", Toast.LENGTH_SHORT).show();
                        Order.menuCost.add(currentItem.getCost());
                        Order.menuOrder.add(currentItem);
                        finish();
                    }
                }
            }
        });
    }





    public void inputIncrease(View view) {
        counter++;
        showValue.setText(Integer.toString(counter));

    }

    public void inputDecrease (View view){
        if (counter > 0) {

            counter--;
        }
        showValue.setText(Integer.toString(counter));
    }
}
