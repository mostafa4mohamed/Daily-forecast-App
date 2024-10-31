# Daily Forecast App

The **Daily Forecast App** provides users with real-time weather updates, including daily and weekly forecasts. The app leverages a modern architecture to ensure a smooth user experience with offline capabilities, using OpenWeatherMap APIs. For API documentation, visit: [OpenWeatherMap API Docs](https://openweathermap.org/forecast5).
## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Architecture](#architecture)
- [Technologies](#technologies)

## Features

- **Forecast**: Provides daily and daily forecasts depending on selected city.
- **Offline Mode**: Caches data for offline access.
- **User-Friendly UI**: Intuitive and responsive design.

## Screenshots

- [init view Screenshot](https://github.com/mostafa4mohamed/Daily-forecast-App/blob/master/screenshots/init%20view.jpg)
- [select your city Screenshot](https://github.com/mostafa4mohamed/Daily-forecast-App/blob/master/screenshots/select%20your%20city.jpg)
- [online mode Screenshot](https://github.com/mostafa4mohamed/Daily-forecast-App/blob/master/screenshots/online%20mode.jpg)
- [offline mode Screenshot](https://github.com/mostafa4mohamed/Daily-forecast-App/blob/master/screenshots/offlin%20mode.jpg)

## Installation

Clone the repository:
   git clone https://github.com/mostafa4mohamed/Daily-forecast-App.git

## Architecture

This repository applies Clean Architecture using the Onion Architecture pattern with an MVVM (Model-View-ViewModel) architecture. 
The project is modularized into three modules: app, data, and domain.

## Technologies

- Kotlin: Programming language used.
- Room: Used for caching data in offline mode.
- Coroutines: Used to handle asynchronous tasks.
- Hilt: Implemented for dependency injection.
- Retrofit: Used to fetch data from the server.
- JUnit 4: to implement Unit tests.
