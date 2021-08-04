import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { FormsModule } from '@angular/forms';
import { LoginModuleComponent } from './login-module.component';

describe('LoginModuleComponent', () => {
  let component: LoginModuleComponent;
  let fixture: ComponentFixture<LoginModuleComponent>;

  beforeEach(() => {
    const routerStub = () => ({ navigate: (_array: any, object: any) => ({}) });
    const registrationServiceStub = () => ({
      loginUserFormRemote: (_user: any) => ({ subscribe: (f: (arg0: {}) => any) => f({}) })
    });
    TestBed.configureTestingModule({
      imports: [FormsModule],
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [LoginModuleComponent],
      providers: [
        { provide: Router, useFactory: routerStub },
        { provide: RegistrationService, useFactory: registrationServiceStub }
      ]
    });
    fixture = TestBed.createComponent(LoginModuleComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });

  describe('loginUser', () => {
    it('makes expected calls', () => {
      const routerStub: Router = fixture.debugElement.injector.get(Router);
      const registrationServiceStub: RegistrationService = fixture.debugElement.injector.get(
        RegistrationService
      );
      spyOn(routerStub, 'navigate').and.callThrough();
      spyOn(registrationServiceStub, 'loginUserFormRemote').and.callThrough();
      component.loginUser();
      expect(routerStub.navigate).toHaveBeenCalled();
      expect(registrationServiceStub.loginUserFormRemote).toHaveBeenCalled();
    });
  });
});
