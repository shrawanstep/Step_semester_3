# Week 6 Assignment – Gym Membership OOP

This project follows the Week 6 assignment sheet as a structured gym-membership OOP task.

## Assignment breakdown

1. Problem 1 – Basic validation and batch sign-up
   - `GymMember` validates member IDs
   - `signUpBatch(...)` rejects invalid entries without pre-checking the array

2. Problem 2 – Inheritance hierarchy
   - `PremiumMember` extends `GymMember`
   - `EliteMember` extends `PremiumMember`
   - `GroupClassMember` extends `GymMember`
   - `classifyGeneration(...)` uses `instanceof`

3. Problem 3 – Late fee discount and protected history
   - `PremiumMember` overrides `chargeLateFee(...)` and calls the parent logic
   - `getLateFeeHistory()` returns a defensive copy

4. Problem 4 – Polymorphic batch printing
   - `batchPrint(...)` uses `displayInfo()` and `StringBuilder`
   - premium trainer info is added using a guarded downcast

5. Problem 5 – Membership number, referral validation, fee payments, weekly check-ins
   - unique membership number generation
   - referral code validation using `charAt()` and character checks
   - overloaded `payFee(...)` methods
   - safe check-in processing with null handling

## Project structure
- `Main.java` – demonstration of each problem
- `gym/GymMember.java` – base class
- `gym/PremiumMember.java` – premium subclass
- `gym/EliteMember.java` – multilevel subclass
- `gym/GroupClassMember.java` – hierarchical sibling subclass

## Run
```bash
javac Main.java gym/*.java
java Main
```
