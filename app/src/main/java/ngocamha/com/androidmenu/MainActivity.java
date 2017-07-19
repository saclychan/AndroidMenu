package ngocamha.com.androidmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int ID_ABOUT  = 0 ;
    public static final int ID_SETING = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
        registerForContextMenu(textView);
    }

    //create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //cach 1: dung file xml
        //getMenuInflater().inflate(R.menu.option_menu, menu);

        //cach 2: dinh nghia trong code java
        menu.add(Menu.NONE, ID_ABOUT, Menu.NONE, "About from code");
        menu.add(Menu.NONE, ID_SETING, Menu.NONE, "Seting from code 2");
        return super.onCreateOptionsMenu(menu);
    }

    //event item selected handed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case ID_ABOUT:
                Toast.makeText(this, "Select About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(this, "About Item selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_settings:
                Toast.makeText(this, "Seting Item selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_search:
                Toast.makeText(this, "Search Item selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.copy:
                Toast.makeText(this, "Copy from contxt", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
        Menu menu = popupMenu.getMenu();
        getMenuInflater().inflate(R.menu.context_menu, menu );
        popupMenu.show();

    }
}
