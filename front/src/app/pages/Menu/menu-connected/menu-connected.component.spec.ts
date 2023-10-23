import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuConnectedComponent } from './menu-connected.component';

describe('MenuConnectedComponent', () => {
  let component: MenuConnectedComponent;
  let fixture: ComponentFixture<MenuConnectedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuConnectedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenuConnectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
