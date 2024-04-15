package atmSimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	String formNo;
	JTextField panNoTextField, aadharNoTextField;
	JComboBox<String> religionMenu , categoryMenu , incomeMenu , eduMenu , occMenu;
	JRadioButton syes, sno, eyes, eno;
	JButton next;
	
	SignUpTwo(String formNo){
		this.formNo = formNo;
		setTitle("New Account Application Form - Page 2");
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel personalDetails = new JLabel("Page 2 : Additional Details");
		personalDetails.setFont(new Font("Raleway" , Font.BOLD , 24));
		personalDetails.setBounds(265 , 80 , 300 , 30);
		add(personalDetails);
		
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway" , Font.BOLD , 22));
		religion.setBounds(120 , 140 , 300 , 25);
		add(religion);
		
		String religionValues[] = {"Select a Religion" , "Hindu" , "Muslim" , "Sikh" , "Christian" , "Other"};
		religionMenu = new JComboBox<String>(religionValues);
		religionMenu.setBackground(Color.WHITE);
		religionMenu.setBounds(320, 140, 400, 30);
		add(religionMenu);
		
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway" , Font.BOLD , 22));
		category.setBounds(120 , 190 , 300 , 25);
		add(category);
		
		String categoryValues[] = {"Select a Category" , "General" , "OBC" , "SC" , "ST" , "Other"};
		categoryMenu = new JComboBox<String>(categoryValues);
		categoryMenu.setBackground(Color.WHITE);
		categoryMenu.setBounds(320, 190, 400, 30);
		add(categoryMenu);
		
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway" , Font.BOLD , 22));
		income.setBounds(120 , 240 , 300 , 25);
		add(income);
		
		String incomeValues[] = {"Select Income" , "No Income" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000" , "< 10,00,000" , "Above 10,00,000"};
		incomeMenu = new JComboBox<String>(incomeValues);
		incomeMenu.setBackground(Color.WHITE);
		incomeMenu.setBounds(320,240, 400, 25);
		add(incomeMenu);
		
		JLabel education = new JLabel("Education :");
		education.setFont(new Font("Raleway" , Font.BOLD , 22));
		education.setBounds(120 , 290 , 300 , 25);
		add(education);
		
		String eduValues[] = {"Select Education" , "High School" , "Pre University" , "Under Graduate or Bachelors" , "Masters" , "PhD" , "Other"};
		eduMenu = new JComboBox<String>(eduValues);
		eduMenu.setBackground(Color.WHITE);
		eduMenu.setBounds(320, 290, 400, 25);
		add(eduMenu);
		
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway" , Font.BOLD , 22));
		occupation.setBounds(120 , 340 , 300 , 25);
		add(occupation);
		
		String occValues[] = {"Select Occupation" , "Salaried" , "Self-Employed" , "Business" , "Student" , "Retired" , "Other"};
		occMenu = new JComboBox<String>(occValues);
		occMenu.setBackground(Color.WHITE);
		occMenu.setBounds(320, 340, 400, 30);
		add(occMenu);
		
		JLabel panNo = new JLabel("PAN Number :");
		panNo.setFont(new Font("Raleway" , Font.BOLD , 22));
		panNo.setBounds(120 , 390 , 300 , 25);
		add(panNo);
		
		panNoTextField = new JTextField();
		panNoTextField.setBounds(320, 390, 400, 25);
		panNoTextField.setBackground(Color.WHITE);
		add(panNoTextField);
		
		JLabel aadhar = new JLabel("Aadhar Number :");
		aadhar.setFont(new Font("Raleway" , Font.BOLD , 22));
		aadhar.setBounds(120 , 440 , 300 , 25);
		add(aadhar);
		
		aadharNoTextField = new JTextField();
		aadharNoTextField.setFont(new Font("Raleway" , Font.BOLD , 22));
		aadharNoTextField.setBounds(320, 440, 400, 30);
		add(aadharNoTextField);
		
		JLabel seniorCitizen = new JLabel("Senior Citizen :");
		seniorCitizen.setFont(new Font("Raleway" , Font.BOLD , 22));
		seniorCitizen.setBounds(120 , 490 , 300 , 25);
		add(seniorCitizen);
		
		syes = new JRadioButton("Yes");
		syes.setFont(new Font("Raleway" , Font.BOLD , 18));
		syes.setBackground(Color.WHITE);
		syes.setBounds(320, 490, 100, 30);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setFont(new Font("Raleway" , Font.BOLD , 18));
		sno.setBackground(Color.WHITE);
		sno.setBounds(520, 490, 100, 30);
		add(sno);
		
		ButtonGroup seniorCitizenGroup = new ButtonGroup();
		seniorCitizenGroup.add(syes);
		seniorCitizenGroup.add(sno);
		
		JLabel existingAcc = new JLabel("Existing Account :");
		existingAcc.setFont(new Font("Raleway" , Font.BOLD , 22));
		existingAcc.setBounds(120 , 540 , 300 , 25);
		add(existingAcc);
		
		eyes = new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway" , Font.BOLD , 18));
		eyes.setBackground(Color.WHITE);
		eyes.setBounds(320, 540, 100, 30);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setFont(new Font("Raleway" , Font.BOLD , 18));
		eno.setBackground(Color.WHITE);
		eno.setBounds(520, 540, 100, 30);
		add(eno);
		
		ButtonGroup existingAccGroup = new ButtonGroup();
		existingAccGroup.add(eyes);
		existingAccGroup.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(640, 650, 80, 30);
		next.addActionListener(this);
		add(next);
		
		setSize(850 , 800);
		setLocation(350,10);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String sformNo = formNo; 
		String religion = (String)religionMenu.getSelectedItem();
		String category = (String)categoryMenu.getSelectedItem();
		String income = (String)incomeMenu.getSelectedItem();
		String education = (String)eduMenu.getSelectedItem();
		String occupation = (String)occMenu.getSelectedItem();
		String panNo = panNoTextField.getText();
		String aadhar = aadharNoTextField.getText();
		String seniorCitizen = null;
		if(syes.isSelected()) {
			seniorCitizen = "Yes";
		}else if(sno.isSelected()) {
			seniorCitizen = "No";
		}
		String existingAcc = null;
		if(eyes.isSelected()) {
			existingAcc = "Yes";
		}else if(eno.isSelected()) {
			existingAcc = "No";
		}
		
		try {
			if(religion.equals("Select a Religion")) {
				JOptionPane.showMessageDialog(null, "Religion is Required");
			} else if(category.equals("Select a Category")) {
				JOptionPane.showMessageDialog(null, "Category is Required");
			} else if(income.equals("Select Income")) {
				JOptionPane.showMessageDialog(null, "Income is Required");
			} else if(education.equals("Select Education")) {
				JOptionPane.showMessageDialog(null, "Education is Required");
			} else if(occupation.equals("Select Occupation")) {
				JOptionPane.showMessageDialog(null, "Occupation is Required");
			} else if(panNo.equals("")) {
				JOptionPane.showMessageDialog(null, "PAN Number is Required");
			} else if(aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
			} else if(seniorCitizen.equals("")) {
				JOptionPane.showMessageDialog(null, "Senior Citizen Information is Required");
			} else if(existingAcc.equals("")){
				JOptionPane.showMessageDialog(null, "Existing Account Information is Required");
			}else {
				Conn con = new Conn();
				String query = "INSERT INTO signuptwo values('"+sformNo+"' , '"+religion+"' , '"+category+"' , '"+income+"' , '"+education+"' , '"+occupation+"' , '"+panNo+"' , '"+aadhar+"' , '"+seniorCitizen+"' , '"+existingAcc+"')";
				con.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpThree(formNo);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
