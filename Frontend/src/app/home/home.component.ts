import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Event } from '../models/event.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { 
  }
  noEventsImage='https://www.caritasmalta.org/wp-content/uploads/2020/06/NO-UPCOMING-events.png';
  events : Event[] =[{
    name: 'Event 1',
    location: 'Hyderabad',
    date: {startDate:new Date('2023-02-27'),endDate:new Date('2023-02-28')},
    registration: {startDate:new Date('2023-02-20'),endDate:new Date()},
    category: 'Outdoor',
    registered: false,
    image:'https://novamba.org/resources/Pictures/NVMBA%20June%20Event%20-%20register%202021.jpg'
  },
  {
  name: 'Event 2',
  location: 'Hyderabad',
  date: {startDate:new Date('2023-02-27'),endDate:new Date('2023-02-28')},
  registration: {startDate:new Date('2023-02-20'),endDate:new Date('2023-02-24')},
  category: 'Outdoor',
  registered: false,
  image:'https://novamba.org/resources/Pictures/NVMBA%20June%20Event%20-%20register%202021.jpg'
  },
  {
  name: 'Event 3',
  location: 'Hyderabad',
  date: {startDate:new Date('2023-02-27'),endDate:new Date('2023-02-28')},
  registration: {startDate:new Date('2023-02-23'),endDate:new Date('2023-02-25')},
  category: 'Outdoor',
  registered: false,
  image:'https://novamba.org/resources/Pictures/NVMBA%20June%20Event%20-%20register%202021.jpg'
  },
  {
  name: 'Event 4',
  location: 'Hyderabad',
  date: {startDate:new Date('2023-02-27'),endDate:new Date('2023-02-28')},
  registration: {startDate:new Date('2023-02-24'),endDate:new Date('2023-02-25')},
  category: 'Outdoor',
  registered: false,
  image:'https://d1csarkz8obe9u.cloudfront.net/posterpreviews/summer-template-design-fa1701f5fc6db8321c9711044c89ace3_screen.jpg?ts=1649820032'
  },
  {
  name: 'Event 5',
  location: 'Hyderabad',
  date: {startDate:new Date('2023-02-27'),endDate:new Date('2023-02-28')},
  registration: {startDate:new Date('2023-02-24'),endDate:new Date('2023-02-25')},
  category: 'Outdoor',
  registered: false,
  image:'https://novamba.org/resources/Pictures/NVMBA%20June%20Event%20-%20register%202021.jpg'
  },
]
currentEvents : Event[]=[];
upcomingEvents : Event[]=[];
  ngOnInit(): void {
    for(let i=0;i<this.events.length;i++){
      if(this.events[i].registration.endDate.getFullYear()==new Date().getFullYear() && 
      this.events[i].registration.startDate.getDate()<=new Date()?.getDate())
      {
        this.currentEvents.push(this.events[i]);
      }
    }
    for(let i=0;i<this.events.length;i++){
      if(this.events[i].registration.endDate.getFullYear()==new Date().getFullYear() && 
      this.events[i].registration.startDate.getDate()>new Date()?.getDate())
      {
        this.upcomingEvents.push(this.events[i]);
      }
    }
  }

  ngAfterViewInit(){
    
  }


}
