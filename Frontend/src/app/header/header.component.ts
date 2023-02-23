import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ResolveEnd, Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  color='rgba(255, 255, 255, 0.55)';
  constructor(private router:Router) {
  }
  ngOnInit(): void {
    this.router.events.subscribe((routerData) => {
      if(routerData instanceof ResolveEnd){ 
         if(routerData.url.includes('all-events')|| routerData.url.includes('upcoming-events')||routerData.url.includes('current-events')){
           this.color='white';
         }
    } 
})
    
  }
  // onSearchChange() {
  //   this.searchText.emit(this.enteredSearch);
  // }
  // logout() {
  //   this.auth.logout();
  // }
}
