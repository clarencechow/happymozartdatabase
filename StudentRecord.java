
import java.io.*;
import java.io.Serializable;
import java.util.Calendar;

public class StudentRecord implements Serializable {
    /*
    private int numberOfClasses, paymentType[] = new int[2], classType[] = new int[2], classDay[] = new int[2], 
              paymentsLeft[] = new int[2], classTime[] = new int[2];
    private String firstName, lastName, address, phoneNumber, email, fatherName, motherName,
        comment, parentEmail, creditCardNumber, expireDate, instructorName[] = new String[2], threeDigitID, zipCode, city;
    private double amountLeft[] = new double[2], amountPaid[] = new double[2], nextPaymentAmount[] = new double[2];
    private int classEndYear[] = new int[2], classEndMonth[] = new int[2], classEndDay[] = new int[2], 
        nextPaymentYear[] = new int[2], nextPaymentMonth[] = new int[2], nextPaymentDay[] = new int[2];
    */
    private int I[] = new int[34];
    private int trackerInput[][] = new int[40][2];
    private String S[] = new String[31];
    public String input[] = new String[50];
    private boolean Bo[] = new boolean[4];
    private double D[] = new double[3];
    private long l;
    
    //clarence stuff
    private String cmnt = "";
    private String books[] = new String[4];

    public StudentRecord() {
        //this( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
        //      0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ); 
        for( int i = 0; i < I.length; i++ ) {
        	I[i] = 0;
        }
        for( int i = 0; i < S.length; i++ ) {
        	S[i] = "";
        }
        for( int i = 0; i < Bo.length; i++ ) {
        	Bo[i] = false;
        }
        for( int i = 0; i < D.length; i++ ) {
        	D[i] = 0.0;
        }
        l = 0;
    }
    private String readString( RandomAccessFile f, int l ) throws IOException {
        char str[] = new char[ l ], tmp;

        for( int i = 0; i < str.length; i++ ) {
            tmp = f.readChar();
            str[ i ] = tmp;
        }

        return new String( str ).replace( '\0', ' ' );
    }
/*
    public void read( RandomAccessFile f ) throws IOException {
        String str[] = { "", "" };
        double d[] = { 0.0, 0.0 };

        for( int i = 0; i < 32; i++ ){
        	I[i] = f.readInt();
        	
        }

        S[0] = readString( f, 20 ).trim(); 	//writeString( f, S[0], 20 );
        S[1] = readString( f, 20 ).trim(); 	//writeString( f, S[1], 20 );
        S[2] = readString( f, 30 ).trim();		//writeString( f, S[2], 30 );
        S[3] = readString( f, 20 ).trim();		//writeString( f, S[3], 20 );
        S[4] = readString( f, 10 ).trim();		//writeString( f, S[4], 10 );
        
        S[5] = readString( f, 30 ).trim();		//writeString( f, S[5], 30 );
        S[6] = readString( f, 30 ).trim();		//writeString( f, S[6], 30 );
        S[7] = readString( f, 30 ).trim();		//writeString( f, S[7], 30 );
        S[8] = readString( f, 30 ).trim();		//writeString( f, S[8], 30 );
        S[9] = readString( f, 30 ).trim();		//writeString( f, S[9], 30 );
        
        S[10] = readString( f, 15 ).trim();		//writeString( f, S[10], 10 );
        S[11] = readString( f, 50 ).trim();		//writeString( f, S[11], 4 );
        S[12] = readString( f, 50 ).trim();		//writeString( f, S[12], 50 );
        S[13] = readString( f, 20 ).trim();		//writeString( f, S[13], 20 );
        S[14] = readString( f, 30 ).trim();
        S[15] = readString( f, 30 ).trim();
        S[16] = readString( f, 30 ).trim();
        S[17] = readString( f, 30 ).trim();
        S[18] = readString( f, 30 ).trim();
        S[19] = readString( f, 50 ).trim();
        S[20] = readString( f, 20 ).trim();
        for( int i = 0; i < 40; i++ ) {
        	input[i] = readString( f, 25 ).trim();
        }
        for( int i = 0; i < 3; i++ ) {
        	Bo[i] = f.readBoolean();
        }
        I[32] = f.readInt();
        I[33] = f.readInt();
    }
*/
	public void read( RandomAccessFile f ) throws IOException {
        String str[] = { "", "" };
        double d[] = { 0.0, 0.0 };

        for( int i = 0; i < 32; i++ ){
        	I[i] = f.readInt();
        	
        }
        S[0] = readString( f, 20 ).trim(); 	//writeString( f, S[0], 20 );
        S[1] = readString( f, 20 ).trim(); 	//writeString( f, S[1], 20 );
        S[2] = readString( f, 30 ).trim();		//writeString( f, S[2], 30 );
        S[3] = readString( f, 20 ).trim();		//writeString( f, S[3], 20 );
        S[4] = readString( f, 10 ).trim();		//writeString( f, S[4], 10 );
        
        S[5] = readString( f, 30 ).trim();		//writeString( f, S[5], 30 );
        S[6] = readString( f, 30 ).trim();		//writeString( f, S[6], 30 );
        S[7] = readString( f, 30 ).trim();		//writeString( f, S[7], 30 );
        S[8] = readString( f, 30 ).trim();		//writeString( f, S[8], 30 );
        S[9] = readString( f, 30 ).trim();		//writeString( f, S[9], 30 );
        
        S[10] = readString( f, 15 ).trim();		//writeString( f, S[10], 10 );
        S[11] = readString( f, 50 ).trim();		//writeString( f, S[11], 4 );
        S[12] = readString( f, 50 ).trim();		//writeString( f, S[12], 50 );
        S[13] = readString( f, 20 ).trim();		//writeString( f, S[13], 20 );
        S[14] = readString( f, 30 ).trim();
        S[15] = readString( f, 30 ).trim();
        S[16] = readString( f, 30 ).trim();
        S[17] = readString( f, 30 ).trim();
        S[18] = readString( f, 30 ).trim();
        S[19] = readString( f, 50 ).trim();
        S[20] = readString( f, 20 ).trim();
        
        for( int i = 0; i < 50; i++ ) {
        	input[i] = readString( f, 25 ).trim();
        }
        for( int i = 0; i < 3; i++ ) {
        	Bo[i] = f.readBoolean();
        }
        I[32] = f.readInt();
        I[33] = f.readInt();
        readComment(f);

    }
    
