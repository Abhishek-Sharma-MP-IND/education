---
# Educational Event Management and Resource Allocation Platform

## Overview

A dedicated system designed to manage and coordinate educational events like workshops, seminars, school fairs, and conferences, facilitating the planning process, resource allocation, and interaction between educational institutions, educators, and students to ensure successful event execution.

## Users of the System

- **Educational Institutions**: Plan and schedule educational events, manage resources, and communicate with participants.
- **Educators**: Oversee event agendas, access educational materials, and interact with students.
- **Students**: Register for events, submit requirements for educational activities, and receive updates.

## Functional Requirements

- **User Registration & Profile Management**: Users create accounts, log in, and manage profiles with robust data validation and secure handling of sensitive information.
- **Event Scheduling & Management**: Institutions set up and manage the logistics of educational events, with secured permissions for any modifications.
- **Resource Allocation to Educational Activities**: Allocate teaching aids, classroom spaces, and educational materials to specific events or sessions.
- **Educator and Student Interaction Interface**: A portal where students can track their event schedules and educators can receive and provide feedback.
- **User Role-Based Authentication**: System assigns user roles to offer tailored interfaces and functionalities for institutions, educators, and students.
- **JWT Authorization**: Secure user sessions and API interactions with JWT tokens.
- **RESTful API & Angular Service Layer**: Ensures smooth communication between the Angular frontend and backend RESTful services for responsive data exchange and interface updates.
- Angular: Use Reactive form and declare form with name itemForm and add validation.
-Angular: Create a service with name AuthService and create these functions saveToken,SetRole,getRole,getLoginStatus,getToken,logout.
-Angular create a http Service with name HttpService and create functions getBookingDetails,registerForEvent,getAllEventAgenda,GetAllevents,GetAllResources,createEvent,updateEvent,addResource,allocateResources,Login,registerUser


## Technology Stack

- **Backend**: Spring Boot, JPA, MySQL
- **Frontend**: Angular
- **Security**: Spring Security, JWT

## Key Points to Note

- **Security**: Protect sensitive educational data and ensure API access is secure.
- **Scalability**: The system should easily adapt to a growing number of users and larger-scale educational events.
- **User Interface Consistency**: Maintain a uniform and intuitive interface across all user types.
- **Best Practices**: Follow industry coding best practices for sustainable software development.

## Backend Functionalities to be Built

- **User Management**: Develop secure endpoints for user registration, login, and profile management.
- **Event Management**: Implement CRUD operations for event details, ensuring data integrity and proper authorization.
- **Resource Management**: Efficient tracking and allocation of educational resources to events.
- **Role-Based Authentication**: Establish access levels for institutions, educators, and students.
- **JWT Token Management**: Robust handling of token generation, validation, and lifecycle management.

## Backend Test Cases

- **User Registration**: Ensure the user registration process is secure and efficient.
- **Event Creation**: Validate that event details are properly created and stored.
- **Resource Allocation**: Check the accurate allocation and management of educational resources.
- **Login Authentication**: Confirm the reliability of the authentication process.

## Entity classes and their properties
1. User
   - Long id (Primary Key and Auto-generated)
   - String username
   - String password
   - String email
   - String role // role can be either 'INSTITUTION', 'EDUCATOR', or 'STUDENT'

2. Event
   - Long id (Primary Key and Auto-generated)
   - String name
   - String description
   - String materials
   - List<Resource> resourceAllocations;

3. Resource
    - Long id (Primary Key and Auto-generated)
    - String resourceType
    - String description
    - Event event

4. EventRegistration
    - Long id (Primary Key and Auto-generated)
    - String status
    - Long studentId
    - Event event

-> Manage the relationships between entities using appropriate annotations.
-> generate constructors, getters, and setters for the Property class as per standard Java conventions.
-> For example: getId(), setId(Long id) etc.

## API Endpoints

