module.exports = {
    payerbanknum : { type: "string", length: 10, required: true },
    payerbankname : { type: "string", length: 20, required: true },
    billerbanknum : { type: "string", length: 10, required: true },
    billerbankname : { type: "string", length: 20, required : true },
    accounttype : { type: "string", length: 5, required: true },
    billercode : { type: "string", length: 10, required: true },
    billercodename : { type: "string", length: 50, required: true },
    nbpsref : { type: "string", length: 20, required: true },
    channel : { type: "string", length: 5, required: true },
    debittimestamp : { type: "string", length:50, required: true },
    repeatemsg: {type: "string", length: 1, required: true},
    rrn: {type: "string", length: 50, required: true },
    rrn2: {type: "string", length: 50, required: false },
    currenycode: {type: "string", length: 3, required: true },
    amount: {type: "number", length: null, required: true },
    extdata: {type: "string", length: 250, required: false }
};