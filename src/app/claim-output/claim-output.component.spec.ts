import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { ClaimService } from '../claim.service';
import { ClaimOutputComponent } from './claim-output.component';
// import { setUncaughtExceptionCaptureCallback } from 'process';

describe('ClaimOutputComponent', () => {
  let component: ClaimOutputComponent;
  let fixture: ComponentFixture<ClaimOutputComponent>;

  beforeEach(() => {
    const activatedRouteStub = () => ({
      queryParams: { subscribe: (f: (arg0: {}) => any) => f({}) }
    });
    const routerStub = () => ({});
    const claimServiceStub = () => ({});
    TestBed.configureTestingModule({
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [ClaimOutputComponent],
      providers: [
        { provide: ActivatedRoute, useFactory: activatedRouteStub },
        { provide: Router, useFactory: routerStub },
        { provide: ClaimService, useFactory: claimServiceStub }
      ]
    });
    fixture = TestBed.createComponent(ClaimOutputComponent);
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
  })

  it('logout function', () => {
    spyOn(sessionStorage,'removeItem').and.callThrough();
    component.logout();
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('key');
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('token');
  })
});
