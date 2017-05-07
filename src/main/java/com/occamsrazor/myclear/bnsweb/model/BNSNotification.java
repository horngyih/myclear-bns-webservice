package com.occamsrazor.myclear.bnsweb.model;

public class BNSNotification{
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
}