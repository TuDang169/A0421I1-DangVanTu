import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BusRoutingModule} from './bus-routing.module';
import {InfoComponent} from './info/info.component';
import {ListComponent} from './list/list.component';
import {CreateComponent} from './create/create.component';
import {BusComponent} from './bus.component';
import {DeleteComponent} from './delete/delete.component';
import {ReactiveFormsModule} from '@angular/forms';
import { UpdateComponent } from './update/update.component';


@NgModule({
  declarations: [
    InfoComponent,
    ListComponent,
    CreateComponent,
    DeleteComponent,
    BusComponent,
    UpdateComponent,
  ],
    imports: [
        CommonModule,
        BusRoutingModule,
        ReactiveFormsModule,

    ],
  providers: []
})
export class BusModule { }
