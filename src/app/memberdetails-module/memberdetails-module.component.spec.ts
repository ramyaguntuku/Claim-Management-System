import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { MemberService } from '../member.service';
import { FormsModule } from '@angular/forms';
import { MemberdetailsModuleComponent } from './memberdetails-module.component';

describe('MemberdetailsModuleComponent', () => {
  let component: MemberdetailsModuleComponent;
  let fixture: ComponentFixture<MemberdetailsModuleComponent>;

  beforeEach(() => {
    const routerStub = () => ({ navigate: (_array: any, object: any) => ({}) });
    const memberServiceStub = () => ({
      memberForm: (_member: any) => ({ subscribe: (f: (arg0: {}) => any) => f({}) })
    });
    TestBed.configureTestingModule({
      imports: [FormsModule],
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [MemberdetailsModuleComponent],
      providers: [
        { provide: Router, useFactory: routerStub },
        { provide: MemberService, useFactory: memberServiceStub }
      ]
    });
    fixture = TestBed.createComponent(MemberdetailsModuleComponent);
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

  describe('memberl', () => {
    it('makes expected calls', () => {
      const routerStub: Router = fixture.debugElement.injector.get(Router);
      const memberServiceStub: MemberService = fixture.debugElement.injector.get(
        MemberService
      );
      spyOn(routerStub, 'navigate').and.callThrough();
      spyOn(memberServiceStub, 'memberForm').and.callThrough();
      component.memberl();
      expect(routerStub.navigate).toHaveBeenCalled();
      expect(memberServiceStub.memberForm).toHaveBeenCalled();
    });
  });
});
