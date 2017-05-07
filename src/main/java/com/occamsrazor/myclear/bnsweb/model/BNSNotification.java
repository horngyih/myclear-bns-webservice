package com.occamsrazor.myclear.bnsweb.model;

public class BNSNotification{
    public static final int PAYERBANKNUM = 0;
    public static final int PAYERBANKNAME = 1;
    public static final int BILLERBANKNUM = 2;
    public static final int BILLERBANKNAME = 3;
    public static final int ACCOUNTTYPE = 4;
    public static final int BILLERCODE = 5;
    public static final int BILLERCODENAME = 6;
    public static final int NBSPREF = 7;
    public static final int CHANNEL = 8;
    public static final int DEBITTIMESTAMP = 9;
    public static final int REPEATMSG = 10;
    public static final int RRN = 11;
    public static final int RRN2 = 12;
    public static final int CURRENCYCODE = 13;
    public static final int AMOUNT = 14;
    public static final int EXTDATA = 15;

    protected String payerbanknum;
    protected String payerbankname;
    protected String billerbanknum;
    protected String billerbankname;
    protected String accounttype;
    protected String billercode;
    protected String billercodename;
    protected String nbpsref;
    protected String channel;
    protected String debittimestamp;
    protected String repeatmsg;
    protected String rrn;
    protected String rrn2;
    protected String currencycode;
    protected String amount;
    protected String extdata;

    public BNSNotification(){}

    public String getPayerbanknum() {
        return ( payerbanknum != null )? payerbanknum : "" ;
    }

    public void setPayerbanknum(String payerbanknum) {
        this.payerbanknum = payerbanknum;
    }

    public String getPayerbankname() {
        return ( payerbankname != null )? payerbankname : "";
    }

    public void setPayerbankname(String payerbankname) {
        this.payerbankname = payerbankname;
    }

    public String getBillerbanknum() {
        return ( billerbanknum != null )? billerbanknum : "";
    }

    public void setBillerbanknum(String billerbanknum) {
        this.billerbanknum = billerbanknum;
    }

    public String getBillerbankname() {
        return ( billerbankname != null )? billerbankname : "";
    }

    public void setBillerbankname(String billerbankname) {
        this.billerbankname = billerbankname;
    }

    public String getAccounttype() {
        return ( accounttype != null )? accounttype : "";
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getBillercode() {
        return ( billercode != null )? billercode : "";
    }

    public void setBillercode(String billercode) {
        this.billercode = billercode;
    }

    public String getBillercodename() {
        return ( billercodename != null )? billercodename : "";
    }

    public void setBillercodename(String billercodename) {
        this.billercodename = billercodename;
    }

    public String getNbpsref() {
        return ( nbpsref != null )? nbpsref : "";
    }

    public void setNbpsref(String nbpsref) {
        this.nbpsref = nbpsref;
    }

    public String getChannel() {
        return ( channel != null )? channel : "";
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDebittimestamp() {
        return ( debittimestamp != null )? debittimestamp : "";
    }

    public void setDebittimestamp(String debittimestamp) {
        this.debittimestamp = debittimestamp;
    }

    public String getRepeatmsg() {
        return ( repeatmsg != null )? repeatmsg : "";
    }

    public void setRepeatmsg(String repeatmsg) {
        this.repeatmsg = repeatmsg;
    }

    public String getRrn() {
        return ( rrn != null )? rrn : "";
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getRrn2() {
        return ( rrn2 != null )? rrn2 : "";
    }

    public void setRrn2(String rrn2) {
        this.rrn2 = rrn2;
    }

    public String getCurrencycode() {
        return ( currencycode != null )? currencycode : "";
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getAmount() {
        return ( amount != null )? amount : "";
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExtdata() {
        return ( extdata != null )? extdata : "";
    }

    public void setExtdata(String extdata) {
        this.extdata = extdata;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append( getPayerbanknum() );
        strBuilder.append( "|" );
        strBuilder.append( getPayerbankname() );
        strBuilder.append( "|" );
        strBuilder.append( getBillerbanknum());
        strBuilder.append( "|" );
        strBuilder.append( getBillerbankname() );
        strBuilder.append( "|" );
        strBuilder.append( getAccounttype() );
        strBuilder.append( "|" );
        strBuilder.append( getBillercode() );
        strBuilder.append( "|" );
        strBuilder.append( getBillercodename() );
        strBuilder.append( "|" );
        strBuilder.append( getNbpsref() );
        strBuilder.append( "|" );
        strBuilder.append( getChannel() );
        strBuilder.append( "|" );
        strBuilder.append( getDebittimestamp() );
        strBuilder.append( "|" );
        strBuilder.append( getRepeatmsg() );
        strBuilder.append( "|" );
        strBuilder.append( getRrn() );
        strBuilder.append( "|" );
        strBuilder.append( getRrn2() );
        strBuilder.append( "|" );
        strBuilder.append( getCurrencycode() );
        strBuilder.append( "|" );
        strBuilder.append( getAmount() );
        strBuilder.append( "|" );
        strBuilder.append( getExtdata() );
        strBuilder.append( "|" );
        return strBuilder.toString();
    }

    public static BNSNotification parseNotification( String str ){
        return parseNotification( str, "|" );
    }

    public static BNSNotification parseNotification( String str, String delimiter ){
        delimiter = ( delimiter != null && !"".equalsIgnoreCase( delimiter.trim() ) )? delimiter : "|";

        BNSNotification result = null;
        if( str != null && !"".equalsIgnoreCase( str.trim() ) ){
            result = new BNSNotification();
            String[] tokens = str.split( delimiter );
            for( int i = 0; i < tokens.length; i++ ){
                String token = tokens[i];
                switch( i ){
                    case PAYERBANKNUM:
                        result.setPayerbanknum( token );
                        break;
                    case PAYERBANKNAME:
                        result.setPayerbankname( token );
                        break;
                    case BILLERBANKNUM:
                        result.setBillerbanknum( token );
                        break;
                    case BILLERBANKNAME:
                        result.setBillerbankname( token );
                        break;
                    case ACCOUNTTYPE:
                        result.setAccounttype( token );
                        break;
                    case BILLERCODE:
                        result.setBillercode( token );
                        break;
                    case BILLERCODENAME:
                        result.setBillercodename( token );
                        break;
                    case NBSPREF:
                        result.setNbpsref( token );
                        break;
                    case CHANNEL:
                        result.setChannel( token );
                        break;
                    case DEBITTIMESTAMP:
                        result.setDebittimestamp( token );
                        break;
                    case REPEATMSG:
                        result.setRepeatmsg( token );
                        break;
                    case RRN:
                        result.setRrn( token );
                        break;
                    case RRN2:
                        result.setRrn2( token );
                        break;
                    case CURRENCYCODE:
                        result.setCurrencycode( token );
                        break;
                    case EXTDATA:
                        result.setExtdata( token );
                        break;
                }
            }
        }
        return result;
    }
}