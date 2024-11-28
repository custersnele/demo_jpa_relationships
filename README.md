# JPA and Hibernate: Relationships and Advanced Mappings

This repository is a practical guide for understanding and implementing common entity relationships in JPA and Hibernate, such as **OneToOne**, **ManyToOne**, and **OneToMany**. It also demonstrates the use of advanced features like `orphanRemoval` and `CascadeType.ALL`.

## Contents

1. [Introduction](#introduction)
2. [Relationships](#relationships)
    - [OneToOne](#onetoone)
    - [OneToMany](#onetomany)
    - [ManyToOne](#manytoone)
3. [Advanced Features](#advanced-features)
    - [Cascade Operations](#cascade-operations)
    - [Orphan Removal](#orphan-removal)
4[Recommended Reading](#recommended-reading)

## Introduction

JPA and Hibernate provide powerful tools to define relationships between entities. Understanding these mappings is critical to building robust and maintainable applications. This repository includes examples and practical code snippets to illustrate:

- **OneToOne**: A single entity is related to another single entity.
- **ManyToOne**: Many entities relate to a single entity.
- **OneToMany**: A single entity relates to many entities.
- **ManyToMany**: Many entities relate to many entities.

## Relationships

### OneToOne

In a `OneToOne` relationship, one entity is associated with exactly one other entity. 
For example: the association between User and Subscription.

- **Cascade**: All operations on the User entity are cascaded to its associated Subscription entity. For example, if you
update the user, the subscription will be updated as well.
- **Orphan Removal**: When a subscription entity is removed from the User, it is automatically deleted from the database.

### ManyToOne
In a ManyToOne relationship, multiple entities relate to a single entity. Typically, this is used for relationships like many Researcher entities assigned to one Project.


### OneToMany
A OneToMany relationship associates one entity with multiple others. Example: the association
between Researcher and Project.

- **mappedBy**: Indicates the relationship is bidirectional and the Researcher entity owns the relationship.

### Advanced Features
- **Cascade Operations**

The CascadeType.ALL configuration automatically propagates all persistence operations (persist, merge, remove, refresh, detach) from a parent entity to its child entities.

- **Orphan Removal**
- 
The orphanRemoval = true configuration ensures that entities removed from an association are deleted from the database.

### Recommended Reading
For an in-depth discussion on the best way to map a OneToMany association with JPA and Hibernate, read this blog post by Vlad Mihalcea:

[The Best Way to Map a OneToMany Association with JPA and Hibernate](https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/)
