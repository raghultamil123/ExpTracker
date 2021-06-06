import { Component } from '@angular/core';
import * as Highcharts from 'highcharts';
export interface PeriodicElement {
  name: string;
  position: number;
  price: number;
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'expenses';

 
}
