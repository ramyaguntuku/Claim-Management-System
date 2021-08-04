import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { SubmitService } from '../submit.service';
import { FormsModule } from '@angular/forms';
import { SubmitInputComponent } from './submit-input.component';

describe('SubmitInputComponent', () => {
  let component: SubmitInputComponent;
  let fixture: ComponentFixture<SubmitInputComponent>;

  beforeEach(() => {
    const routerStub = () => ({ navigate: (_array: any, object: any) => ({}) });
    const submitServiceStub = () => ({
      submitClaim: (_submit: any) => ({ subscribe: (f: (arg0: {}) => any) => f({}) })
    });
    TestBed.configureTestingModule({
      imports: [FormsModule],
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [SubmitInputComponent],
      providers: [
        { provide: Router, useFactory: routerStub },
        { provide: SubmitService, useFactory: submitServiceStub }
      ]
    });
    fixture = TestBed.createComponent(SubmitInputComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });

  it('ngOnInit function', ()=> {
    spyOn(sessionStorage,'getItem').and.callFake((key : 'varchasva')=> {return 'varchasva'});
    component.ngOnInit();
    expect(sessionStorage.getItem).toHaveBeenCalledWith("key");
    expect(component.key1).toEqual('varchasva');
  });

  it('logout function', () => {
    spyOn(sessionStorage,'removeItem').and.callThrough();
    component.logout();
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('key');
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('token');
  });

  describe('submitForm', () => {
    it('makes expected calls', () => {
      const routerStub: Router = fixture.debugElement.injector.get(Router);
      const submitServiceStub: SubmitService = fixture.debugElement.injector.get(
        SubmitService
      );
      spyOn(routerStub, 'navigate').and.callThrough();
      spyOn(submitServiceStub, 'submitClaim').and.callThrough();
      component.submitForm();
      expect(routerStub.navigate).toHaveBeenCalled();
      expect(submitServiceStub.submitClaim).toHaveBeenCalled();
    });
  });
});
