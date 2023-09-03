## Carousel layout project with MVVM structure

<img width="439" alt="Screenshot 2023-02-23 at 12 56 13 PM" src="https://user-images.githubusercontent.com/20376971/220790897-0f7c1ecf-5d6b-44a1-9d9f-8c1c1b06f4bb.png">

### Introduction

Welcome to the Carousel Layout project readme! This document provides an overview of the project, instructions on how to get started, and guidelines for contributing to the project.

### Project Overview

The Carousel Layout project is a modern Android application developed using the MVVM (Model-View-ViewModel) architectural pattern. This project is designed to create a dynamic and user-friendly carousel layout for displaying a collection of images or content in a horizontal scrollable format. The MVVM architecture ensures separation of concerns, making the codebase maintainable and testable.

### Key features of the project include:

1. A responsive carousel layout with smooth scrolling.
2. Support for displaying images, text, or custom views in each carousel item.
3. Customizable UI elements, including item spacing and pagination indicators.
4. Clean and maintainable codebase following MVVM best practices.
5. Data binding for efficient UI updates.
6. Easily extensible to add new features or adapt to various use cases.

This project serves as a template for creating carousel-based features in Android applications, providing developers with a well-structured foundation to build upon.

### Getting Started

To get started with the Carousel Layout project, follow the instructions below.

Prerequisites
Before you begin, ensure you have the following prerequisites:

1. Android Studio installed on your development machine.
2. Android SDK and emulator or physical Android device for testing.
3. Basic knowledge of Android app development and Kotlin programming.

### Installation
1. Clone the project repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the project on an Android emulator or device to see the carousel layout in action.

### Durectiry structure

| Direcory        | Explanation           
| ------------- | -------------| 
| di     | Dependency injection for network module | 
| network      | This package included all folders related to API call - request model, response model and API client classes |   
| ui | This package included sub packages of each feature in app and this subfolders will contain all necessary files on MVVM structure |  
| utils | This is utility package containing any common code for whole app |   