    /*public void readComment() throws IOException {
	    RandomAccessFile f = new RandomAccessFile("CommentList.txt", "rw");
	    f.seek(0);
	    int entries = f.readInt();
	    String name = getFirstName() + " " + getLastName();
	    
	    for(int i = 0; i < entries; i++) {
		    f.seek(i*600+10);
		    if(name.equals(readString(f, 30).trim())) {
		    	cmnt = readString(f, 250).trim();
		    	return;
	    	}
	    }
	    cmnt = "";
    }
    
    public void writeComment() throws IOException {
	    RandomAccessFile f = new RandomAccessFile("CommentList.txt", "rw");
	    f.seek(0);
	    int entries = f.readInt();
	    String name = getFirstName() + " " + getLastName();
	    
	    for(int i = 0; i < entries; i++) {
		    f.seek(i*600+10);
		    if(name.equals(readString(f, 30).trim())) {
			    writeString(f, cmnt, 250);
			    return;
		    }
	    }
	    f.seek(entries*600 + 10);
	    writeString(f, name, 30);
	    writeString(f, cmnt, 250);
	    f.seek(0);
	    f.writeInt(entries+1);
    }*/
    public void readComment(RandomAccessFile f) throws IOException { //includes reading books
	    long fp = f.getFilePointer();
	    f.seek(fp + 30000000);
	    try {
		    cmnt = readString(f, 500).trim();

		    for(int i = 0; i < books.length; i++) {
		    	books[i] = readString(f, 40).trim();
	    	}
	    } catch(IOException ioe) {
		    cmnt = "";
		     for(int i = 0; i < books.length; i++) {
		    	books[i] = "";
	    	}
	    	System.out.println("MISTAKE HEREMISTAKE HEREMISTAKE HEREMISTAKE HEREMISTAKE HEREMISTAKE HEREMISTAKE HEREMISTAKE HEREMISTAKE HERE");
	    }
	    
	    f.seek(fp - 1);
    }
    public void writeComment(RandomAccessFile f) throws IOException { //includes writing books
	    long fp = f.getFilePointer();
	    f.seek(fp + 30000000);
	    writeString(f, cmnt, 500);
	    for(int i = 0; i < books.length; i++) {
		    writeString(f, books[i], 40);
	    }
	    f.seek(fp-1);
    }
/*    
    public void write( RandomAccessFile f ) throws IOException {
        
        for( int i = 0; i < 32; i++ ){
        	f.writeInt( I[i] );
        	
        }
        writeString( f, S[0], 20 );
        writeString( f, S[1], 20 );
        writeString( f, S[2], 30 );
        writeString( f, S[3], 20 );
        writeString( f, S[4], 10 );
        writeString( f, S[5], 30 );
        writeString( f, S[6], 30 );
        writeString( f, S[7], 30 );
        writeString( f, S[8], 30 );
        writeString( f, S[9], 30 );
        writeString( f, S[10], 15 );
        writeString( f, S[11], 50 );
        writeString( f, S[12], 50 );
        writeString( f, S[13], 20 );
        writeString( f, S[14], 30 );
        writeString( f, S[15], 30 );
        writeString( f, S[16], 30 );
        writeString( f, S[17], 30 );
        writeString( f, S[18], 30 );
        writeString( f, S[19], 50 );
        writeString( f, S[20], 20 );
        for( int i = 0; i < 40; i++ ) {
        	writeString( f, input[i], 25 );
        }
        for( int i = 0; i < 3; i++ ) {
        	f.writeBoolean( Bo[i] );
        }
        f.writeInt( I[32] );
        f.writeInt( I[33] );
    }
*/    
    public void write( RandomAccessFile f ) throws IOException {
        
        for( int i = 0; i < 32; i++ ){
        	f.writeInt( I[i] );
        	
        }
        writeString( f, S[0], 20 );
        writeString( f, S[1], 20 );
        writeString( f, S[2], 30 );
        writeString( f, S[3], 20 );
        writeString( f, S[4], 10 );
        writeString( f, S[5], 30 );
        writeString( f, S[6], 30 );
        writeString( f, S[7], 30 );
        writeString( f, S[8], 30 );
        writeString( f, S[9], 30 );
        writeString( f, S[10], 15 );
        writeString( f, S[11], 50 );
        writeString( f, S[12], 50 );
        writeString( f, S[13], 20 );
        writeString( f, S[14], 30 );
        writeString( f, S[15], 30 );
        writeString( f, S[16], 30 );
        writeString( f, S[17], 30 );
        writeString( f, S[18], 30 );
        writeString( f, S[19], 50 );
        writeString( f, S[20], 20 );
        for( int i = 0; i < 50; i++ ) {
        	writeString( f, input[i], 25 );
        }
        for( int i = 0; i < 3; i++ ) {
        	f.writeBoolean( Bo[i] );
        }
        f.writeInt( I[32] );
        f.writeInt( I[33] );
        writeComment(f);
    }
    
