---
layout: docs
title: Temporal Generators
---

## {{page.title}}
Temporal generators provide the ability to generate Java 8+ Temporal values. 
These are values related to time and dates.

### Temporal API
The Temporal generators follow the Temporal API. 
This API has three possible subsets depending on the type of temporal value being generated but all follow the same naming structure.
The Temporal API is as follows:

| Name            | Example Usage                      |
| --------------- | ---------------------------------- |
| Distant Past    | `Generate.localDate.distantPast`   |
| Past            | `Generate.localDate.past`          |
| Recent          | `Generate.localDate.recent`        |
| Default         | `Generate.localDate.default`       |
| Soon            | `Generate.localDate.soon`          |
| Future          | `Generate.localDate.future`        |
| Distant Future  | `Generate.localDate.distantFuture` |

The generation scale for each of these values is relative to the scale of Temporal value being generated.
For example: 
    
`Generate.localTime.distantPast` will be on the scale of time and therefore measured in hours.
`Generate.localDateTime.distantPast` will be on the scale of dates and therefore measured in years.
