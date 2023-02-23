export interface Event {
    name:String;
    location: String;
    date:{startDate:Date, endDate: Date,};
    registration: {startDate:Date, endDate: Date,};
    category:String;
    registered:boolean;
    image:string
}