    private void writeString( RandomAccessFile f, String s, int length ) throws IOException{
        StringBuffer buf = null;

        if( s != null ) 
            buf = new StringBuffer( s );
        else 
            buf = new StringBuffer( length );
        
        buf.setLength( length );
        f.writeChars( buf.toString() );
    }

    //public static int size() { return 4000; }
    public static int size() { return 5000; }
    public static int trackerSize() { return 3000; }
    
    public void setPhone1( int b ) { I[0] = b; }
    public int getPhone1() { return I[0]; }
    
    public void setPhone2( int b ) { I[1] = b; }
    public int getPhone2() { return I[1]; }
    
    public void setPhone3( int b ) { I[2] = b; }
    public int getPhone3() { return I[2]; }
    
    public void setClassDay( int b ) { I[3] = b; }
    public int getClassDay() { return I[3]; }
    
    public void setClassTimeHour( int b ) { I[4] = b; }
    public int getClassTimeHour() { return I[4]; }
    
    public void setClassTimeMin( int b ) { I[5] = b; }
    public int getClassTimeMin() { return I[5]; }
    
    public void setClassTimeAMPM( int b ) { I[6] = b; }
    public int getClassTimeAMPM() { return I[6]; }
    
    public void setClassDay2( int b ) { I[7] = b; }
    public int getClassDay2() { return I[7]; }
    
    public void setClassTimeHour2( int b ) { I[8] = b; }
    public int getClassTimeHour2() { return I[8]; }
    
