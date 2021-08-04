import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { SubmitService } from '../submit.service';
import { SubmitOutputComponent } from './submit-output.component';

describe('SubmitOutputComponent', () => {
  let component: SubmitOutputComponent;
  let fixture: ComponentFixture<SubmitOutputComponent>;

  beforeEach(() => {
    const activatedRouteStub = () => ({
      queryParams: { subscribe: (f: (arg0: {}) => any) => f({}) }
    });
    const routerStub = () => ({});
    const submitServiceStub = () => ({});
    TestBed.configureTestingModule({
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [SubmitOutputComponent],
      providers: [
        { provide: ActivatedRoute, useFactory: activatedRouteStub },
        { provide: Router, useFactory: routerStub },
        { provide: SubmitService, useFactory: submitServiceStub }
      ]
    });
    fixture = TestBed.createComponent(SubmitOutputComponent);
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
});
