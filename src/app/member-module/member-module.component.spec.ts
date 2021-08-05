import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { MemberService } from '../member.service';
import { MemberModuleComponent } from './member-module.component';

describe('MemberModuleComponent', () => {
  let component: MemberModuleComponent;
  let fixture: ComponentFixture<MemberModuleComponent>;

  beforeEach(() => {
    const activatedRouteStub = () => ({
      queryParams: { subscribe: (f: (arg0: {}) => any) => f({}) }
    });
    const routerStub = () => ({});
    const memberServiceStub = () => ({});
    TestBed.configureTestingModule({
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [MemberModuleComponent],
      providers: [
        { provide: ActivatedRoute, useFactory: activatedRouteStub },
        { provide: Router, useFactory: routerStub },
        { provide: MemberService, useFactory: memberServiceStub }
      ]
    });
    fixture = TestBed.createComponent(MemberModuleComponent);
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
  });
});