    public void setClassTimeMin2( int b ) { I[9] = b; }
    public int getClassTimeMin2() { return I[9]; }
    
    public void setClassTimeAMPM2( int b ) { I[10] = b; }
    public int getClassTimeAMPM2() { return I[10]; }
    
    public void setClassDuration2( int b ) { I[11] = b; }
    public int getClassDuration2() { return I[11]; }
    
    public void setEndYearCurrent( int b ) { I[12] = b; }
    public int getEndYearCurrent() { return I[12]; }
    
    public void setPaymentMonthCurrent( int b ) { I[13] = b; }
    public int getPaymentMonthCurrent() { return I[13]; }
    
    public void setPaymentDayCurrent( int b ) { I[14] = b; }
    public int getPaymentDayCurrent() { return I[14]; }
    
    public void setPaymentYearCurrent( int b ) { I[15] = b; }
    public int getPaymentYearCurrent() { return I[15]; }
    
    public void setNextPaymentMonth( int b ) { I[16] = b; }
    public int getNextPaymentMonth() { return I[16]; }
    
    public void setNextPaymentDay( int b ) { I[17] = b; }
    public int getNextPaymentDay() { return I[17]; }
    
    public void setNextPaymentYear( int b ) { I[18] = b; }
    public int getNextPaymentYear() { return I[18]; }
    
    public void setStartMonthNext( int b ) { I[19] = b; }
    public int getStartMonthNext() { return I[19]; }
    
    public void setStartDayNext( int b ) { I[20] = b; }
    public int getStartDayNext() { return I[20]; }
    
    public void setStartYearNext( int b ) { I[21] = b; }
    public int getStartYearNext() { return I[21]; }
    
    public void setEndMonthNext( int b ) { I[22] = b; }
    public int getEndMonthNext() { return I[22]; }
    
    public void setEndDayNext( int b ) { I[23] = b; }
    public int getEndDayNext() { return I[23]; }
    
    public void setEndYearNext( int b ) { I[24] = b; }
    public int getEndYearNext() { return I[24]; }
    
    public void setPaymentMonthNext( int b ) { I[25] = b; }
    public int getPaymentMonthNext() { return I[25]; }
    
    public void setPaymentDayNext( int b ) { I[26] = b; }
    public int getPaymentDayNext() { return I[26]; }
    
    public void setPaymentYearNext( int b ) { I[27] = b; }
    public int getPaymentYearNext() { return I[27]; }
    
    public void setClassType( int b ) { I[28] = b; }
    public int getClassType() { return I[28]; }
    
    public void setBirthdayMonth( int b ) { I[29] = b; }
    public int getBirthdayMonth() { return I[29]; }
    
    public void setBirthdayDay( int b ) { I[30] = b; }
    public int getBirthdayDay() { return I[30]; }
    
    public void setBirthdayYear( int b ) { I[31] = b; }
    public int getBirthdayYear() { return I[31]; }
    
    public void setClassDuration( int b ) { I[32] = b; }
    public int getClassDuration() { return I[32]; }
    
    public void setClassPeriod( int b ) {I[33] = b; }
    public int getClassPeriod() { return I[33]; }
    
    public void setFirstName( String s ) { S[0] = s; }
    public String getFirstName() { return S[0]; }
    
    public void setLastName( String s ) { S[1] = s; }
    public String getLastName() { return S[1]; }
    
    public void setAddress( String s ) { S[2] = s; }
    public String getAddress() { return S[2]; }
    
    public void setCity( String s ) { S[3] = s; }
    public String getCity() { return S[3]; }
    
    public void setZipCode( String s ) { S[4] = s; }
    public String getZipCode() { return S[4]; }
    
    public void setEMail( String s ) { S[5] = s; }
    public String getEMail() { return S[5]; }
    
    public void setDadName( String s ) { S[6] = s; }
    public String getDadName() { return S[6]; }
    
    public void setMomName( String s ) { S[7] = s; }
    public String getMomName() { return S[7]; }
    
    public void setParentEMail( String s ) { S[8] = s; }
    public String getParentEMail() { return S[8]; }
    
    public void setTelephoneNumber( String s ) { S[9] = s; }
    public String getTelephoneNumber() { return S[9]; }
    
    public void setClassName( String s ) { S[10] = s; }
    public String getClassName() { return S[10]; }
    