## For Registration and login User
- **Register User**: POST `/api/user/register`
- **Login User**: POST `/api/user/login`


### For Educational Institutions (Admin Side):

- **Create Event**: POST `/api/institution/event`
- **View Events**: GET `/api/institution/events`
- **Create Resource**: POST `/api/institution/resource`
- **View Resources**: GET `/api/institution/resources`
- **Allocate Resources**: POST `/api/institution/event/allocate-resources`

### For Educators and Students (User Side):
- **View Events Agenda**: GET `/api/educator/agenda`
- **Update Event Material**: PUT `/api/educator/update-material`
- **Register for an event**: POST `/api/student/register/{eventId}`
- **View Registration Status**: GET `/api/student/registration-status/{studentId}`

## Security Configurations to be Implemented
Set the following security configurations in the `SecurityConfig.java` file:
- /api/user/register: accessible to everyone
- /api/user/login: accessible to everyone
- /api/institution/event: accessible to INSTITUTION authority
- /api/institution/events: accessible to INSTITUTION authority
- /api/institution/resource: accessible to INSTITUTION authority
- /api/institution/resources: accessible to INSTITUTION authority
- /api/institution/event/allocate-resources: accessible to INSTITUTION authority
- /api/educator/agenda: accessible to EDUCATOR authority
- /api/educator/update-material/{eventId}: accessible to EDUCATOR authority
- /api/student/register/{eventId}: accessible to STUDENT authority
- /api/student/registration-status/{studentId}: accessible to STUDENT authority
- any other route: accessible to authenticated users

Check the permissions with respect to authority such as hasAuthority("INSTITUTION") or hasAuthority("EDUCATOR") or hasAuthority("STUDENT").
If a user tries to access a route without the required authority, return a 403 Forbidden status.

## You need to complete the following backend files:

- `./src/main/java/com/wecp/educationalresourcedistributionsystem/config/SecurityConfig.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/controller/EducatorController.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/controller/InstitutionController.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/controller/RegisterAndLoginController.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/controller/StudentController.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/entity/Event.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/entity/EventRegistration.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/entity/Resource.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/entity/User.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/jwt/JwtRequestFilter.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/jwt/JwtUtil.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/repository/EventRegistrationRepository.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/repository/EventRepository.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/repository/ResourceRepository.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/repository/UserRepository.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/service/EventService.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/service/RegistrationService.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/service/ResourceService.java`
- `./src/main/java/com/wecp/educationalresourcedistributionsystem/service/UserService.java`

## Frontend Functionalities to be Built

- **Registration and Profile Management**: Seamless registration and management of user profiles.
- **Event Management Dashboard**: Tools for institutions to schedule and oversee educational events.
- **Resource Allocation Interface**: System for institutions to assign resources to specific events or educators.
- **Educator and Student Communication Portal**: Interface for direct communication and updates.
- **Role-Specific UI Elements**: Customized UI based on user roles for a personalized experience.

## You need to complete the following frontend files:

- `./src/app/add-resource/add-resource.component.ts`
- `./src/app/add-resource/add-resource.component.html`
- `./src/app/booking-details/booking-details.component.ts`
- `./src/app/booking-details/booking-details.component.html`
- `./src/app/create-event/create-event.component.ts`
- `./src/app/create-event/create-event.component.html`
- `./src/app/resource-allocate/resource-allocate.component.ts`
- `./src/app/resource-allocate/resource-allocate.component.html`
- `./src/app/view-events/view-events.component.ts`
- `./src/app/view-events/view-events.component.html`
- `./src/app/login/login.component.ts`
- `./src/app/login/login.component.html`
- `./src/services/http.service.ts`
- `./src/services/auth.service.ts`
- `./src/app/app.component.html`
- `./src/app/registration/registration.component.ts`
- `./src/app/registration/registration.component.html`
- `./src/app/register-for-event/register-for-event.component.html`
- `./src/app/register-for-event/register-for-event.component.html`