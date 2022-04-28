import { Component, OnInit } from '@angular/core';
import { Project } from '../../project';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {

  // Properties for holding information in state
  project = new Project('', 'kitchen', null, null, null);
  id: number;

  // Data for displaying radio buttons with *ngFor
  rooms: string[] = ["kitchen", "bath", "living"];
  roomTitles: string[] = ["Kitchen", "Bathroom", "Bedroom/Living/Other"];

  constructor() {}

  ngOnInit() {}

  // Event handlers for input fields
  updateName(name: HTMLInputElement) {
    this.project.name = name.value;
  }
  updateRoomType(roomType: HTMLInputElement) {
    console.log("roomType is " + roomType.value);
    this.project.roomType = roomType.value
  }
  updateRoomLength(roomLength: HTMLInputElement) {
    this.project.roomLength = Number(roomLength.value);
  }
  updateRoomWidth(roomWidth: HTMLInputElement) {
    this.project.roomWidth = Number(roomWidth.value);
  }
  updateRoomHeight(roomHeight: HTMLInputElement) {
    this.project.roomHeight = Number(roomHeight.value);
  }

  // Event handler for form submission
  async saveProject() {
    console.log("Saving project...", this.project);

    let response = await fetch('http://localhost:8080/api/project', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'localhost:4200', // Deal with CORS policy issues
      },
      body: JSON.stringify(this.project),
    });
    
    let payload = await response.json(); // example: { id: 32 }

    console.log("Response received with payload:", payload); 

    // The id can be used for saving the project in a token service
    // or for routing to a details page with '/:id' URI parameter, etc.
    this.id = Number(payload.id); 

  }

}
