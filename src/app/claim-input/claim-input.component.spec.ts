import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimService } from '../claim.service';
import { FormsModule } from '@angular/forms';
import { ClaimInputComponent } from './claim-input.component';

describe('ClaimInputComponent', () => {
  let component: ClaimInputComponent;
  let fixture: ComponentFixture<ClaimInputComponent>;

  beforeEach(() => {
    const routerStub = () => ({ navigate: (_array: any, object: any) => ({}) });
    const claimServiceStub = () => ({
      claimStatus: (_claim: any) => ({ subscribe: (f: (arg0: {}) => any) => f({}) })
    });
    TestBed.configureTestingModule({
      imports: [FormsModule],
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [ClaimInputComponent],
      providers: [
        { provide: Router, useFactory: routerStub },
        { provide: ClaimService, useFactory: claimServiceStub }
      ]
    });
    fixture = TestBed.createComponent(ClaimInputComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });
  
  it('ngOnInit function', ()=> {
    sessionStorage.setItem('key','varchasva');
    spyOn(sessionStorage,'getItem').and.callThrough();
    component.ngOnInit();
    expect(sessionStorage.getItem).toHaveBeenCalledWith("key");
    expect(component.key1).toEqual('varchasva');
  })

  it('logout function', () => {
    spyOn(sessionStorage,'removeItem').and.callThrough();
    component.logout();
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('key');
    expect(sessionStorage.removeItem).toHaveBeenCalledWith('token');
  });

  describe('claims', () => {
    it('makes expected calls', () => {
      const routerStub: Router = fixture.debugElement.injector.get(Router);
      const claimServiceStub: ClaimService = fixture.debugElement.injector.get(
        ClaimService
      );
      spyOn(routerStub, 'navigate').and.callThrough();
      spyOn(claimServiceStub, 'claimStatus').and.callThrough();
      component.claims();
      expect(routerStub.navigate).toHaveBeenCalled();
      expect(claimServiceStub.claimStatus).toHaveBeenCalled();
    });
  });
});
