import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;

// 
// Decompiled by Procyon v0.5.36
// 

class MyTextField extends JTextField
{
    int limit;
    
    MyTextField(final int columns, final int limit) {
        super(columns);
        this.limit = limit;
        this.addKeyListener(new KeyAdapter() {
            public void keyTyped(final KeyEvent keyEvent) {
                if (MyTextField.this.getText().length() >= MyTextField.this.limit) {
                    keyEvent.consume();
                }
            }
        });
    }
}