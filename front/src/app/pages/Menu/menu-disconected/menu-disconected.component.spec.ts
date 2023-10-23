import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuDisconectedComponent } from './menu-disconected.component';

describe('MenuDisconectedComponent', () => {
  let component: MenuDisconectedComponent;
  let fixture: ComponentFixture<MenuDisconectedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuDisconectedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenuDisconectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
