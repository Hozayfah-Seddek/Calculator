import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
	ImageIcon image = new ImageIcon("C:\\Codding\\Side-Projects\\Calculator\\img.png");
	int root = 8730; //ascii root
	int root3 = 8731; //ascii q-root
	Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
	JFrame frame;
	JTextField textField;
	JButton[] numbers = new JButton[10];
	JButton[] operations = new JButton[12];
	JButton add,sub,mul,div,pwr,rot, rot3;
	JButton dec,equ,del,clr,neg;
	JPanel panel;
	Font myFont = new Font("Bahnschrift SemiBold", Font.PLAIN, 30);
	double num1=0,num2=0,res=0;
	char op;
	Boolean AEq = false; 
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setIconImage(image.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,800);
		frame.setBackground(new Color(163,204,247));
		frame.setLayout(null);
		frame.setResizable(false);
		textField = new JTextField();
		textField.setBounds(40,20,500,100);
		textField.setFont(myFont);
		textField.setBackground(new Color(198,198,198));
		textField.setBorder(border);
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("x");
		div = new JButton("/");
		pwr = new JButton("^");
		rot = new JButton(Character.toString(root));
		rot3 = new JButton(Character.toString(root3));
		dec = new JButton(".");
		equ = new JButton("=");
		del = new JButton("Del");
		clr = new JButton("C");
		neg = new JButton("( - )");
		operations[0] = add;
		operations[1] = sub;
		operations[2] = mul;
		operations[3] = div;
		operations[4] = pwr;
		operations[5] = rot;
		operations[6] = rot3;
		operations[7] = dec;
		operations[8] = equ;
		operations[9] = del;
		operations[10] = clr;
		operations[11] = neg;
		for (int i=0; i < operations.length; i++) {
			operations[i].addActionListener(this);
			operations[i].setFont(myFont);
			operations[i].setFocusable(false);
		}
		for (int i=0; i < numbers.length; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFont(myFont);
			numbers[i].setFocusable(false);
		}
		neg.setBounds(440, 130, 100, 50);
		del.setBounds(440, 190, 100, 50);
		clr.setBounds(315, 190, 100, 50);
		pwr.setBounds(180, 190, 100, 50);
		rot.setBounds(40, 190, 100, 50);
		rot3.setBounds(40, 130, 100, 50);
		panel = new JPanel();
		panel.setBounds(40, 250, 500, 500);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(new Color(194, 192, 196));
		for (int i = 1; i < 4; i++) {
			panel.add(numbers[i]);
		}
		panel.add(add);
		for (int i = 4; i < 7; i++) {
			panel.add(numbers[i]);
		}
		panel.add(sub);
		for (int i = 7; i < 10; i++) {
			panel.add(numbers[i]);
		}
		panel.add(mul);
		panel.add(dec);
		panel.add(numbers[0]);
		panel.add(equ);
		panel.add(div);
		frame.add(panel);
		frame.add(neg);
		frame.add(del);
		frame.add(clr);
		frame.add(pwr);
		frame.add(rot);
		frame.add(rot3);
		frame.add(textField);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator();
	}
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<10; i++) {
			if (e.getSource() == numbers[i]) {
				if (AEq) {
					AEq = false;
					textField.setText("");
				}
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == dec){
			textField.setText(textField.getText().concat("."));
		}
		if (e.getSource() == add){
			num1 = Double.parseDouble(textField.getText());
			op = '+';
			AEq = true;
		}
		if (e.getSource() == sub){
			num1 = Double.parseDouble(textField.getText());
			op = '-';
			AEq = true;
		}
		if (e.getSource() == mul){
			num1 = Double.parseDouble(textField.getText());
			op = '*';
			AEq = true;
		}
		if (e.getSource() == div){
			
			num1 = Double.parseDouble(textField.getText());
			op = '/';
			AEq = true;
		}
		if (e.getSource() == pwr){
			num1 = Double.parseDouble(textField.getText());
			op = '^';
			AEq = true;
		}
		if (e.getSource() == rot){
			num1 = Double.parseDouble(textField.getText());
			if (num1 < 0) {
				res = Math.sqrt(num1 *= -1);
				textField.setText(String.valueOf(res) + "i");
			}
			else {
				res = Math.sqrt(num1);
				textField.setText(String.valueOf(res));
				num1 = res;
			}
			AEq = true;
		}
		if (e.getSource() == rot3) {
			num1 = Double.parseDouble(textField.getText());
			if (num1 < 0) {
				res = Math.cbrt(num1 *= -1);
				textField.setText(String.valueOf(res));
			}
			else {
				res = Math.cbrt(num1);
				textField.setText(String.valueOf(res));
				num1 = res;
			}
			AEq = true;
		}
		if (e.getSource() == equ){
			num2=Double.parseDouble(textField.getText());
			switch(op){
			case'+':
				res = num1 + num2;
				textField.setText(String.valueOf(res));
				num1 = res;
				break;
			case'-':
				res = num1 - num2;
				textField.setText(String.valueOf(res));
				num1 = res;
				break;
			case'*':
				res = num1 * num2;
				textField.setText(String.valueOf(res));
				num1 = res;
				break;
			case'/':
				if (num2 != 0) {
					res = num1 / num2;
					textField.setText(String.valueOf(res));
					num1 = res;
				}
				else {
					textField.setText("Can not divide by 0!");
				}
				break;
			case'^':
				res = Math.pow(num1, num2);
				textField.setText(String.valueOf(res));
				num1 = res;
				break;
			}

			AEq = true;
		}
		if (e.getSource() == clr) {
			textField.setText("");
		}
		if (e.getSource() == del) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length()-1; i++){
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		if (e.getSource() == neg) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}
}