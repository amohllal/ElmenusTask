# Food Discovery App

An Android application that allows users to explore meals, browse top food categories, and view detailed information about individual meals, including ingredients and preparation instructions.

The application integrates a remote API and local persistence to provide a simple offline fallback when network requests fail.

---

# Architecture

The project follows **Clean Architecture with MVVM** and is organized into three modules:

### app (Presentation Layer)
Responsible for UI and user interaction.

Contains:
- Fragments
- ViewModels
- RecyclerView adapters
- Navigation Component
- ViewBinding

The presentation layer communicates with the domain layer through **UseCases**.

---

### domain (Business Logic Layer)

This module contains the core business logic.

Includes:
- Domain models
- Repository interfaces
- Use cases

Example use cases:
- `GetHomeUseCase`
- `GetTopCategoryUseCase`
- `GetMealDetailsUseCase`

---

### data (Data Layer)

Responsible for providing data to the application.

Includes:
- Retrofit API services
- Room database
- Repository implementations
- Remote and Local data sources
- Data mappers (DTO → Domain → Entity)

The repositories combine remote and local sources to provide a simple **offline-first fallback strategy**.

---

# Tech Stack

- Kotlin
- Coroutines & Flow
- Hilt (Dependency Injection)
- Retrofit & OkHttp
- Room Database
- Navigation Component
- Glide
- ViewBinding
- Gson

---

# Key Design Decisions

• **Clean Architecture** was used to enforce separation of concerns and improve testability.

• **Multi-module structure** was introduced to isolate domain logic from Android framework dependencies and improve scalability.

• **Repository pattern** was used to abstract data sources and keep ViewModels independent from data implementation.

• **Offline fallback strategy** was implemented by combining remote API responses with cached data stored in Room.

• **UseCase layer** was added to encapsulate business logic and keep ViewModels lightweight.

---

# Testing

Unit tests are included for the domain use cases using **JUnit and Mockito** to demonstrate how the architecture supports isolated testing.

---

# Screenshots

<img width="209" alt="screen3" src="https://github.com/amohllal/ElmenusTask/assets/40995581/97488a9b-818b-4f6e-9f81-79e2e4302de1.jpg">

<img width="208" alt="screen1" src="https://github.com/amohllal/ElmenusTask/assets/40995581/3f0a99a4-e965-4565-8670-676a2b44372b.jpg">

<img width="208" alt="screen2" src="https://github.com/amohllal/ElmenusTask/assets/40995581/9c36cbe4-58d1-4dbd-8c05-b0da2e78bb07.jpg">

---

# Running the project

Clone the repository: git clone https://github.com/amohllal/ElmenusTask.git
Open the project in **Android Studio** and run it on a connected device or emulator.

---

# Note

The API used in this project was originally provided as part of the Elmenus technical task and may no longer be publicly accessible.  
If the endpoint returns `404`, the architecture and data flow remain intact and demonstrate the intended implementation.
