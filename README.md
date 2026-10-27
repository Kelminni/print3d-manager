# Print3D Manager

A quote and order management system for a 3D printing business that offers custom prints in filament (FDM) and resin, with optional hand painting. Built with Java.

**Status:** work in progress. It is currently a console application and will evolve into a Spring Boot REST API.

## Why



## Features

- Collects the order details: customer name, model file, printing technology (filament or resin), material, amount of material, print time and painting option.
- Prints an order summary with the status "awaiting quote".

## Roadmap

- [x] Order summary with typed variables
- [ ] v0.1: quote calculation (material, machine time, painting and profit margin)
- [ ] v0.2: different pricing rules for filament and resin
- [ ] v0.3: orders with multiple parts
- [ ] v0.4: order list with status tracking (received, quoted, approved, printing, post-processing, painting, ready, delivered)
- [ ] v0.5: object-oriented design (Customer, Order, Part, Material)
- [ ] REST API with Spring Boot and PostgreSQL
- [ ] Upload of 3D models and photos to AWS S3, and cloud deployment

## How to run

Requirements: Java 21 (JDK).

From the project folder, run:

```bash
java src/Print3dManager.java
```

Or open the folder in VS Code and click **Run** above the `main` method.

## Author

Kelminni Cunha Pacheco · [LinkedIn](https://www.linkedin.com/in/kelminni-cunha-pacheco/)