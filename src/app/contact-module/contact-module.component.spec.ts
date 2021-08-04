import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ContactModuleComponent } from './contact-module.component';

describe('ContactModuleComponent', () => {
  let component: ContactModuleComponent;
  let fixture: ComponentFixture<ContactModuleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [ContactModuleComponent]
    });
    fixture = TestBed.createComponent(ContactModuleComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });
  it('ngOnInit function', ()=> {
    component.ngOnInit();
  });
  it('logout function', () => {
    spyOn(sessionStorage,'removeItem').and.callThrough();
    component.logout();
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('key');
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('token');
  });
});
