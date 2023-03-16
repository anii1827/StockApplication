

// companyCEO: "RATAN"
// companyCode: "TCS"
// companyName: "TCS"
// companyWebsite: "www.TCS.com"
// price: 150
// turnOver: "2000000000"

export class company{
    companyCode!:String;
    companyName!:String;
    companyCeo!:String;
    turnOver!:String;
    companyWebsite!:String;     
}

export class stock extends company{
    price!:number;
}

export interface stockDetails{
    price:number;
    company:String;
    description:String;
}


export interface stockCompanyStats{
     max:number;
	 min:number;
	 average:number;
     stocks:stockStats[]
}
export interface stockStats{
    price:number;
    startTime:Date;
    endTime:Date;
    companyCode:String;
}