package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.ConversationAction;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";
    operaciones ope = new operaciones();
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button) findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = "";
                String contraseña = "";

                TextView user = (TextView) findViewById(R.id.txt_usuario);
                TextView pass = (TextView) findViewById(R.id.txt_pass);
                usuario = user.getText().toString();
                contraseña = pass.getText().toString();

                if (usuario == "" || contraseña == "") {
                    Toast.makeText(getApplicationContext(), "Rellenar campos necesarios *", Toast.LENGTH_SHORT).show();
                    return;
                }
                int Resultado = ope.getPassword(usuario, contraseña);

                if (Resultado != 1) {
                    Toast.makeText(getApplicationContext(), "Usuario no existe", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(this, "Usuario ingresado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, Menu01.class);
                intent.putExtra("extra",usuario);

                startActivity(intent);
            }
        });

    }
}
    /*
    public void GetTextFromSQL(View v)
    {
        TextView tx1 = (TextView) findViewById(R.id.textView);
        TextView tx2 = (TextView) findViewById(R.id.textView2);
        TextView tx3 = (TextView) findViewById(R.id.textView3 );

        try{
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionClass();
            if(connect != null){
                String query = "Select * from tbpersonas";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next())
                {
                    tx1.setText(rs.getString( 3));
                    tx2.setText(rs.getString( 4));
                }
            }
        }
        catch (Exception ex){
            Log.e("error ", ex.getMessage());

        }
    }
    public void Insert(View v)
    {
        TextView tx3 = (TextView) findViewById(R.id.textView3 );
        int result = ope.adduser();

        if (result  != 1)
        {
            tx3.setText("NOK");
            //tx3.setText( ("Error "+ result));
            //Log.e("Error ","Error");
            return;
        }
        //tx3.setText( ("Error "+ result));
        tx3.setText("OK");
    }
    public  void password(View v) {
        String usuario = "";
        String contraseña = "";

        TextView user = (TextView) findViewById(R.id.txt_usuario);
        TextView pass = (TextView) findViewById(R.id.txt_pass);
        usuario = user.getText().toString();
        contraseña = pass.getText().toString();

        if (usuario == "" || contraseña == "") {
            Toast.makeText(this, "Rellenar campos necesarios *", Toast.LENGTH_SHORT).show();
            return;
        }
        int Resultado = ope.getPassword(usuario, contraseña);

        if (Resultado != 1) {
            Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Usuario ingresado", Toast.LENGTH_SHORT).show();
    }

*/
