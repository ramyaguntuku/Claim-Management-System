import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule , routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ContactModuleComponent } from './contact-module/contact-module.component';
import { MemberdetailsModuleComponent } from './memberdetails-module/memberdetails-module.component';
import { MemberdetailsOutputComponent } from './memberdetails-output/memberdetails-output.component';
import { ClaimInputComponent } from './claim-input/claim-input.component';
import { ClaimOutputComponent } from './claim-output/claim-output.component';
import { SubmitInputComponent } from './submit-input/submit-input.component';
import { SubmitOutputComponent } from './submit-output/submit-output.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    ContactModuleComponent,
    MemberdetailsModuleComponent,
    MemberdetailsOutputComponent,
    ClaimInputComponent,
    ClaimOutputComponent,
    SubmitInputComponent,
    SubmitOutputComponent,
   
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
