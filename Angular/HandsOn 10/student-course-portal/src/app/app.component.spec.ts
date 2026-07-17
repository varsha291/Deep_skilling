import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { AppComponent } from './app.component';
import { Course } from './models/course';

describe('AppComponent', () => {
  let store: MockStore;
  const mockCourses: Course[] = [
    {
      id: 1,
      title: 'Data Structures',
      instructor: 'Dr. Rao',
      duration: '8 weeks',
      category: 'Computer Science',
      credits: 4,
      progress: 100
    },
    {
      id: 2,
      title: 'Angular Fundamentals',
      instructor: 'Ms. Kumar',
      duration: '6 weeks',
      category: 'Web Development',
      credits: 3,
      progress: 50
    }
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting(),
        provideMockStore({
          initialState: {
            courses: {
              items: mockCourses,
              selectedCourseId: null,
              loading: false,
              error: null
            }
          }
        })
      ]
    }).compileComponents();

    store = TestBed.inject(MockStore);
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have the 'student-course-portal' title`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('student-course-portal');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);

    fixture.detectChanges();

    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Student Course Portal');
  });

  it('should render course cards from the initial store state', () => {
    const fixture = TestBed.createComponent(AppComponent);

    fixture.detectChanges();

    const compiled = fixture.nativeElement as HTMLElement;
    const courseCards = compiled.querySelectorAll('.course-card');

    expect(store).toBeTruthy();
    expect(courseCards.length).toBe(2);
    expect(courseCards[0].textContent).toContain('Data Structures');
    expect(courseCards[1].textContent).toContain('Angular Fundamentals');
  });

  it('should show loading indicator when store loading state is true', () => {
    const fixture = TestBed.createComponent(AppComponent);

    store.setState({
      courses: {
        items: [],
        selectedCourseId: null,
        loading: true,
        error: null
      }
    });
    fixture.detectChanges();

    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.loading-indicator')?.textContent).toContain('Loading courses...');
  });
});