    public void setClassInfoComment( String s ) { S[11] = s; }
    public String getClassInfoComment() { return S[11]; }
    
    public void setComment( String s ) { cmnt = s; }
    public String getComment() { return cmnt; }
    
    public void setInstructorName( String s ) { S[13] = s; }
    public String getInstructorName() { return S[13]; }
    
    public void setCellPhoneNumber( String s ) { S[14] = s; }
    public String getCellPhoneNumber() { return S[14]; }
    
    public void setParentCellPhoneNumber( String s ) { S[15] = s; }
    public String getParentCellPhoneNumber() { return S[15]; }
    
    public void setPictureName( String s ) { S[16] = s; }
    public String getPictureName() { return S[16]; }
    
    public void setWithdrawFilingDate( String s ) { S[17] = s; }
    public String getWithdrawFilingDate() { return S[17]; }
    
    public void setLastdayDate( String s ) { S[18] = s; }
    public String getLastdayDate() { return S[18]; }
    
    public void setWithdrawReason( String s ) { S[19] = s; }
    public String getWithdrawReason() { return S[19]; }
    
    public void setStudentTeacherId( String s ) { S[20] = s; }
    public String getStudentTeacherId() { return S[20]; }
    
    public void setInput( String in[] ) { 
    	for( int i = 0; i < input.length; i++ ) {
    		input[i] = in[i]; 
    	}
    }
    public String[] getInput() { return input; }
    
    //clarence stuff
    public void setBook1(String s) { books[0] = s; }
    public String getBook1() { return books[0]; }
    public void setBook2(String s) { books[1] = s; }
    public String getBook2() { return books[1]; }
    public void setBook3(String s) { books[2] = s; }
    public String getBook3() { return books[2]; }
    public void setBook4(String s) { books[3] = s; }
    public String getBook4() { return books[3]; }

    
    
    
    public void setNextPaymentPaid( boolean b ) { Bo[0] = b; }
    public boolean getNextPaymentPaid() { return Bo[0]; }
    
    public void setNextPaymentDiscontinued( boolean b ) { Bo[1] = b; }
    public boolean getNextPaymentDiscontinued() { return Bo[1]; }
    
    public void setIsRegistered( boolean b ) { Bo[2] = b; }
    public boolean getIsRegistered() { return Bo[2]; }
    
    public void resetAllFields() {
    	for( int i = 0; i < I.length; i++ ) {
        	I[i] = 0;
        }
        for( int i = 0; i < S.length; i++ ) {
        	S[i] = "";
        }
        for( int i = 0; i < Bo.length; i++ ) {
        	Bo[i] = false;
        }
        for( int i = 0; i < input.length; i++ ) {
        	input[i] = "";
        }
        for( int i = 0; i < D.length; i++ ) {
        	D[i] = 0.0;
        }
        cmnt = "";
        l = 0;
    }
    
    public void copyAllFields( StudentRecord copy ) {
    	for( int i = 0; i < I.length; i++ ) {
        	I[i] = copy.I[i];
        }
        for( int i = 0; i < S.length; i++ ) {
        	S[i] = copy.S[i];
        }
        for( int i = 0; i < input.length; i++ ) {
        	input[i] = copy.input[i];
        }
        for( int i = 0; i < Bo.length; i++ ) {
        	Bo[i] = copy.Bo[i];
        }
        for( int i = 0; i < D.length; i++ ) {
        	D[i] = copy.D[i];
        }
        cmnt = copy.cmnt;
        l = copy.l;
    }
    //birthdaystuff
    public boolean getIsWithdraw(int todayYear, int todayMonth, int todayDay) {
    boolean withdraw = false;
    String filingDate = getLastdayDate();
    if (filingDate.length() == 6) {
      int d = Integer.parseInt(filingDate.substring(2, 4));
      int m = Integer.parseInt(filingDate.substring(0, 2));
      int y = Integer.parseInt(filingDate.substring(4)) + 2000;
      if (d != 0)
        if ((((m != 0) ? 1 : 0) & ((y != 2007) ? 1 : 0)) != 0)
          if (y < todayYear || (y == todayYear && m < todayMonth) || (y == todayYear && m == todayMonth && d < todayDay))
            withdraw = true;   
    } 
    return withdraw;
  }

}
